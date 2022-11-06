package com.emahia.jobmatcherapi.controllers;

import com.emahia.jobmatcherapi.model.Worker;
import com.emahia.jobmatcherapi.services.WorkersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.emahia.jobmatcherapi.utils.constants.RestConstants.V1;
import static com.emahia.jobmatcherapi.utils.constants.RestConstants.WORKER_PATH;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
public class WorkerController {

    private WorkersService workersService;

    @GetMapping(value = V1 + WORKER_PATH, produces = APPLICATION_JSON_VALUE)
    public List<Worker> getAllWorkers() {

        return workersService.getAll();
    }
}
