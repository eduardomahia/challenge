package com.emahia.jobmatcherapi.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppConstants {

    //LOGS
    //ERRORS
    public static final String ERROR_WHILE_CALLING_SWIPE_JOBS_JOBS_SERVICE = "Error occurred while calling SwipeJobs Jobs service";
    public static final String ERROR_WHILE_CALLING_SWIPE_JOBS_WORKER_SERVICE = "Error occurred while calling SwipeJobs Worker service";

    //INFO
    public static final String INFO_FETCH_DATA_PROCESS_START = "Fetch Data Process start";
    public static final String INFO_FETCH_DATA_PROCESS_FINISHED = "Fetch Data Process finished";
}
