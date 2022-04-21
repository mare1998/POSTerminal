package com.project.POSTerminal.dto;

import com.project.POSTerminal.model.Country;
import lombok.*;

import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {

    private UUID id;
    private double pdv;
    private String name;

    public Country map(){
        return new Country(this.id,this.pdv,this.name);
    }
}
