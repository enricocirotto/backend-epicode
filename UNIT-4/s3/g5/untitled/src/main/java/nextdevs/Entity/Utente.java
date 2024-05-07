package nextdevs.Entity;

import  javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue
    @Column(name = "numero_di_tessera")
    private Integer numeroDiTessera;
    private String nome;
    private String cognome;
    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;


    @OneToMany(mappedBy = "utente")
    private List<Prestito>prestiti;

    public Utente(String nome, String cognome, LocalDate dataDiNascita, Integer numeroDiTessera) {

        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroDiTessera = numeroDiTessera;
        this.prestiti=new ArrayList<>();
    }

    public Utente() {
        this.prestiti=new ArrayList<>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public void setNumeroDiTessera(Integer numeroDiTessera) {
        this.numeroDiTessera = numeroDiTessera;
    }



    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public Integer getNumeroDiTessera() {
        return numeroDiTessera;
    }
}

