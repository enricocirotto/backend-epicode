package nextdevs.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "utente_numero_di_tessera")
    private Utente utente;
    @OneToOne
    @JoinColumn(name = "catalogo_codice_isbn")
    private Catalogo catalogo;
    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrevisto;
    @Column(name = "data_restituzione_prevista")
    private LocalDate dataRestituzionePrevista;
    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    public Prestito(Utente utente, Catalogo catalogo, LocalDate dataInizioPrevisto) {
        this.utente = utente;
        this.catalogo = catalogo;
        this.dataInizioPrevisto = dataInizioPrevisto;
        this.dataRestituzionePrevista = dataInizioPrevisto.plusDays(30);

    }

    public Prestito() {
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public void setDataInizioPrevisto(LocalDate dataInizioPrevisto) {
        this.dataInizioPrevisto = dataInizioPrevisto;
        this.dataRestituzionePrevista=dataInizioPrevisto.plusDays(30);
    }



    public Integer getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public LocalDate getDataInizioPrevisto() {
        return dataInizioPrevisto;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;

    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", catalogo=" + catalogo +
                ", dataInizioPrevisto=" + dataInizioPrevisto +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}

