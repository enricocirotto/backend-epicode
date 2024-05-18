package it.nextedevs.gestioneprenotazioni.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Table(name="prenotazioni")
@Entity
@Data
public class Prenotazione {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name="utente_id")
    private Utente utente;
    private LocalDate giorno;
    @ManyToOne
    @JoinColumn(name="postazione_id")
    private Postazione postazione;

}
