package com.emahia.counterapi.controllers;

import com.emahia.counterapi.controllers.model.SearchTextRequest;
import com.emahia.counterapi.controllers.model.SearchTextResponse;
import com.emahia.counterapi.services.SearchTextWordsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

import static com.emahia.counterapi.utils.constants.RestConstants.SEARCH_PATH;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
public class SearchTextWordsController {

    private SearchTextWordsService searchTextWordsService;

    @PostMapping(value = SEARCH_PATH, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public SearchTextResponse searchTextWords(@RequestBody final SearchTextRequest request) {
        final Map<String, Integer> searchTextWordsMap = searchTextWordsService.getSearchWordsCount(request.getSearchText());

        return SearchTextResponse.builder().counts(searchTextWordsMap.entrySet().stream().collect(Collectors.toList())).build();
    }
}
