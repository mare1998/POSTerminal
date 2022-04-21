package com.project.POSTerminal.dto;

import com.project.POSTerminal.model.Item;
import lombok.*;

import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private UUID id;
    private String name;
    private double price;
    private int quantity;

    public Item map(){
        return new Item(this.id,this.name,this.price,this.quantity,null);
    }
}
