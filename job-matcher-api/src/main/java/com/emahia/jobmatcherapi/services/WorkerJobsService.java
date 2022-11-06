package com.emahia.jobmatcherapi.services;

import com.emahia.jobmatcherapi.model.Job;

import java.util.List;

public interface WorkerJobsService {

    public List<Job> getWorkerJobs(int workerId);
}
