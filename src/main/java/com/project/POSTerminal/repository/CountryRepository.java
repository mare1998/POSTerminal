package com.project.POSTerminal.repository;

import com.project.POSTerminal.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface CountryRepository extends JpaRepository<Country,UUID> {

}
