package com.registropranzi.service;

import com.registropranzi.dto.PrenotazioneDTO;
import com.registropranzi.model.Prenotazione;

import java.util.Date;
import java.util.List;

public interface PrenotazioneService {

    List<PrenotazioneDTO> findAll();

    List<PrenotazioneDTO> findByDate(Date data);

    PrenotazioneDTO updatePrenotazione(PrenotazioneDTO prenotazione);

    PrenotazioneDTO insertPrenotazione(PrenotazioneDTO prenotazione);

}
