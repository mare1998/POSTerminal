package com.project.POSTerminal.model;

import com.project.POSTerminal.dto.CountryDto;
import lombok.*;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Country {

    @Id
    private UUID id;
    private double pdv;
    private String name;

    public CountryDto mapToDto(){
        return new CountryDto(this.getId(),this.getPdv(),this.getName());
    }

}
