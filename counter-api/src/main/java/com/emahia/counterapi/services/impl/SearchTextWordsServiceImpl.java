package com.emahia.counterapi.services.impl;

import com.emahia.counterapi.repositories.TextWordsRepository;
import com.emahia.counterapi.services.SearchTextWordsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SearchTextWordsServiceImpl implements SearchTextWordsService {

    private TextWordsRepository textWordsRepository;

    @Override
    public Map<String, Integer> getSearchWordsCount(final List<String> words) {

        return textWordsRepository.getSearchWordsCount(words);
    }
}
