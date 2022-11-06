package com.emahia.jobmatcherapi.services.impl;

import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.model.Worker;
import com.emahia.jobmatcherapi.repositories.JobsRepository;
import com.emahia.jobmatcherapi.repositories.WorkersRepository;
import com.emahia.jobmatcherapi.services.WorkerJobScoreService;
import com.emahia.jobmatcherapi.services.WorkerJobsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkerJobsServiceImpl implements WorkerJobsService {

    private WorkersRepository workersRepository;
    private JobsRepository jobsRepository;
    private WorkerJobScoreService workerJobScoreService;

    @Override
    public List<Job> getWorkerJobs(final int id) {
        final Worker worker = workersRepository.getById(id);
        if (worker == null || !worker.getIsActive()) {

            return Collections.EMPTY_LIST;
        }

        final List<Job> jobs = jobsRepository.getAll();
        final List<Job> filteredJobs = getFilteredJobs(worker, jobs);

        return getWorkerJobs(filteredJobs, worker);
    }

    private List<Job> getFilteredJobs(final Worker worker, final List<Job> jobs) {

        return jobs.stream().filter(job -> job.isValidForWorker(worker)).collect(Collectors.toList());
    }

    private List<Job> getWorkerJobs(final List<Job> filteredJobs, final Worker worker) {

        return filteredJobs.stream().map(job -> job.toBuilder().jobScore(workerJobScoreService.getWorkerJobScore(worker, job)).build()).sorted((o1, o2) -> o2.getJobScore().getTotalScore().compareTo(o1.getJobScore().getTotalScore())).collect(Collectors.toList());
    }

}
