package com.emahia.jobmatcherapi.services.impl;

import com.emahia.jobmatcherapi.model.Worker;
import com.emahia.jobmatcherapi.repositories.WorkersRepository;
import com.emahia.jobmatcherapi.services.WorkersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkersServiceImpl implements WorkersService {

    private WorkersRepository workersRepository;

    @Override
    public List<Worker> getAll() {

        return workersRepository.getAll();
    }

    @Override
    public Worker getById(int id) {

        return workersRepository.getById(id);
    }
}
