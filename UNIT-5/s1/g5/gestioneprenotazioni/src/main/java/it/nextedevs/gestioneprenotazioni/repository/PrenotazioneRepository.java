package it.nextedevs.gestioneprenotazioni.repository;

import it.nextedevs.gestioneprenotazioni.entity.Postazione;
import it.nextedevs.gestioneprenotazioni.entity.Prenotazione;
import it.nextedevs.gestioneprenotazioni.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
    List<Prenotazione> findByPostazioneAndGiorno(Postazione postazione, LocalDate giorno);
    List<Prenotazione> findByUtenteAndGiorno(Utente utente, LocalDate giorno);

}
