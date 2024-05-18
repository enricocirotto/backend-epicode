package it.nextedevs.gestioneprenotazioni.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="edifici")
public class Edificio {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String citta;
    private String indirizzo;
    @OneToMany(mappedBy = "edificio", fetch = FetchType.EAGER)
    private List<Postazione> listaPostazioni;

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}
