package com.emahia.jobmatcherapi.components.scorers;

import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.model.Score;
import com.emahia.jobmatcherapi.model.Worker;

public interface Scorer {

    public String getScoreName();

    public double getScoreWeighing();

    public double getMatchPercentage(Worker worker, Job job);

    default Score getGlobalScore(final Worker worker, final Job job) {

        return Score.builder().name(getScoreName()).value(getScoreWeighing() * getMatchPercentage(worker, job) / 100).build();


    }
}
