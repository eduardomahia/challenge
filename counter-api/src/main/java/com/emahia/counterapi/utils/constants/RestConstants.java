package com.emahia.counterapi.utils.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestConstants {

    // PATHS
    public static final String SEARCH_PATH = "/search";
    public static final String TOP_PATH = "/top";
    public static final String PATH_DELIMITER = "/";

    // PARAMS
    public static final String VALUE_PLACEHOLDER = "{value}";
    public static final String VALUE = "value";

    // RESPONSE
    public static final String CSV_CONTENT_TYPE = "text/csv; charset=utf-8";
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String CSV_FILE_NAME = "top_words.csv";
}
