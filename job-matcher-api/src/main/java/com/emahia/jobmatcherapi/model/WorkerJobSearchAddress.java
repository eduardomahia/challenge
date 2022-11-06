package com.emahia.jobmatcherapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerJobSearchAddress implements Serializable {
    private Double latitude;
    private Double longitude;
    private Integer maxJobDistance;
    private String unit;
}
