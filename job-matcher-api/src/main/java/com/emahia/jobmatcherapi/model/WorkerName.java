package com.emahia.jobmatcherapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class WorkerName implements Serializable {
    private String first;
    private String last;
}
