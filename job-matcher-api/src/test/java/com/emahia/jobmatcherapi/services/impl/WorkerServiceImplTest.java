package com.emahia.jobmatcherapi.services.impl;

import com.emahia.jobmatcherapi.model.Worker;
import com.emahia.jobmatcherapi.repositories.WorkersRepository;
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
public class WorkerServiceImplTest {

    @Mock
    private WorkersRepository workersRepository;

    @InjectMocks
    private WorkersServiceImpl workersService;

    @Test
    public void getAllTestOK() {
        final List<Worker> workers = new ArrayList<>();
        Mockito.doReturn(workers).when(workersRepository).getAll();

        final List<Worker> response = workersService.getAll();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(workers, response);
    }

    @Test
    public void getByIdTestOK() {
        final Integer id = 1;
        final Worker worker = new Worker();
        Mockito.doReturn(worker).when(workersRepository).getById(id);

        final Worker response = workersService.getById(id);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(worker, response);
    }
}