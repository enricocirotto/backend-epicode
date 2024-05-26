package it.nextdevs.gestioneDispositivi.controller;

import it.nextdevs.gestioneDispositivi.dto.DispositivoDto;
import it.nextdevs.gestioneDispositivi.exeption.DispositivoNonTrovatoException;
import it.nextdevs.gestioneDispositivi.exeption.ParametriErratiException;
import it.nextdevs.gestioneDispositivi.model.Dispositivo;
import it.nextdevs.gestioneDispositivi.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DispositivoController {
    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping("/dispositivi")
    public Page<Dispositivo> getAllDipendenti(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "15") int size,
                                              @RequestParam(defaultValue = "id") String sortBy) {
        return dispositivoService.getAllDispositivi(page, size, sortBy);
    }

    @GetMapping("/dispositivi/{id}")
    public Dispositivo getDispositivoById(@PathVariable Integer id) {
        Optional<Dispositivo> dispositivoOptional = dispositivoService.getDispositivoById(id);
        if (dispositivoOptional.isPresent()) {
            return dispositivoOptional.get();
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo con id "+id+" non trovato");
        }

    }
    @PostMapping("/dispositivi")
    public String saveDispositivo(@RequestBody @Validated DispositivoDto dispositivoDto,
                                 BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ParametriErratiException(bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .reduce("", ((s, s2) -> s+s2)));
        }
        return dispositivoService.salvaDispositivo(dispositivoDto);

    }

    @PutMapping("/dispositivi/{id}")
    public Dispositivo updateDispositivo(@PathVariable Integer id,
                                       @RequestBody @Validated DispositivoDto dispositivoDto,
                                       BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ParametriErratiException(bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .reduce("", ((s, s2) -> s+s2)));
        }
        return dispositivoService.aggiornaDispositivo(id, dispositivoDto) ;
    }

    @DeleteMapping("/dispositivi/{id}")
    public String deleteDispositivo(@PathVariable Integer id){
        return dispositivoService.eliminaDispositivo(id);
    }

    @PatchMapping("/dispositivi/{id}/dipendente")
    public String patchAssegnazioneDispositivo(@RequestBody String idDip,
                                               @PathVariable Integer id) {
        return dispositivoService.assegnaDispositivo(id, Integer.parseInt(idDip));
    }
}
