package com.registropranzi.service.impl;

import com.registropranzi.dto.PrenotazioneDTO;
import com.registropranzi.model.Prenotazione;
import com.registropranzi.model.Utente;
import com.registropranzi.repository.PrenotazioneRepository;
import com.registropranzi.repository.UtenteRepository;
import com.registropranzi.service.PrenotazioneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class PrenotazioneServiceImpl implements PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;
    private final UtenteRepository utenteRepository;

    @Override
    public List<PrenotazioneDTO> findAll() {
        return prenotazioneRepository.findAll().stream().map(PrenotazioneDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<PrenotazioneDTO> findByDate(Date giorno) {
        return prenotazioneRepository.findByGiorno(giorno).stream().map(PrenotazioneDTO::new).collect(Collectors.toList());
    }

    @Override
    public PrenotazioneDTO updatePrenotazione(PrenotazioneDTO prenotazioneDTO) {

        if (prenotazioneDTO.id != null && prenotazioneRepository.existsById(prenotazioneDTO.id)) {
            Prenotazione prenotazione = prenotazioneRepository.findById(prenotazioneDTO.id).get();
            prenotazione.setCena(prenotazioneDTO.cena);
            prenotazione.setColazione(prenotazioneDTO.colazione);
            prenotazione.setPranzo(prenotazioneDTO.pranzo);
            prenotazione.setSacchettoCena(prenotazioneDTO.sacchettoCena);
            prenotazione.setSacchettoColazione(prenotazioneDTO.sacchettoColazione);
            prenotazione.setSacchettoPranzo(prenotazioneDTO.sacchettoPranzo);

            prenotazioneRepository.save(prenotazione);
            return new PrenotazioneDTO(prenotazione);
        }

        throw new RuntimeException("Errore, impossibile aggiornare le prenotazioni");
    }

    /**
     * Inserimento di una nuova prenotazione
     * @param prenotazioneDTO
     * @return PrenotazioneDTO
     */
    @Override
    public PrenotazioneDTO insertPrenotazione(PrenotazioneDTO prenotazioneDTO) {
        Prenotazione prenotazione = new Prenotazione(prenotazioneDTO);

        if(utenteRepository.existsById(prenotazioneDTO.getIdUtente())) {
            Utente utente = utenteRepository.findById(prenotazioneDTO.getIdUtente()).get();
            prenotazione.setUtente(utente);
            prenotazione = prenotazioneRepository.save(prenotazione);

            return new PrenotazioneDTO(prenotazione);
        }

        throw new RuntimeException("Errore durante l'inserimento");
    }
}
