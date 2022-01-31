package com.registropranzi.model;

import com.registropranzi.dto.DietaDTO;
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
public class Dieta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String descrizione;

    @OneToMany(mappedBy = "dieta",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Utente> utenti;


    public Dieta(DietaDTO dietaDTO) {
        this.id = dietaDTO.id;
        this.descrizione = dietaDTO.descrizione;
    }
}
