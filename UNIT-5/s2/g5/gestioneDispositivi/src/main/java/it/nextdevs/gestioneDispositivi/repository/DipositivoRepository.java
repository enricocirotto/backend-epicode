package it.nextdevs.gestioneDispositivi.repository;

import it.nextdevs.gestioneDispositivi.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipositivoRepository extends JpaRepository<Dispositivo,Integer > {
}
