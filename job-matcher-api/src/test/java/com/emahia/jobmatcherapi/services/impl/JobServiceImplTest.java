package com.emahia.jobmatcherapi.services.impl;

import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.repositories.JobsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class JobServiceImplTest {

    @Mock
    private JobsRepository jobsRepository;

    @InjectMocks
    private JobsServiceImpl jobsService;

    @Test
    public void getAllTestOK() {
        final List<Job> jobs = new ArrayList<>();
        Mockito.doReturn(jobs).when(jobsRepository).getAll();

        final List<Job> response = jobsService.getAll();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(jobs, response);
    }

    @Test
    public void getByIdTestOK() {
        final Integer id = 1;
        final Job job = new Job();
        Mockito.doReturn(job).when(jobsRepository).getById(id);

        final Job response = jobsService.getById(id);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(job, response);
    }
}