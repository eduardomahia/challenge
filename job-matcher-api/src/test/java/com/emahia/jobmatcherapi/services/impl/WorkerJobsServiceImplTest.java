package com.emahia.jobmatcherapi.services.impl;

import com.emahia.jobmatcherapi.model.*;
import com.emahia.jobmatcherapi.repositories.JobsRepository;
import com.emahia.jobmatcherapi.repositories.WorkersRepository;
import com.emahia.jobmatcherapi.services.WorkerJobScoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.CollectionUtils;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class WorkerJobsServiceImplTest {

    @Mock
    private WorkersRepository workersRepository;
    @Mock
    private JobsRepository jobsRepository;
    @Mock
    private WorkerJobScoreService workerJobScoreService;

    @InjectMocks
    private WorkerJobsServiceImpl workerJobsService;

    @Test
    public void getWorkerJobsInactive() {
        final Integer id = 1;
        Mockito.doReturn(Worker.builder().isActive(false).build()).when(workersRepository).getById(id);

        final List<Job> response = workerJobsService.getWorkerJobs(id);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(CollectionUtils.isEmpty(response));
    }

    @Test
    public void getWorkerJobsNoDriverLicense() {
        final Integer id = 1;
        final Job job1 = Job.builder().jobId(1).driverLicenseRequired(true).requiredCertificates(List.of("CERTIFICATE")).location(JobLocation.builder().latitude(49.994037).longitude(14.013835).build()).jobScore(new JobScore()).build();
        final Job job2 = Job.builder().jobId(2).driverLicenseRequired(false).requiredCertificates(List.of("CERTIFICATE")).location(JobLocation.builder().latitude(49.994037).longitude(14.013835).build()).jobScore(new JobScore()).build();
        final Worker worker = Worker.builder().isActive(true).hasDriversLicense(false).certificates(List.of("CERTIFICATE")).jobSearchAddress(WorkerJobSearchAddress.builder().maxJobDistance(5).latitude(49.994037).longitude(14.013835).build()).build();
        Mockito.doReturn(new JobScore()).when(workerJobScoreService).getWorkerJobScore(worker, job2);
        Mockito.doReturn(worker).when(workersRepository).getById(id);
        Mockito.doReturn(List.of(job1, job2)).when(jobsRepository).getAll();

        final List<Job> response = workerJobsService.getWorkerJobs(id);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.size() == 1);
        Assertions.assertEquals(response.get(0), job2);
    }

    @Test
    public void getWorkerJobsNoCertificates() {
        final Integer id = 1;
        final Job job1 = Job.builder().jobId(1).driverLicenseRequired(false).requiredCertificates(List.of("NON")).location(JobLocation.builder().latitude(49.994037).longitude(14.013835).build()).jobScore(new JobScore()).build();
        final Job job2 = Job.builder().jobId(2).driverLicenseRequired(false).requiredCertificates(List.of("CERTIFICATE")).location(JobLocation.builder().latitude(49.994037).longitude(14.013835).build()).jobScore(new JobScore()).build();
        final Worker worker = Worker.builder().isActive(true).hasDriversLicense(false).certificates(List.of("CERTIFICATE")).jobSearchAddress(WorkerJobSearchAddress.builder().maxJobDistance(5).latitude(49.994037).longitude(14.013835).build()).build();
        Mockito.doReturn(new JobScore()).when(workerJobScoreService).getWorkerJobScore(worker, job2);
        Mockito.doReturn(worker).when(workersRepository).getById(id);
        Mockito.doReturn(List.of(job1, job2)).when(jobsRepository).getAll();

        final List<Job> response = workerJobsService.getWorkerJobs(id);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.size() == 1);
        Assertions.assertEquals(response.get(0), job2);
    }

    @Test
    public void getWorkerJobsNoDistance() {
        final Integer id = 1;
        final Job job1 = Job.builder().jobId(1).driverLicenseRequired(false).requiredCertificates(List.of("CERTIFICATE")).location(JobLocation.builder().latitude(49.994037).longitude(14.013835).build()).jobScore(new JobScore()).build();
        final Job job2 = Job.builder().jobId(2).driverLicenseRequired(false).requiredCertificates(List.of("CERTIFICATE")).location(JobLocation.builder().latitude(12.10458).longitude(45.12548).build()).jobScore(new JobScore()).build();
        final Worker worker = Worker.builder().isActive(true).certificates(List.of("CERTIFICATE")).jobSearchAddress(WorkerJobSearchAddress.builder().maxJobDistance(5).latitude(49.994037).longitude(14.013835).build()).build();
        Mockito.doReturn(new JobScore()).when(workerJobScoreService).getWorkerJobScore(worker, job1);
        Mockito.doReturn(worker).when(workersRepository).getById(id);
        Mockito.doReturn(List.of(job1, job2)).when(jobsRepository).getAll();

        final List<Job> response = workerJobsService.getWorkerJobs(id);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.size() == 1);
        Assertions.assertEquals(response.get(0), job1);
    }

    @Test
    public void getWorkerJobsSorted() {
        final Integer id = 1;
        final Job job1 = Job.builder().jobId(1).driverLicenseRequired(false).requiredCertificates(List.of("CERTIFICATE")).location(JobLocation.builder().latitude(49.994037).longitude(14.013835).build()).jobScore(JobScore.builder().totalScore(10D).build()).build();
        final Job job2 = Job.builder().jobId(2).driverLicenseRequired(false).requiredCertificates(List.of("CERTIFICATE")).location(JobLocation.builder().latitude(49.994037).longitude(14.013835).build()).jobScore(JobScore.builder().totalScore(5D).build()).build();
        final Worker worker = Worker.builder().isActive(true).certificates(List.of("CERTIFICATE")).jobSearchAddress(WorkerJobSearchAddress.builder().maxJobDistance(5).latitude(49.994037).longitude(14.013835).build()).build();
        Mockito.doReturn(JobScore.builder().totalScore(10D).build()).when(workerJobScoreService).getWorkerJobScore(worker, job1);
        Mockito.doReturn(JobScore.builder().totalScore(5D).build()).when(workerJobScoreService).getWorkerJobScore(worker, job2);
        Mockito.doReturn(worker).when(workersRepository).getById(id);
        Mockito.doReturn(List.of(job1, job2)).when(jobsRepository).getAll();

        final List<Job> response = workerJobsService.getWorkerJobs(id);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.size() == 2);
        Assertions.assertEquals(response.get(0), job1);
        Assertions.assertEquals(response.get(1), job2);
    }
}