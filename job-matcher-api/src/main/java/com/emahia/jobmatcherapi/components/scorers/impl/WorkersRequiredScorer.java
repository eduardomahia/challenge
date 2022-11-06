package com.emahia.jobmatcherapi.components.scorers.impl;

import com.emahia.jobmatcherapi.components.scorers.Scorer;
import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.model.Worker;
import org.springframework.stereotype.Component;

@Component
public class WorkersRequiredScorer implements Scorer {
    @Override
    public String getScoreName() {
        return "WORKERS_REQUIRED_SCORER";
    }

    @Override
    public double getScoreWeighing() {
        return 0.5;
    }

    public double getMatchPercentage(final Worker worker, final Job job) {
        final Integer workerRequired = job.getWorkersRequired();
        if (1 == workerRequired)
            return 0;
        if (2 == workerRequired)
            return 25;
        if (3 == workerRequired)
            return 50;
        if (4 == workerRequired)
            return 75;
        if (5 <= workerRequired)
            return 100;

        return 0;
    }
}