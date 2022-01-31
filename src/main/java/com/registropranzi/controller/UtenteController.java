package com.registropranzi.controller;

import com.registropranzi.dto.UtenteDTO;
import com.registropranzi.service.UtenteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(
        path = "/api/utente",
        produces = "application/json"
)
@AllArgsConstructor
public class UtenteController {

    private final UtenteService utenteService;

    @PostMapping("/new")
    public UtenteDTO addUtente(@Valid @RequestBody UtenteDTO utenteDTO) {
        return utenteService.insertUtente(utenteDTO);
    }

    @DeleteMapping("/delete")
    public List<UtenteDTO> deleteUtente(@Valid @RequestParam Long id) {
        return utenteService.deleteUtente(id);
    }

    @GetMapping("/info")
    public UtenteDTO getDetails(@Valid @RequestParam Long id) {
        return utenteService.getDetails(id);
    }

    @PutMapping("/update")
    public UtenteDTO updateUtente(@Valid @RequestBody UtenteDTO utenteDTO) {
        return utenteService.updateUtente(utenteDTO);
    }

    //l'admin deve assegnare la dieta agli utenti
    //l'admin puo' cancellare la prenotazione degli utenti
    //fare findAll()
}
