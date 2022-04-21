package com.project.POSTerminal.controller;

import com.project.POSTerminal.dto.ReceiptDto;
import com.project.POSTerminal.model.Receipt;
import com.project.POSTerminal.service.ReceiptService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class ReceiptController {

    @Autowired
    ReceiptService orderService;

    @GetMapping("/")
    public ResponseEntity<?> getOrders(){
        try {
            return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("No match",HttpStatus.NO_CONTENT);
        }

    }
    @GetMapping("/transactions")
    public ResponseEntity<?> allTransactions(@NotNull @RequestParam String startDate, @NotNull @RequestParam String endDate)  {
        try {
            Date start = Date.valueOf(startDate);
            Date end = Date.valueOf(endDate);
            return new ResponseEntity<>(orderService.totalTransaction(start,end), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("No date provided",HttpStatus.NO_CONTENT);
        }


    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") UUID id){
        try {
            orderService.deleteOrder(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("No item",HttpStatus.BAD_REQUEST);
        }
    }




}
