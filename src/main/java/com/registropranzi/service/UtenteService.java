package com.registropranzi.service;

import com.registropranzi.dto.UtenteDTO;

import java.util.List;

public interface UtenteService {

    UtenteDTO insertUtente(UtenteDTO utente);

    UtenteDTO getDetails(Long id);

    UtenteDTO updateUtente(UtenteDTO utente);

    List<UtenteDTO> deleteUtente(Long id);
}
