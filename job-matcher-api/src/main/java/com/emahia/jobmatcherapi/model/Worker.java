package com.emahia.jobmatcherapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Worker implements Serializable {
    private Integer age;
    private List<WorkerAvailability> availability;
    private List<String> certificates;
    private String email;
    private String guid;
    private Boolean hasDriversLicense;
    private Boolean isActive;
    private WorkerJobSearchAddress jobSearchAddress;
    private WorkerName name;
    private String phone;
    private Integer rating;
    private List<String> skills;
    private String transportation;
    private Integer userId;
}
