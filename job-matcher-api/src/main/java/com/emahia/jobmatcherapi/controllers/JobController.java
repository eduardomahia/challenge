package com.emahia.jobmatcherapi.controllers;

import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.services.JobsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.emahia.jobmatcherapi.utils.constants.RestConstants.JOB_PATH;
import static com.emahia.jobmatcherapi.utils.constants.RestConstants.V1;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
public class JobController {

    private JobsService jobsService;

    @GetMapping(value = V1 + JOB_PATH, produces = APPLICATION_JSON_VALUE)
    public List<Job> getAllJobs() {

        return jobsService.getAll();
    }
}
