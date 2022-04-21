package com.project.POSTerminal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.POSTerminal.dto.ItemDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {

    @Id
    private UUID id;
    private String name;
    private double price;
    private int quantity;
    @ManyToMany
    @JoinTable(
            name = "items_receipts",
            joinColumns = { @JoinColumn(name = "item_id") },
            inverseJoinColumns = { @JoinColumn(name = "receipt_id") }
    )
    @JsonIgnore
    private List<Receipt> receipts;

    public ItemDto mapToDto(){
        return new ItemDto(this.id,this.name,this.price,this.quantity);
    }

}
