package com.registropranzi.dto;

import com.registropranzi.model.Dieta;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DietaDTO {

    public Long id;
    public String descrizione;

    public DietaDTO (Dieta dieta){
        this.id = dieta.getId();
        this.descrizione = dieta.getDescrizione();
    }
}
