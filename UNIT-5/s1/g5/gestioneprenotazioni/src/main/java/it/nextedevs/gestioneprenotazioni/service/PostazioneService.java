package it.nextedevs.gestioneprenotazioni.service;

import it.nextedevs.gestioneprenotazioni.entity.Edificio;
import it.nextedevs.gestioneprenotazioni.entity.Postazione;
import it.nextedevs.gestioneprenotazioni.repository.EdificioRepository;
import it.nextedevs.gestioneprenotazioni.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void salva(Postazione postazione){
        postazioneRepository.save(postazione);
    }
    public Postazione findbyId(Integer Id){
        return postazioneRepository.findById(Id).orElseThrow();
    }
}
