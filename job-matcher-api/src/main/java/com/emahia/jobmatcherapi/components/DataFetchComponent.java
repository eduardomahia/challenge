package com.emahia.jobmatcherapi.components;

import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.model.Worker;
import com.emahia.jobmatcherapi.repositories.JobsRepository;
import com.emahia.jobmatcherapi.repositories.WorkersRepository;
import com.emahia.jobmatcherapi.services.JobsFetchService;
import com.emahia.jobmatcherapi.services.WorkersFetchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.emahia.jobmatcherapi.utils.constants.AppConstants.INFO_FETCH_DATA_PROCESS_FINISHED;
import static com.emahia.jobmatcherapi.utils.constants.AppConstants.INFO_FETCH_DATA_PROCESS_START;

@Component
@Slf4j
@AllArgsConstructor
public class DataFetchComponent {

    private JobsFetchService jobsFetchService;
    private WorkersFetchService workersFetchService;
    private JobsRepository jobsRepository;
    private WorkersRepository workersRepository;

    @Scheduled(fixedDelay = 3600000)
    public void fetchData(){
        log.info(INFO_FETCH_DATA_PROCESS_START);

        updateJobs();
        updateWorkers();

        log.info(INFO_FETCH_DATA_PROCESS_FINISHED);
    }

    private void updateWorkers() {
        final List<Worker> workers = workersFetchService.getWorkers();
        if (!CollectionUtils.isEmpty(workers)){
            workersRepository.updateWorkers(workers);
        }
    }

    private void updateJobs() {
        final List<Job> jobs = jobsFetchService.getJobs();
        if (!CollectionUtils.isEmpty(jobs)){
            jobsRepository.updateJobs(jobs);
        }
    }

}
