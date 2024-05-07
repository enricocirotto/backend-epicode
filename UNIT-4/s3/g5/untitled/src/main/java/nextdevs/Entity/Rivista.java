package nextdevs.Entity;

import nextdevs.Enums.Periodicita;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "riviste")
public class Rivista extends Catalogo {

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;


    public Rivista(String codiceISBN, String titolo, Integer annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Rivista() {
        super();
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
