package com.emahia.jobmatcherapi.services.impl;

import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.model.JobScore;
import com.emahia.jobmatcherapi.model.Score;
import com.emahia.jobmatcherapi.model.Worker;
import com.emahia.jobmatcherapi.services.WorkerJobScoreService;
import com.emahia.jobmatcherapi.components.scorers.Scorer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkerJobScoreServiceImpl implements WorkerJobScoreService {

    private List<Scorer> scorers;

    @Override
    public JobScore getWorkerJobScore(final Worker worker, final Job job) {
        final List<Score> scores = scorers.stream().map(scorer -> scorer.getGlobalScore(worker, job)).collect(Collectors.toList());

        return JobScore.builder().scores(scores).totalScore(scores.stream().collect(Collectors.summingDouble(Score::getValue))).build();
    }
}
