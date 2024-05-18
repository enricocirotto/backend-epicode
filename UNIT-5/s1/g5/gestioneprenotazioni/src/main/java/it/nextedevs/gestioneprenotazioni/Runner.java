package it.nextedevs.gestioneprenotazioni;

import it.nextedevs.gestioneprenotazioni.entity.Edificio;
import it.nextedevs.gestioneprenotazioni.entity.Postazione;
import it.nextedevs.gestioneprenotazioni.entity.Prenotazione;
import it.nextedevs.gestioneprenotazioni.entity.Utente;
import it.nextedevs.gestioneprenotazioni.enums.TipoPostazione;
import it.nextedevs.gestioneprenotazioni.service.EdificioService;
import it.nextedevs.gestioneprenotazioni.service.PostazioneService;
import it.nextedevs.gestioneprenotazioni.service.PrenotazioneService;
import it.nextedevs.gestioneprenotazioni.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@PropertySource("application.properties")
public class Runner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneService prenotazioneService;
    @Override
    public void run(String... args) throws Exception {
//        Edificio  edificio1= new Edificio();
//        edificio1.setCitta("Sassari");
//        edificio1.setIndirizzo("ViaMuzzu");
//        edificio1.setNome("MuzzuBuilding");
//        edificioService.salva(edificio1);
//        Edificio edificio2= edificioService.findbyId(1);
//        Postazione postazione1= new Postazione();
//        postazione1.setDescrizione("la postazione è adibita a Muzzu");
//        postazione1.setTipoPostazione(TipoPostazione.OPENSPACE);
//        postazione1.setEdificio(edificio2);
//        postazione1.setNumeroMax(10);
//        postazioneService.salva(postazione1);
//        Utente utente1= new Utente();
//        utente1.setNome("Muzzu Matteo");
//        utente1.setMail("muzzumail");
//        utente1.setUsername("muzzuismuzzu");
//        utenteService.salva(utente1);
//        try {
//            Prenotazione prenotazione = prenotazioneService.prenotaPostazione("muzzuismuzzu", 1, LocalDate.now());
//            System.out.println(prenotazione);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
    }


}


