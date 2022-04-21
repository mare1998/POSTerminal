package com.project.POSTerminal.controller;

import com.project.POSTerminal.dto.ItemDto;
import com.project.POSTerminal.model.Item;
import com.project.POSTerminal.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemServiceImpl itemService;

    @GetMapping("/")
    public ResponseEntity<?> getAllItems(){
        try {
            return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("No match",HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/noSale")
    public ResponseEntity<?> getItemsWithNoSale(){
        try {
            return new ResponseEntity<>(itemService.noSale(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("No match",HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/fiveSales")
    public ResponseEntity<?> getItemWithFiveSales(){
        try {
            return new ResponseEntity<>(itemService.fiveSales(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("No matches",HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/topTen")
    public ResponseEntity<?> getTopTen(){
        try {
            return new ResponseEntity<>(itemService.topSales(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("No matches", HttpStatus.NO_CONTENT);
        }
    }

}
