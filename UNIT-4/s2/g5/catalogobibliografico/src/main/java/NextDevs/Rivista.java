package NextDevs;

import java.time.LocalDate;


public class Rivista extends Catalogo {

    private  Periodicita periodicita;


    public Rivista(String codiceISBN, String titolo, LocalDate annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }


}
