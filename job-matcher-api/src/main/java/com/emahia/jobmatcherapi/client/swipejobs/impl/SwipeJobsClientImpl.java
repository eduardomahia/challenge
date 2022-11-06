package com.emahia.jobmatcherapi.client.swipejobs.impl;

import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.model.Worker;
import com.emahia.jobmatcherapi.services.JobsFetchService;
import com.emahia.jobmatcherapi.services.WorkersFetchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static com.emahia.jobmatcherapi.utils.constants.AppConstants.ERROR_WHILE_CALLING_SWIPE_JOBS_JOBS_SERVICE;
import static com.emahia.jobmatcherapi.utils.constants.AppConstants.ERROR_WHILE_CALLING_SWIPE_JOBS_WORKER_SERVICE;
import static com.emahia.jobmatcherapi.utils.constants.RestConstants.JOBS_URL;
import static com.emahia.jobmatcherapi.utils.constants.RestConstants.WORKERS_URL;

@Service
@Slf4j
@AllArgsConstructor
public class SwipeJobsClientImpl implements JobsFetchService, WorkersFetchService {

    private RestTemplate restTemplate;

    @Override
    public List<Job> getJobs() {
        final ResponseEntity<Job[]> response = restTemplate.getForEntity(JOBS_URL, Job[].class);
        if (response.getStatusCode().is2xxSuccessful()) {

            return Arrays.asList(response.getBody());
        }

        log.error(ERROR_WHILE_CALLING_SWIPE_JOBS_JOBS_SERVICE);

        return null;
    }

    @Override
    public List<Worker> getWorkers() {
        final ResponseEntity<Worker[]> response = restTemplate.getForEntity(WORKERS_URL, Worker[].class);
        if (response.getStatusCode().is2xxSuccessful()) {

            return Arrays.asList(response.getBody());
        }

        log.error(ERROR_WHILE_CALLING_SWIPE_JOBS_WORKER_SERVICE);

        return null;
    }
}
