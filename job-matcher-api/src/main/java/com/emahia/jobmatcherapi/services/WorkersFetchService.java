package com.emahia.jobmatcherapi.services;

import com.emahia.jobmatcherapi.model.Worker;

import java.util.List;

public interface WorkersFetchService {

    public List<Worker> getWorkers();
}
