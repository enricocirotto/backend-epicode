package NextDevs;



import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Archivio archivio=new Archivio();
        //LIBRI
        try {
        archivio.aggiungiProdotto(new Libro("1001","Il richiamo di Cthulhu",
                LocalDate.of(1928,2,26),562,"H.P. Lovecraft","Horror"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
       try {
        archivio.aggiungiProdotto(new Libro("1002","Nel terrore notturno",
                LocalDate.of(1936,11,2),160 ,"H.P. Lovecraft","Horror"));
       } catch (Exception e) {
           System.err.println(e.getMessage());
       }
       try {
        archivio.aggiungiProdotto(new Libro("1003","Le montagne della follia",
                LocalDate.of(1936,3,8),150,"H.P. Lovecraft","Horror"));
       } catch (Exception e) {
           System.err.println(e.getMessage());
       }
       try {
        archivio.aggiungiProdotto(new Libro("1004","Il colore venuto dallo spazio",
                LocalDate.of(1927,5,8),40,"H.P. Lovecraft","Horror"));
       } catch (Exception e) {
           System.err.println(e.getMessage());
       }
       try {
        archivio.aggiungiProdotto(new Libro("1005","La maschera di Innsmouth",
                LocalDate.of(1936,6,11),100,"H.P. Lovecraft","Horror"));
       } catch (Exception e) {
           System.err.println(e.getMessage());
       }
       try {
        archivio.aggiungiProdotto(new Libro("1006","L'orrore di Dunwich",
                LocalDate.of(1937,12,12),116,"H.P. Lovecraft","Horror"));
       } catch (Exception e) {
           System.err.println(e.getMessage());
       }
       try {
        archivio.aggiungiProdotto(new Libro("1007","La cosa sulla soglia ",
                LocalDate.of( 1937,9,1),30,"H.P. Lovecraft","Horror"));
       } catch (Exception e) {
           System.err.println(e.getMessage());
       }
       try {
        archivio.aggiungiProdotto(new Libro("1008","La musica di Erich Zann",
                LocalDate.of(1922,3,31),15,"H.P. Lovecraft","Horror"));
       } catch (Exception e) {
           System.err.println(e.getMessage());
       }


       //RIVISTE
        try {
        archivio.aggiungiProdotto(new Rivista("2001","forbes",
                LocalDate.of(2024,2,22),30,Periodicita.SETTIMANALE));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
        archivio.aggiungiProdotto(new Rivista("2002","millionaire",
                LocalDate.of(2024,2,22),30,Periodicita.MENSILE));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
        archivio.aggiungiProdotto(new Rivista("2003","sole24ore",
                LocalDate.of(2024,2,22),30,Periodicita.SETTIMANALE));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("---");

        try {
            archivio.rimuoviProdotto("1008");
            System.out.println("Rimozione avvenuta");
        } catch (Exception e) {
            System.err.println("Errore: "+e.getMessage());
        }

        System.out.println("---");
        System.out.println("Ricerca ISBN: "+archivio.cercaPerISBN("3000"));
        List<Catalogo> prodottiAnno2024 = archivio.ricercaPerAnnoPubblicazione(LocalDate.of(2024, 1,
                1));

        System.out.println("---");
        System.out.println("Catalogo 2024:");
        prodottiAnno2024.forEach(System.out::println);


        System.out.println("---");
        List<Catalogo> ricercaAutore=archivio.cercaPerAutore("H.P. Lovecraft");
        System.out.println("Libri H.P. Lovecraft");
        ricercaAutore.forEach(System.out::println);
        System.out.println("---");

        try {
            archivio.salvaSulDisco("archivioDati.txt");
            System.out.println("File salvato ");
        }catch (IOException e){
            System.out.println("Errore nel salvataggio del file");
        }
        System.out.println("---");
        try {
            List<Catalogo> archivioCaricato=archivio.caricamentoSulDisco("archivioDati.txt");
            System.out.println("Archivio caricato da disco:");
            archivioCaricato.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Errore caricamento file");
        }
   }
}
