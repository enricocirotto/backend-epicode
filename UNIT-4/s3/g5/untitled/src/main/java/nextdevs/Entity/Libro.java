package nextdevs.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "libri")

public class Libro extends Catalogo {
    private String autore;
    private String genere;


    public Libro(String codiceISBN, String titolo, Integer annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }


    public Libro() {
        super();
    }

    public String getAutore() {
        return autore;
    }



    public String getGenere() {
        return genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
