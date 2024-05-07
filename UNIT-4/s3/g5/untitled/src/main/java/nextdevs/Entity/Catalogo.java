package nextdevs.Entity;

import javax.persistence.*;

@Entity
@Table(name = "cataloghi")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Catalogo {
    @Id
    @Column(name = "codice_isbn")
    private String codiceISBN;
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private Integer annoPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;

    public Catalogo(String codiceISBN, String titolo, Integer annoPubblicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public Catalogo() {

    }

    public String getCodiceISBN() {
        return codiceISBN;
    }


    public String getTitolo() {
        return titolo;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setCodiceISBN(String codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
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
        return
                "#"+codiceISBN+
                        "@"+titolo+
                        "@"+annoPubblicazione+
                        "@"+numeroPagine+
                        "@"+lbr.getAutore()+
                        "@"+lbr.getGenere();
    }

    public String rivista(Rivista rvst){
        return "#"+codiceISBN+
                "@"+titolo+
                "@"+annoPubblicazione+
                "@"+numeroPagine+
                "@"+rvst.getPeriodicita();
    }

}

