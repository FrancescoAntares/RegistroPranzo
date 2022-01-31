package com.registropranzi.dto;

import com.registropranzi.model.Dieta;
import com.registropranzi.model.Utente;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UtenteDTO {

    public Long id;
    public String nome;
    public String cognome;
    public String password; //da verificare security
    public Boolean admin;
    public Long idDieta;


    public UtenteDTO(Utente utente) {
        this.id = utente.getId();
        this.nome = utente.getNome();
        this.cognome = utente.getCognome();
        this.password = utente.getPassword();
        this.admin = utente.getAdmin();
        this.idDieta = utente.getDieta().getId();
    }
}
