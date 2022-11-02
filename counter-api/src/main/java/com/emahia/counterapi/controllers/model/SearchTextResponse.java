package com.emahia.counterapi.controllers.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class SearchTextResponse {

    /**
     * No standard json response format
     * Applied because requirement
     */
    private List<Map.Entry<String, Integer>> counts;

}
