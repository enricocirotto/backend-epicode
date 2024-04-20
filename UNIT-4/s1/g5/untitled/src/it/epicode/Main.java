package it.epicode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];
        for (int i  = 0; i < elementi.length ; i++) {
            int risultato;
            do {
                System.out.println("che elemento vuoi creare \n digita \n1 imagine \n2 video \n3 audio ");
                 risultato = scanner.nextInt();
                 if( risultato<1 || risultato>3){
                     System.out.println("dev inserire un numero positivo e che sia tra quelli indicati precedentemente");
                 }
            } while( risultato<1 || risultato>3);
            scanner.nextLine();
            System.out.println("inserisci un titolo");

            String title= scanner.nextLine();
            int luminosita;
            int volume;
            int durata;
            switch (risultato){
                case 1:

                    do {
                        System.out.println("quanta luminosita da 1 a 10");
                        luminosita = scanner.nextInt();
                        if(luminosita<0 || luminosita>10){
                            System.out.println("devi inserire un numero positivo che sia compreso tra 1 e 10");
                        }
                    }while (luminosita<0 || luminosita>10);
                    Immagine immagine = new Immagine(title, luminosita);
                    elementi [i] = immagine;
                    break;
                case 2:

                    do {
                        System.out.println("quanta luminosita da 1 a 10");
                        luminosita = scanner.nextInt();
                        if(luminosita<0 || luminosita>10){
                            System.out.println("devi inserire un numero positivo che sia compreso tra 1 e 10");
                        }
                    }while (luminosita<0 || luminosita>10);

                    do {
                        System.out.println("quanta durata avra il video da 1 a 10");
                        durata= scanner.nextInt();
                        if(durata<0 || durata>10){
                            System.out.println("devi inserire un numero positivo che sia compreso tra 0 a quanto desiderato");
                        }
                    }while (durata<0 );

                    do {
                        System.out.println("quanto volume da 1 a 10");
                        volume = scanner.nextInt();
                        if(volume<0 || volume>10){
                            System.out.println("devi inserire un numero positivo che sia compreso tra 1 e 10");
                        }
                    }while (volume<0 || volume>10);

                    Video video = new Video(title, durata, volume, luminosita);
                    elementi[i] = video;


                    break;
                case 3:
                    do {
                        System.out.println("quanta durata avra il video da 1 a 10");
                        durata= scanner.nextInt();
                        if(durata<0 || durata>10){
                            System.out.println("devi inserire un numero positivo che sia compreso tra 0 a quanto desiderato");
                        }
                    }while (durata<0 );

                    do {
                        System.out.println("quanto volume da 1 a 10");
                        volume = scanner.nextInt();
                        if(volume<0 || volume>10){
                            System.out.println("devi inserire un numero positivo che sia compreso tra 1 e 10");
                        }

                    }while (volume<0 || volume>10);
                    Audio audio = new Audio(title, durata, volume);
                    elementi[i] = audio;

                    break;
                default:
                    break;

            }
        }

       /* Audio audio1= new Audio("muzzu", 30, 7);
        audio1.play();
        Video video1= new Video("ciao", 10, 2, 5);
        video1.play();
        Immagine immagine1= new Immagine("img", 10);
        immagine1.show(); */
int scelta;
do{
    System.out.println("scegli un numero tra 1 e 5 elementi multimediali creati");
    scelta = scanner.nextInt();
    if (scelta==0){
        System.out.println( "hai scelto di terminare il programma");
    }else if(scelta>0 && scelta<= elementi.length){
        System.out.println("hai scelto il file multimediale chiamato "+elementi[scelta-1].getTitle());
        if(elementi[scelta-1] instanceof Immagine){
            elementi[scelta-1].show();

        }else{ elementi[scelta-1].play();}
    }else{
        System.out.println("devi inserire un numero tra 1 e 5");
    }


}while (scelta != 0);

    }
}
