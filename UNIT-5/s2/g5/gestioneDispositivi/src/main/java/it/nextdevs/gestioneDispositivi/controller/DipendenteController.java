package it.nextdevs.gestioneDispositivi.controller;

import it.nextdevs.gestioneDispositivi.dto.DipendenteDto;
import it.nextdevs.gestioneDispositivi.exeption.DipendenteNonTrovatoException;
import it.nextdevs.gestioneDispositivi.exeption.ParametriErratiException;
import it.nextdevs.gestioneDispositivi.model.Dipendente;
import it.nextdevs.gestioneDispositivi.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping("/dipendenti")
    public Page<Dipendente> getAllDipendenti(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "15") int size,
                                             @RequestParam(defaultValue = "id") String sortBy) {
        return dipendenteService.getAllDipendenti(page, size, sortBy);
    }

@GetMapping("/dipendenti/{id}")
    public Dipendente getDipendenteById(@PathVariable Integer id) {
        Optional<Dipendente> dipendenteOptional = dipendenteService.getDipendenteById(id);
        if (dipendenteOptional.isPresent()) {
            return dipendenteOptional.get();
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id "+id+" non trovato");
        }

}
@PostMapping("/dipendenti")
    public String saveDipendente(@RequestBody @Validated DipendenteDto dipendenteDto,
                                 BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ParametriErratiException(bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .reduce("", ((s, s2) -> s+s2)));
        }
        return dipendenteService.saveDipendente(dipendenteDto);

}

@PutMapping("/dipendenti/{id}")
    public Dipendente updateDipendente(@PathVariable Integer id,
                                       @RequestBody @Validated DipendenteDto dipendenteDto,
                                       BindingResult bindingResult){
    if (bindingResult.hasErrors()){
        throw new ParametriErratiException(bindingResult.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .reduce("", ((s, s2) -> s+s2)));
    }
    return dipendenteService.updateDipendente(id, dipendenteDto) ;
}

    @DeleteMapping("/dipendenti/{id}")
    public String deleteDipendente(@PathVariable Integer id){
        return dipendenteService.deleteDipendente(id);
        }
    @PatchMapping("/dipendenti/{id}")
    public String patchAvatarDipendente(@RequestBody MultipartFile avatar,
                                        @PathVariable Integer id) throws IOException {
        return dipendenteService.patchAvatar(id, avatar);
    }

}


