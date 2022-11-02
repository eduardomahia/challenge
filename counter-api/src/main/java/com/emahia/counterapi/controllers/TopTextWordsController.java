package com.emahia.counterapi.controllers;

import com.emahia.counterapi.services.TopTextWordsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.emahia.counterapi.utils.constants.AppConstants.BREAK_LINE;
import static com.emahia.counterapi.utils.constants.AppConstants.CSV_SEPARATOR;
import static com.emahia.counterapi.utils.constants.RestConstants.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
public class TopTextWordsController {

    private TopTextWordsService topTextWordsService;

    @GetMapping(value = TOP_PATH + PATH_DELIMITER + VALUE_PLACEHOLDER, produces = APPLICATION_JSON_VALUE)
    public void getTopWordsCount(final HttpServletResponse response, @PathVariable(name = VALUE) final Integer limit) throws IOException {
        final Map<String, Integer> searchTextWordsMap = topTextWordsService.getTopWordsCount(limit);

        addCsvToResponse(response, searchTextWordsMap);
    }

    private void addCsvToResponse(final HttpServletResponse response, final Map<String, Integer> searchTextWordsMap) throws IOException {
        for (Map.Entry<String, Integer> entry : searchTextWordsMap.entrySet()) {
            response.getWriter().print(String.join(CSV_SEPARATOR, entry.getKey(), entry.getValue().toString()));
            response.getWriter().print(BREAK_LINE);
        }
        response.setContentType(CSV_CONTENT_TYPE);
        response.setHeader(CONTENT_DISPOSITION, CSV_FILE_NAME);
    }
}
