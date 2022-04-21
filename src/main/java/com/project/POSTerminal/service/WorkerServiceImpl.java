package com.project.POSTerminal.service;

import com.project.POSTerminal.model.Worker;
import com.project.POSTerminal.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    @Override
    public List<Worker> findAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public List<Worker> findThree(String year,String month) {
        return workerRepository.findWorker(year,month);
    }

    @Override
    public Worker findByUsername(String username) {
        return workerRepository.searchUsername(username);
    }


}
