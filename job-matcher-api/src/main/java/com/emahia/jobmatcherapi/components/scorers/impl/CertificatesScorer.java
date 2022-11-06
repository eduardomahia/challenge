package com.emahia.jobmatcherapi.components.scorers.impl;

import com.emahia.jobmatcherapi.model.Job;
import com.emahia.jobmatcherapi.model.Worker;
import com.emahia.jobmatcherapi.components.scorers.Scorer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CertificatesScorer implements Scorer {
    @Override
    public String getScoreName() {
        return "CERTIFICATES_SCORER";
    }

    @Override
    public double getScoreWeighing() {
        return 2;
    }

    public double getMatchPercentage(final Worker worker, final Job job) {
        final List<String> workerCertificates = worker.getCertificates();
        final List<String> jobCertificates = job.getRequiredCertificates();

        final long matchingElements = jobCertificates.stream().filter(wc -> workerCertificates.contains(wc)).count();

        return matchingElements * 100 / jobCertificates.size();
    }
}
