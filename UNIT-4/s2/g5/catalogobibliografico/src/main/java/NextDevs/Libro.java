package NextDevs;

import java.time.LocalDate;


public class Libro extends Catalogo {
    private String autore;
    private String genere;


    public Libro(String codiceISBN, String titolo, LocalDate annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }



    public String getGenere() {
        return genere;
    }

}
