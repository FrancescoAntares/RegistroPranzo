package com.registropranzi.service.impl;

import com.registropranzi.dto.UtenteDTO;
import com.registropranzi.model.Dieta;
import com.registropranzi.model.Utente;
import com.registropranzi.repository.DietaRepository;
import com.registropranzi.repository.UtenteRepository;
import com.registropranzi.service.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UtenteServiceImpl implements UtenteService {

    private final UtenteRepository utenteRepository;
    private final DietaRepository dietaRepository;

    @Override
    public UtenteDTO insertUtente(UtenteDTO utenteDTO) {
        Utente utente = new Utente(utenteDTO);

        //inserimento dieta associata
        if (dietaRepository.existsById(utenteDTO.idDieta)) {
            Dieta dieta = dietaRepository.findById(utenteDTO.idDieta).get();
            utente.setDieta(dieta);
            utente = utenteRepository.save(utente);

            return new UtenteDTO(utente);
        }

        throw new RuntimeException("Errore generico durante l'inserimento dell'utente");

    }

    @Override
    public List<UtenteDTO> deleteUtente(Long id) {
        utenteRepository.deleteById(id);

        return utenteRepository.findAll().stream().map(UtenteDTO::new).collect(Collectors.toList());
    }

    @Override
    public UtenteDTO getDetails(Long id) {
        Utente utente = utenteRepository.findById(id).get();

        return new UtenteDTO(utente);

    }

    @Override
    public UtenteDTO updateUtente(UtenteDTO utenteDTO) {

        if (utenteDTO.id != null && utenteRepository.existsById(utenteDTO.id)) {
            Utente utente = utenteRepository.findById(utenteDTO.id).get();
            utente.setNome(utenteDTO.nome);
            utente.setCognome(utenteDTO.cognome);
            utente.setAdmin(utenteDTO.admin);
            utente.setPassword(utenteDTO.password);

            utenteRepository.save(utente);
            return new UtenteDTO(utente);
        }

        throw new RuntimeException("Errore, impossibile aggiornare le impostazioni utente");
    }
}
