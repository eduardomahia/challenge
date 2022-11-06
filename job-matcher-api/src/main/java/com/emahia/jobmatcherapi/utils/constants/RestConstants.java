package com.emahia.jobmatcherapi.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestConstants {

    // PATHS
    public static final String WORKER_PATH = "/workers";
    public static final String JOB_PATH = "/jobs";
    public static final String V1 = "/v1";

    // PARAMS
    public static final String VALUE_PLACEHOLDER = "/{value}";
    public static final String VALUE = "value";

    //URL
    //SWIPEJOBS
    public static final String WORKERS_URL = "https://test.swipejobs.com/api/workers";
    public static final String JOBS_URL = "https://test.swipejobs.com/api/jobs";



}
