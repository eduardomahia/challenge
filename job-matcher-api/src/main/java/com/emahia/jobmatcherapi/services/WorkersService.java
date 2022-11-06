package com.emahia.jobmatcherapi.services;

import com.emahia.jobmatcherapi.model.Worker;

import java.util.List;

public interface WorkersService {

    public List<Worker> getAll();

    public Worker getById(int id);
}
