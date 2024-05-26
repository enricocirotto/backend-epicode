package it.nextdevs.gestioneDispositivi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table (name = "dipendenti")
public class Dipendente {
    @Id
    @GeneratedValue
    private Integer Id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String avatar;
@OneToMany(mappedBy = "dipendente")
    private List<Dispositivo> dispositivi;


}
