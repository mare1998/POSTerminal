package com.project.POSTerminal.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Receipt {

    @Id
    private UUID id;
    private Date date;
    private double price;
    @Column(name="worker_id")
    private UUID workerId;
    @ManyToMany(mappedBy = "receipts"   )
    private List<Item> items;

    public void generateId(){
        this.setId(UUID.randomUUID());
    }

}
