package com.project.POSTerminal.service;

import com.project.POSTerminal.model.Receipt;
import com.project.POSTerminal.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.UUID;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    ReceiptRepository receiptRepo;

    @Override
    public List<Receipt> getAllOrders() {
        return receiptRepo.findAll();
    }


    @Override
    public void deleteOrder(UUID id) {
        receiptRepo.delete(id);
    }



    @Override
    public List<String> totalTransaction(Date startDate,Date endDate) throws Exception {

           return receiptRepo.totalTransactions(startDate,endDate);
    }
}
