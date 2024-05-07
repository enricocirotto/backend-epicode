package nextdevs;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import nextdevs.Dao.CatalogoDao;
import nextdevs.Dao.PrestitoDao;
import nextdevs.Dao.UtenteDao;
import nextdevs.Entity.*;
import nextdevs.Enums.Periodicita;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneevnti");
        EntityManager em = emf.createEntityManager();


        CatalogoDao catalogoDao=new CatalogoDao(em);
        UtenteDao utenteDao=new UtenteDao(em);
        PrestitoDao prestitoDao=new PrestitoDao(em);

        // Libri
        System.out.println("---");
        System.out.println("aggiunta catalogo libri");
        Libro libro1=new Libro();
        libro1.setCodiceISBN("1001");
        libro1.setTitolo("Il richiamo di Cthulhu");
        libro1.setAnnoPubblicazione(1928);
        libro1.setNumeroPagine(562);
        libro1.setAutore("H.P. Lovecraft");
        libro1.setGenere("Horror");

        try {
            catalogoDao.save(libro1);
            System.out.println("salvato con successo");
        }catch (Exception e){
            System.out.println("prodotto duplicato");
        }

        System.out.println("---");

        Libro libro2 =new Libro();
        libro2.setCodiceISBN("1002");
        libro2.setTitolo("Nel terrore notturno");
        libro2.setAnnoPubblicazione(1936);
        libro2.setNumeroPagine(160);
        libro2.setAutore("H.P. Lovecraft");
        libro2.setGenere("Horror");

        try {
            catalogoDao.save(libro2);
            System.out.println("salvato con successo");
        }catch (Exception e){
            System.out.println("prodotto duplicato");
        }

        System.out.println("---");

        // RIVISTE
        System.out.println("---");
        System.out.println("prodotti riviste");
        Rivista rivista1=new Rivista();
        rivista1.setCodiceISBN("2001");
        rivista1.setTitolo("forbes");
        rivista1.setNumeroPagine(30);
        rivista1.setAnnoPubblicazione( 2024);
        rivista1.setPeriodicita( Periodicita.SETTIMANALE);

        try {
            catalogoDao.save(rivista1);
            System.out.println("salvato con successo");
        }catch (Exception e){
            System.out.println("prodotto duplicato");
        }

        System.out.println("---");

        Rivista rivista2 =new Rivista();
        rivista2.setCodiceISBN("2002");
        rivista2.setTitolo("millionare");
        rivista2.setNumeroPagine(30);
        rivista2.setAnnoPubblicazione( 2024);
        rivista2.setPeriodicita( Periodicita.MENSILE);

        try {
            catalogoDao.save(rivista2);
            System.out.println("salvato con successo");
        }catch (Exception e){
            System.out.println("prodotto duplicato");
        }

        System.out.println("---");

        System.out.println("---");
        System.out.println("Delete");
        try {
            Catalogo catalogo= catalogoDao.getById("125");
            if (catalogo !=null) {
                catalogoDao.delete(catalogo);
                System.out.println("prodotto eliminato con successo");
            }else {
                throw new RuntimeException("prodotto non esistente");
            }
        }catch (Exception e){
            System.err.println("Errore: "+e.getMessage());
        }

        try {
            Catalogo catalogo= catalogoDao.getById("3001");
            if (catalogo !=null) {
                catalogoDao.delete(catalogo);
                System.out.println("prodotto eliminato con successo");

            }else {
                throw new RuntimeException("prodotto non esistente");
            }
        }catch (Exception e){
            System.err.println("Errore: "+e.getMessage());
        }

        //PRODOTTI PER ISBN
        System.out.println("---");
        System.out.println("ricerca prodotti per ISBN");

        Catalogo findCatalogo=catalogoDao.getById("3001");
        if (findCatalogo !=null){
            System.out.println(findCatalogo);
        }else {
            System.err.println("prodotto non esiste");
        }

        //PRODOTTI PER AUTORE
        System.out.println("---");
        System.out.println("ricerca prodotti per autore");
        List<Catalogo>  findProdottoFromAutore=catalogoDao.findByAutore("H.P. Lovecraft");
        if (findProdottoFromAutore.isEmpty()){
            System.out.println("nessun risultato trovato");
        }else {
            findProdottoFromAutore.forEach(System.out::println);
        }

        //PRODOTTI PER ANNO 1997
        System.out.println("---");
        System.out.println("ricerca prodotti per anno");
        List<Catalogo> catalogosByAnno=catalogoDao.findByAnno(1928);
        if (catalogosByAnno.isEmpty()){
            System.out.println("nessun prodotto trovato per quest'anno ");
        }else {
            catalogosByAnno.forEach(System.out::println);
        }

        //PRODOTTI PER TITOLO
        System.out.println("---");
        System.out.println("ricerca prodotti per titolo");
        List<Catalogo> catalogosByTitolo=catalogoDao.findByTitolo("Cthulhu");
        if (catalogosByTitolo.isEmpty()){
            System.out.println("nessun prodotto trovato per titolo");
        }else {
            catalogosByTitolo.forEach(System.out::println);
        }

        // UTENTI
        System.out.println("---");
        System.out.println("aggiunta utenti");
        Utente utente1=new Utente();
        utente1.setNome("enrico");
        utente1.setCognome("cirotto");
        utente1.setDataDiNascita(LocalDate.of(2001,2,1));
        try {
            utenteDao.save(utente1);
            System.out.println("utente salvato correttamente");
        }catch (Exception e){
            System.err.println("tessera utente già esistente ");
        }

        System.out.println("---");
        Utente utente2 =new Utente();
        utente2.setNome("matteo");
        utente2.setCognome("muzzu");
        utente2.setDataDiNascita(LocalDate.of(1997,11,21));
        try {
            utenteDao.save(utente2);
            System.out.println("utente salvato correttamente");
        }catch (Exception e){
            System.err.println("tessera utente già esistente ");
        }

        //PRESTITO
        System.out.println("---");
        System.out.println("prestiti");
        Prestito prestito1=new Prestito();
        prestito1.setUtente(utenteDao.getById(1));
        prestito1.setDataInizioPrevisto(LocalDate.now());
        prestito1.setCatalogo(catalogoDao.getById("2001"));
        try {
            prestitoDao.save(prestito1);
            System.out.println("prestito creato con successo");
        }catch (Exception e){
            System.err.println("Errore: "+e.getMessage());
        }

        System.out.println("---");

        Prestito prestito2 =new Prestito();
        prestito2.setUtente(utenteDao.getById(2));
        prestito2.setDataInizioPrevisto(LocalDate.now());
        prestito2.setCatalogo(catalogoDao.getById("2002"));
        try {
            prestitoDao.save(prestito2);
            System.out.println("prestito creato con successo");
        }catch (Exception e){
            System.err.println("Errore: "+e.getMessage());
        }

        //RICERCA DI PRESTITI CON NUMERO DI TESSERA
        System.out.println("---");
        System.out.println("ricerca prestiti con n tessera");
        List<Catalogo> prodottiPrestito=prestitoDao.getCatalogoFromId(2);
        prodottiPrestito.forEach(System.out::println);

        //RICERCA DI PRESTITI SCADUTI
        System.out.println("---");
        System.out.println("ricerca prestiti scaduti");
        List<Prestito> prestitiNonRestituiti=prestitoDao.getPrestitoScadutoNonConsegnato();
        prestitiNonRestituiti.forEach(System.out::println);
    }
}
