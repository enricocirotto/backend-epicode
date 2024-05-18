package it.nextedevs.gestioneprenotazioni.service;

import it.nextedevs.gestioneprenotazioni.entity.Utente;
import it.nextedevs.gestioneprenotazioni.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public void salva(Utente utente) {
        utenteRepository.save(utente);
    }

    public Utente findByUserName(String username) {
        return utenteRepository.findByUsername(username);
    }
}
