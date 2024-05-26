package it.nextdevs.gestioneDispositivi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.nextdevs.gestioneDispositivi.enums.StatoDispositivo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "dispositivi")
public class Dispositivo {
    @Id
    @GeneratedValue
    private Integer Id;
    private String modello;
    private String tipoDispositivo;
    private StatoDispositivo statoDispositivo;
    @ManyToOne
    @JoinColumn( name= "dipendente_id")
    @JsonIgnore
    private Dipendente dipendente;

}
