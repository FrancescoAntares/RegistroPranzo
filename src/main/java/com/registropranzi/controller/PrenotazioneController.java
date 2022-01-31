package com.registropranzi.controller;

import com.registropranzi.dto.DietaDTO;
import com.registropranzi.dto.PrenotazioneDTO;
import com.registropranzi.model.Prenotazione;
import com.registropranzi.service.DietaService;
import com.registropranzi.service.PrenotazioneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(
        path = "/api/prenotazione",
        produces = "application/json"
)
@AllArgsConstructor
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;

    @PostMapping("/new")
    public PrenotazioneDTO insertPrenotazione(@Valid @RequestBody PrenotazioneDTO prenotazioneDTO) {
        return prenotazioneService.insertPrenotazione(prenotazioneDTO);
    }

    @GetMapping("/all")
    public List<PrenotazioneDTO> findAll() {
        return prenotazioneService.findAll();
    }

    @DeleteMapping("/findByDate")
    public List<PrenotazioneDTO> findByDate(@Valid @RequestParam Date date) {
        return prenotazioneService.findByDate(date);
    }

    @PutMapping("/update")
    public PrenotazioneDTO updatePrenotazione(@Valid @RequestBody PrenotazioneDTO prenotazioneDTO) {
        return prenotazioneService.updatePrenotazione(prenotazioneDTO);
    }
}
