package com.registropranzi.dto;

import com.registropranzi.model.Prenotazione;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PrenotazioneDTO {

    public Long id;

    @NonNull
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd", style = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    public Date giorno;

    @NonNull
    public Boolean colazione;

    @NonNull
    public Boolean pranzo;

    @NonNull
    public Boolean cena;

    @NonNull
    public Boolean sacchettoPranzo;

    @NonNull
    public Boolean sacchettoColazione;

    @NonNull
    public Boolean sacchettoCena;

    @NonNull
    public Long idUtente;

    public PrenotazioneDTO(Prenotazione prenotazione) {
        this.id = prenotazione.getId();
        this.giorno = prenotazione.getGiorno();
        this.colazione = prenotazione.isColazione();
        this.pranzo = prenotazione.isPranzo();
        this.cena = prenotazione.isCena();
        this.sacchettoPranzo = prenotazione.isSacchettoPranzo();
        this.sacchettoColazione = prenotazione.isSacchettoColazione();
        this.sacchettoCena = prenotazione.isSacchettoCena();
        this.idUtente = prenotazione.getUtente().getId();
    }
}
