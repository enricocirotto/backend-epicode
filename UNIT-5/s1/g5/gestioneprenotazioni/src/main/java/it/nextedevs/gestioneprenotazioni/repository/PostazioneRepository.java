package it.nextedevs.gestioneprenotazioni.repository;

import it.nextedevs.gestioneprenotazioni.entity.Postazione;
import it.nextedevs.gestioneprenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
    List<Postazione> findByTipoPostazioneAndEdificio_Citta(TipoPostazione tipo, String citta);
}
