package it.nextedevs.gestioneprenotazioni.repository;

import it.nextedevs.gestioneprenotazioni.entity.Edificio;
import it.nextedevs.gestioneprenotazioni.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, String> {
    public Utente findByUsername(String username);

}
