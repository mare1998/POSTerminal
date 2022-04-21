package com.project.POSTerminal.dto;

import com.project.POSTerminal.model.Worker;
import lombok.*;
import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDto {

    private UUID id;
    private String username;
    private String password;
    private UUID countryId;
    private String role;

    public Worker map(){
        return new Worker(this.id,this.username,this.password,this.countryId,this.role);
    }
}
