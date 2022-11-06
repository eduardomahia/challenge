package com.emahia.jobmatcherapi.controllers;

import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.services.WorkerJobsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.emahia.jobmatcherapi.utils.constants.RestConstants.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
public class WorkerJobsController {

    private WorkerJobsService workerJobsService;

    @GetMapping(value = V1 + WORKER_PATH + VALUE_PLACEHOLDER + JOB_PATH, produces = APPLICATION_JSON_VALUE)
    public List<Job> getWorkerJobs(@PathVariable(name = VALUE) final Integer id) {
        if (id == null){
            return Collections.EMPTY_LIST;
        }



        return workerJobsService.getWorkerJobs(id).stream().limit(3).collect(Collectors.toList());
    }
}
