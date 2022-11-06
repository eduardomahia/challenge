package com.emahia.jobmatcherapi.components.scorers.impl;

import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.model.Worker;
import com.emahia.jobmatcherapi.components.scorers.Scorer;
import com.emahia.jobmatcherapi.utils.DistanceUtils;
import org.springframework.stereotype.Component;

@Component
public class DistanceScorer implements Scorer {
    @Override
    public String getScoreName() {
        return "DISTANCE_SCORER";
    }

    @Override
    public double getScoreWeighing() {
        return 1;
    }

    public double getMatchPercentage(final Worker worker, final Job job) {
        final double distanceInKm = DistanceUtils.getDistanceInKm(job.getLocation().getLatitude(), job.getLocation().getLongitude(), worker.getJobSearchAddress().getLatitude(), worker.getJobSearchAddress().getLongitude());

        return 100 - distanceInKm * 100 / worker.getJobSearchAddress().getMaxJobDistance();
    }
}
