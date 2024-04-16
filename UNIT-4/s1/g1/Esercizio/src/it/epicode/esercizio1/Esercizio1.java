package it.epicode.esercizio1;

import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chiedi all'utente di inserire tre stringhe
        System.out.print("Inserisci la prima stringa: ");
        String stringa1 = scanner.nextLine();

        System.out.print("Inserisci la seconda stringa: ");
        String stringa2 = scanner.nextLine();

        System.out.print("Inserisci la terza stringa: ");
        String stringa3 = scanner.nextLine();

        // Concatena le stringhe in ordine inverso e stampa il risultato
        String concatenazione = concatenaInverso(stringa1, stringa2, stringa3);
        System.out.println("La concatenazione delle stringhe in ordine inverso è: " + concatenazione);

        // Chiudi lo scanner
        scanner.close();
    }

    public static String concatenaInverso(String str1, String str2, String str3) {
        // Concatena le stringhe in ordine inverso di inserimento
        return str3 + str2 + str1;
    }
}
