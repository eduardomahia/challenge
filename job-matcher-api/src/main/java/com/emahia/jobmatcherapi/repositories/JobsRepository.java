package com.emahia.jobmatcherapi.repositories;

import com.emahia.jobmatcherapi.model.Job;

import java.util.List;

public interface JobsRepository {

    public void updateJobs(List<Job> jobs);

    public List<Job> getAll();

    public Job getById(int id);

}
