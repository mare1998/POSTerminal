package com.project.POSTerminal.dto;

import com.project.POSTerminal.model.Receipt;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptDto {

    private UUID id;
    private Date date;
    private double price;
    private UUID workerId;

    public Receipt map(){
        return new Receipt(this.id,this.date,this.price,this.workerId,null);
    }
    public Receipt mapWithId(UUID id){
        return new Receipt(id,this.date,this.price,this.workerId,null);
    }
}
