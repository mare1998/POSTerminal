package com.project.POSTerminal.service;

import com.project.POSTerminal.model.Receipt;


import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface ReceiptService {
    List<Receipt> getAllOrders();
    void deleteOrder(UUID id);
    List<String> totalTransaction(Date startDate, Date endDate) throws Exception;
}
