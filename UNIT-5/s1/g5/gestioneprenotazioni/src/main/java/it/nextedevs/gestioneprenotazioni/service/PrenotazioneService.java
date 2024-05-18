package it.nextedevs.gestioneprenotazioni.service;

import it.nextedevs.gestioneprenotazioni.entity.Postazione;
import it.nextedevs.gestioneprenotazioni.entity.Prenotazione;
import it.nextedevs.gestioneprenotazioni.entity.Utente;
import it.nextedevs.gestioneprenotazioni.enums.TipoPostazione;
import it.nextedevs.gestioneprenotazioni.repository.PostazioneRepository;
import it.nextedevs.gestioneprenotazioni.repository.PrenotazioneRepository;
import it.nextedevs.gestioneprenotazioni.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    public List<Postazione> ricercapostazione(TipoPostazione tipo, String citta){
        return postazioneRepository.findByTipoPostazioneAndEdificio_Citta(tipo, citta);
    }

    @Transactional
    public Prenotazione prenotaPostazione(String userName, Integer postazioneId, LocalDate data) throws Exception {
        Utente utente = utenteRepository.findByUsername(userName);
        if (utente == null) {
            throw new Exception("Utente non trovato");
        }
        Postazione postazione = postazioneRepository.findById(postazioneId).orElseThrow(() -> new RuntimeException("Postazione non trovata"));

        List<Prenotazione> prenotazioniUtente = prenotazioneRepository.findByUtenteAndGiorno(utente, data);
        if (!prenotazioniUtente.isEmpty()) {
            throw new Exception("L'utente ha già una prenotazione per questa data");
        }

        List<Prenotazione> prenotazioniPostazione = prenotazioneRepository.findByPostazioneAndGiorno(postazione, data);
        if (!prenotazioniPostazione.isEmpty()) {
            if (prenotazioniPostazione.size() + 1 > postazione.getNumeroMax()) {
                throw new Exception("La postazione è occupato in quella data");
            }
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setGiorno(data);

        return prenotazioneRepository.save(prenotazione);
    }

}
