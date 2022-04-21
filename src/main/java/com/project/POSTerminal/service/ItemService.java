package com.project.POSTerminal.service;

import com.project.POSTerminal.dto.ItemDto;
import com.project.POSTerminal.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    List<Item> fiveSales();
    List<Item> noSale();
    List<String> topSales();
}
