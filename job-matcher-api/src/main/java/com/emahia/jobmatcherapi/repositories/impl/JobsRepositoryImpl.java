package com.emahia.jobmatcherapi.repositories.impl;

import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.repositories.JobsRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class JobsRepositoryImpl implements JobsRepository{

    private static final Map<Integer, Job> JOBS_MAP = new ConcurrentHashMap<>();

    @Override
    public void updateJobs(final List<Job> jobs) {
        if (!CollectionUtils.isEmpty(jobs)) {
            final Map<Integer, Job> newJobsMap = jobs.stream()
                    .collect(Collectors.toMap(Job::getJobId, Function.identity()));

            JOBS_MAP.clear();
            JOBS_MAP.putAll(newJobsMap);
        }

    }

    @Override
    public List<Job> getAll() {

        return new ArrayList<Job>(JOBS_MAP.values());
    }

    @Override
    public Job getById(int id) {

        return JOBS_MAP.get(id);
    }
}
