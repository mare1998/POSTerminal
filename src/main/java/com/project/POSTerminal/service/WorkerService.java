package com.project.POSTerminal.service;

import com.project.POSTerminal.model.Worker;

import java.util.Date;
import java.util.List;

public interface WorkerService {

    List<Worker> findAllWorkers();
    List<Worker> findThree(String year,String month);
    Worker findByUsername(String username);

}
