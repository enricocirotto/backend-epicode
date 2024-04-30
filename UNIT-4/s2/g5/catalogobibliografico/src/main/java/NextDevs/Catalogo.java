package NextDevs;

import java.time.LocalDate;


public class Catalogo {
    private String codiceISBN;
    private String titolo;
    private LocalDate annoPubblicazione;
    private int numeroPagine;

    public Catalogo(String codiceISBN, String titolo, LocalDate annoPubblicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getCodiceISBN() {
        return codiceISBN;
    }


    public String getTitolo() {
        return titolo;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }




    @Override
    public String toString() {
        return "Catalogo{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    public String libro(Libro lbr){
        return codiceISBN+
                ","+titolo+
                ","+annoPubblicazione+
                ","+numeroPagine+
                ","+lbr.getAutore()+
                ","+lbr.getGenere();
    }

    public String rivista(Rivista rvst){
        return codiceISBN+
                ","+titolo+
                ","+annoPubblicazione+
                ","+numeroPagine+
                ","+rvst.getPeriodicita();
    }


}
