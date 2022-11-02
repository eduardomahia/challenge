package com.emahia.counterapi.services.impl;

import com.emahia.counterapi.repositories.TextWordsRepository;
import com.emahia.counterapi.services.CreateTextWordsService;
import com.emahia.counterapi.utils.TextUtils;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CreateTextWordsServiceImpl implements CreateTextWordsService {

    private TextWordsRepository textWordsRepository;

    @Override
    public void createTextWordsCount(final String text) {
        if (StringUtils.isNoneEmpty(text)) {
            final List<String> normalizedTextWords = TextUtils.getNormalizedWordsFromText(text);
            final Map<String, Integer> wordsCountMap = getWordsCountMap(normalizedTextWords);

            textWordsRepository.updateWordsCount(wordsCountMap);
        }
    }

    private Map<String, Integer> getWordsCountMap(List<String> textWords) {
        final Map<String, Integer> wordsCountMap = new HashMap<>();
        textWords.forEach(word -> Optional.ofNullable(wordsCountMap.get(word)).ifPresentOrElse(count -> wordsCountMap.put(word, count + 1), () -> wordsCountMap.put(word, 1)));

        return wordsCountMap;
    }
}