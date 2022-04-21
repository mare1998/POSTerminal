package com.project.POSTerminal.service;

import com.project.POSTerminal.dto.ItemDto;
import com.project.POSTerminal.model.Item;
import com.project.POSTerminal.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepo;

    @Override
    public List<Item> getAllItems() {

        return itemRepo.findAll();
    }

    @Override
    public List<Item> fiveSales() {
        return itemRepo.fiveSales();
    }

    @Override
    public List<Item> noSale() {
        return itemRepo.zeroSales();
    }

    @Override
    public List<String> topSales() {
        return itemRepo.topTenByCountry();
    }
}
