package com.registropranzi.controller;

import com.registropranzi.dto.DietaDTO;
import com.registropranzi.dto.UtenteDTO;
import com.registropranzi.service.DietaService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(
        path = "/api/dieta",
        produces = "application/json"
)
@AllArgsConstructor
public class DietaController {

    private final DietaService dietaService;

    @PostMapping("/new")
    public DietaDTO insertDieta(@Valid @RequestBody DietaDTO dietaDTO) {
        return dietaService.insertDieta(dietaDTO);
    }

    @GetMapping("/all")
    public List<DietaDTO> findAll() {
        return dietaService.findAll();
    }

    @DeleteMapping("/delete")
    public List<DietaDTO> deleteDieta(@NonNull @RequestParam Long id) {
        return dietaService.deleteDieta(id);
    }

    @PutMapping("/update")
    public DietaDTO updateDieta(@Valid @RequestBody DietaDTO dietaDTO) {
        return dietaService.updateDieta(dietaDTO);
    }
}
