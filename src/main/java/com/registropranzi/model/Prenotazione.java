package com.registropranzi.model;

import com.registropranzi.dto.PrenotazioneDTO;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd", style = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    private Date giorno;

    @NonNull
    private boolean colazione;

    @NonNull
    private boolean pranzo;

    @NonNull
    private boolean cena;

    @NonNull
    private boolean sacchettoPranzo;

    @NonNull
    private boolean sacchettoColazione;

    @NonNull
    private boolean sacchettoCena;

    @ManyToOne
    @JoinColumn(name = "id_utente",nullable = false)
    private Utente utente;


    public Prenotazione(PrenotazioneDTO prenotazioneDTO) {
        this.id = prenotazioneDTO.getId();
        this.giorno = prenotazioneDTO.giorno;
        this.colazione = prenotazioneDTO.colazione;
        this.pranzo = prenotazioneDTO.pranzo;
        this.cena = prenotazioneDTO.cena;
        this.sacchettoPranzo = prenotazioneDTO.sacchettoPranzo;
        this.sacchettoColazione = prenotazioneDTO.sacchettoColazione;
        this.sacchettoCena = prenotazioneDTO.sacchettoCena;
    }

}
