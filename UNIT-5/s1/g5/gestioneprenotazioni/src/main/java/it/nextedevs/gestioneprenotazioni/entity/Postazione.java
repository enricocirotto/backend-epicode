package it.nextedevs.gestioneprenotazioni.entity;

import it.nextedevs.gestioneprenotazioni.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.ToString;

import java.util.List;

@Table(name="postazioni")
@Entity
@Data
public class Postazione {
    @Id
    @GeneratedValue
    private Integer id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    private Integer numeroMax;
    @ManyToOne
    @JoinColumn(name="edificio_id")
    private Edificio edificio;
    @OneToMany (mappedBy = "postazione", fetch = FetchType.EAGER)
    private List<Prenotazione> prenotazioni;

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                ", numeroMax=" + numeroMax +
                ", edificio=" + edificio +
                '}';
    }
}


