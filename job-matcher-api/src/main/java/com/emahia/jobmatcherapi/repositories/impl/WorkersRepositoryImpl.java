package com.emahia.jobmatcherapi.repositories.impl;

import com.emahia.jobmatcherapi.model.Worker;
import com.emahia.jobmatcherapi.repositories.WorkersRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class WorkersRepositoryImpl implements WorkersRepository{

    private static final Map<Integer, Worker> WORKERS_MAP = new ConcurrentHashMap<>();

    @Override
    public void updateWorkers(final List<Worker> workers) {
        if (!CollectionUtils.isEmpty(workers)) {
            final Map<Integer, Worker> newWorkerMap = workers.stream()
                    .collect(Collectors.toMap(Worker::getUserId, Function.identity()));

            WORKERS_MAP.clear();
            WORKERS_MAP.putAll(newWorkerMap);
        }

    }

    @Override
    public List<Worker> getAll() {

        return new ArrayList<Worker>(WORKERS_MAP.values());
    }

    @Override
    public Worker getById(int id) {

        return WORKERS_MAP.get(id);
    }
}
