package com.emahia.jobmatcherapi.services.impl;

import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.repositories.JobsRepository;
import com.emahia.jobmatcherapi.services.JobsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobsServiceImpl implements JobsService {

    private JobsRepository jobsRepository;

    @Override
    public List<Job> getAll() {

        return jobsRepository.getAll();
    }

    @Override
    public Job getById(int id) {

        return jobsRepository.getById(id);
    }
}
