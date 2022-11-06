package com.emahia.jobmatcherapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Job implements Serializable {
    private String about;
    private String billRate;
    private String company;
    private Boolean driverLicenseRequired;
    private String guid;
    private Integer jobId;
    private String jobTitle;
    private JobLocation location;
    private List<String> requiredCertificates;
    private Date startDate;
    private Integer workersRequired;
    private JobScore jobScore;

    public boolean isValidForWorker(final Worker worker) {
        if (driverLicenseRequired && !worker.getHasDriversLicense()) {
            return false;
        }
        if (Collections.disjoint(requiredCertificates, worker.getCertificates())) {
            return false;
        }
        if (!location.isValidForWorkerJobSearch(worker.getJobSearchAddress())) {
            return false;
        }
        return true;
    }
}
