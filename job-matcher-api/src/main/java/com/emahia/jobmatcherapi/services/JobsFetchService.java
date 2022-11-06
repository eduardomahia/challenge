package com.emahia.jobmatcherapi.services;

import com.emahia.jobmatcherapi.model.Job;

import java.util.List;

public interface JobsFetchService {

    public List<Job> getJobs();
}
