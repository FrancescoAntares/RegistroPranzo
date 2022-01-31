package com.registropranzi.service.impl;

import com.registropranzi.dto.DietaDTO;
import com.registropranzi.dto.UtenteDTO;
import com.registropranzi.model.Dieta;
import com.registropranzi.model.Utente;
import com.registropranzi.repository.DietaRepository;
import com.registropranzi.service.DietaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DietaServiceImpl implements DietaService {

    private final DietaRepository dietaRepository;

    @Override
    public List<DietaDTO> findAll() {
        return dietaRepository.findAll().stream().map(DietaDTO::new).collect(Collectors.toList());
    }

    @Override
    public DietaDTO insertDieta(DietaDTO dietaDTO) {
        Dieta dieta = new Dieta(dietaDTO);
        dieta = dietaRepository.save(dieta);

        return new DietaDTO(dieta);
    }

    @Override
    public List<DietaDTO> deleteDieta(Long id) {
        dietaRepository.deleteById(id);

        return dietaRepository.findAll().stream().map(DietaDTO::new).collect(Collectors.toList());
    }

    @Override
    public DietaDTO updateDieta(DietaDTO dietaDTO) {

        if (dietaDTO.id != null && dietaRepository.existsById(dietaDTO.id)) {
            Dieta dieta = dietaRepository.findById(dietaDTO.id).get();
            dieta.setDescrizione(dietaDTO.descrizione);

            return new DietaDTO(dieta);
        }

        throw new RuntimeException("Errore, impossibile aggiornare la descrizione della dieta");
    }
}
