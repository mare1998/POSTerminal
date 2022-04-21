package com.project.POSTerminal.service;

import com.project.POSTerminal.model.Country;
import com.project.POSTerminal.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    CountryRepository countryRepo;

    @Override
    public List<Country> getAllCountries() {
        return countryRepo.findAll();
    }
}
