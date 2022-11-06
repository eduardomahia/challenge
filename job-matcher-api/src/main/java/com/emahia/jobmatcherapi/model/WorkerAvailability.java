package com.emahia.jobmatcherapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class WorkerAvailability implements Serializable {
    private Integer dayIndex;
    private String title;

}
