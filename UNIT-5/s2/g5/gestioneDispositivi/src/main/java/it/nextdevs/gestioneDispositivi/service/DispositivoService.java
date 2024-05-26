package it.nextdevs.gestioneDispositivi.service;

import it.nextdevs.gestioneDispositivi.dto.DispositivoDto;
import it.nextdevs.gestioneDispositivi.enums.StatoDispositivo;
import it.nextdevs.gestioneDispositivi.exeption.DipendenteNonTrovatoException;
import it.nextdevs.gestioneDispositivi.exeption.DispositivoNonTrovatoException;
import it.nextdevs.gestioneDispositivi.model.Dipendente;
import it.nextdevs.gestioneDispositivi.model.Dispositivo;
import it.nextdevs.gestioneDispositivi.repository.DipendenteRepository;
import it.nextdevs.gestioneDispositivi.repository.DipositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DispositivoService {
    @Autowired
    private DipositivoRepository dispositivoRepository;
    @Autowired
    private DipendenteRepository dipendenteRepository;
    public Page<Dispositivo> getAllDispositivi(int page, int size, String sort){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return dispositivoRepository.findAll(pageable);

    }
    public Optional<Dispositivo>getDispositivoById(Integer id){
        return dispositivoRepository.findById(id);

    }
    public String salvaDispositivo(DispositivoDto dispositivoDto){
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setModello(dispositivoDto.getModello());
        dispositivo.setTipoDispositivo(dispositivoDto.getTipoDispositivo());
        dispositivo.setStatoDispositivo(dispositivoDto.getStatoDispositivo());
        dispositivoRepository.save(dispositivo);
        return"dispositivo creato con successo";

    }
    public Dispositivo aggiornaDispositivo(Integer id, DispositivoDto dispositivoDto){
        Optional<Dispositivo> dispositivoOptional=getDispositivoById(id);
        if(dispositivoOptional.isPresent()){
            Dispositivo dispositivo= dispositivoOptional.get();
            dispositivo.setModello(dispositivoDto.getModello());
            dispositivo.setTipoDispositivo(dispositivoDto.getTipoDispositivo());
            dispositivo.setStatoDispositivo(dispositivoDto.getStatoDispositivo());
            return dispositivoRepository.save(dispositivo);


        }
        else {
            throw new DispositivoNonTrovatoException("dispositivo con id " +id+ " non trovato");


        }
    }
    public String eliminaDispositivo(Integer id){
        Optional<Dispositivo> dispositivoOptional=getDispositivoById(id);
        if (dispositivoOptional.isPresent()){
            dispositivoRepository.delete(dispositivoOptional.get());
            return "dispositivo cancellato con successo";

        }else{
            throw new DispositivoNonTrovatoException("dispositivo con id " +id+ " non trovato");
        }

    }
    public String assegnaDispositivo(Integer idDis, Integer idDip) {
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(idDip);
        if (dipendenteOptional.isPresent()) {
            Optional<Dispositivo> dispositivoOptional = getDispositivoById(idDis);
            if (dispositivoOptional.isPresent()) {
                Dispositivo dispositivo = dispositivoOptional.get();
                dispositivo.setDipendente(dipendenteOptional.get());
                dispositivo.setStatoDispositivo(StatoDispositivo.ASSEGNATO);
                dispositivoRepository.save(dispositivo);
                return "Dispositivo con id "+idDis+" assegnato al dipendente con id "+idDip;
            } else {
                throw new DispositivoNonTrovatoException("Dispositivo con id "+idDis+" non trovato");
            }
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id "+idDip+" non trovato");
        }
    }

}


