package com.emahia.counterapi.services;

import java.util.List;
import java.util.Map;

public interface SearchTextWordsService {

    public Map<String, Integer> getSearchWordsCount(List<String> words);
}
