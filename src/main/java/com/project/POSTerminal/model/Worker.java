package com.project.POSTerminal.model;

import com.project.POSTerminal.dto.CountryDto;
import com.project.POSTerminal.dto.WorkerDto;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Worker {

    @Id
    private UUID id;
    private String username;
    private String password;
    @Column(name="country_id")
    private UUID countryId;

    private String role;

    public WorkerDto mapToDto(){
        return new WorkerDto(this.id,this.username,this.password,this.countryId,this.role);
    }
}
