package it.nextedevs.gestioneprenotazioni.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="utenti")
public class Utente {
    @Id
    private String username;
    private String nome;
    private String mail;
    @OneToMany(mappedBy = "utente", fetch = FetchType.EAGER)
    private List<Prenotazione> prenotazioni;

    @Override
    public String toString() {
        return "Utente{" +
                "mail='" + mail + '\'' +
                ", nome='" + nome + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
