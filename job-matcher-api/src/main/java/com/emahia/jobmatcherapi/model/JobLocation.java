package com.emahia.jobmatcherapi.model;

import com.emahia.jobmatcherapi.utils.DistanceUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobLocation implements Serializable {
    private Double latitude;
    private Double longitude;

    public boolean isValidForWorkerJobSearch(final WorkerJobSearchAddress workerJobSearchAddress) {
        final double distanceInKm = DistanceUtils.getDistanceInKm(latitude, longitude, workerJobSearchAddress.getLatitude(), workerJobSearchAddress.getLongitude());

        return distanceInKm <= workerJobSearchAddress.getMaxJobDistance();
    }
}
