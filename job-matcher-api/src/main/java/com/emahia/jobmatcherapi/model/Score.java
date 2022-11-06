package com.emahia.jobmatcherapi.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Score implements Serializable {

    private String name;
    private Double value;

}
