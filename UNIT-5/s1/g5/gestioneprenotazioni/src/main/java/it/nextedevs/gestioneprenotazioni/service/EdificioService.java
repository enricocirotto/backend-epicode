package it.nextedevs.gestioneprenotazioni.service;

import it.nextedevs.gestioneprenotazioni.entity.Edificio;
import it.nextedevs.gestioneprenotazioni.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void salva(Edificio edificio){
        edificioRepository.save(edificio);
    }
    public Edificio findbyId(Integer Id){
        return edificioRepository.findById(Id).orElseThrow();
    }
}
