package com.registropranzi.service;

import com.registropranzi.dto.DietaDTO;

import java.util.List;

public interface DietaService {

    List<DietaDTO> findAll();

    DietaDTO insertDieta(DietaDTO dieta);

    List<DietaDTO> deleteDieta(Long id);

    DietaDTO updateDieta(DietaDTO dieta);
}
