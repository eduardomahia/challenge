package com.emahia.counterapi.repositories.impl;

import com.emahia.counterapi.repositories.TextWordsRepository;
import com.emahia.counterapi.utils.TextUtils;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class TextWordsRepositoryImpl implements TextWordsRepository {

    private Map<String, Integer> wordsCountMap = new LinkedHashMap<>();

    @Override
    public Map<String, Integer> getTopWordsCount(final int topNumber) {

        return wordsCountMap.entrySet().stream()
                .limit((topNumber > wordsCountMap.size()) ? wordsCountMap.size() : topNumber)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1,v2) -> v1, LinkedHashMap::new));
    }

    @Override
    public Map<String, Integer> getSearchWordsCount(final List<String> words) {
        final Map<String, String> wordNormalizationMap = new HashMap<>();
        words.forEach(word -> wordNormalizationMap.put(word, TextUtils.getTextNormalized(word)));

        final Map<String, Integer> searchWordsCountMap = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : wordNormalizationMap.entrySet()) {
            Optional.ofNullable(wordsCountMap.get(entry.getValue()))
                    .ifPresentOrElse(count -> searchWordsCountMap.put(entry.getKey(), count), () -> searchWordsCountMap.put(entry.getKey(), 0));
        }
        return searchWordsCountMap;
    }

    @Override
    public Map<String, Integer> updateWordsCount(final Map<String, Integer> wordCountEntityList) {
        final Map<String, Integer> sortedWordsCountMap = wordCountEntityList.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        wordsCountMap = sortedWordsCountMap;

        return sortedWordsCountMap;
    }
}
