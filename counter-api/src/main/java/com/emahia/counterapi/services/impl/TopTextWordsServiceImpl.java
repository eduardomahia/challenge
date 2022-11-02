package com.emahia.counterapi.services.impl;

import com.emahia.counterapi.repositories.TextWordsRepository;
import com.emahia.counterapi.services.TopTextWordsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class TopTextWordsServiceImpl implements TopTextWordsService {

    public static final int DEFAULT_LIMIT_VALUE = 20;

    private TextWordsRepository textWordsRepository;

    @Override
    public Map<String, Integer> getTopWordsCount(final Integer limit) {

        return textWordsRepository.getTopWordsCount((limit == null || limit <= 0)? DEFAULT_LIMIT_VALUE : limit);
    }
}
