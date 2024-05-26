package it.nextdevs.gestioneDispositivi.exeption;

public class DispositivoNonTrovatoException extends RuntimeException{
    public DispositivoNonTrovatoException(String message) {
        super(message);
    }
}
