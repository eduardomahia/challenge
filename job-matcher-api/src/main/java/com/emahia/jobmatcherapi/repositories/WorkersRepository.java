package com.emahia.jobmatcherapi.repositories;

import com.emahia.jobmatcherapi.model.Worker;

import java.util.List;

public interface WorkersRepository {

    public void updateWorkers(List<Worker> workers);

    public List<Worker> getAll();

    public Worker getById(int id);

}


