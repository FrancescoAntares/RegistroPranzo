package com.registropranzi.model;


import com.registropranzi.dto.PrenotazioneDTO;
import com.registropranzi.dto.UtenteDTO;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nome;

    @NonNull
    private String cognome;

    @NonNull
    private String password;

    @NonNull
    private Boolean admin;

    @ManyToOne
    @JoinColumn(name = "id_dieta")
    private Dieta dieta;  //foreign_key

    @OneToMany(mappedBy = "utente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Prenotazione> prenotazioni;

    public Utente(UtenteDTO utenteDTO) {
        this.id = utenteDTO.id;
        this.nome = utenteDTO.nome;
        this.cognome = utenteDTO.cognome;
        this.password = utenteDTO.password;
        this.admin = utenteDTO.admin;
    }
}
