package com.emahia.jobmatcherapi.services;

import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.model.JobScore;
import com.emahia.jobmatcherapi.model.Worker;

public interface WorkerJobScoreService {

    public JobScore getWorkerJobScore(Worker worker, Job job);
}
