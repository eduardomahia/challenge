package com.emahia.jobmatcherapi.services;

import com.emahia.jobmatcherapi.model.Job;

import java.util.List;

public interface JobsService {

    public List<Job> getAll();

    public Job getById(int id);
}
