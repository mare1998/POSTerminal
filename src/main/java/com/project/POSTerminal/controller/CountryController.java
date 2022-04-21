package com.project.POSTerminal.controller;

import com.project.POSTerminal.model.Country;
import com.project.POSTerminal.service.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryServiceImpl countryService;

    @GetMapping("/")
    public ResponseEntity<List<Country>> getCountries(){
        return new ResponseEntity<>(countryService.getAllCountries(), HttpStatus.OK);
    }
}
