package com.emahia.counterapi.services;

import java.util.Map;

public interface TopTextWordsService {

    public Map<String, Integer> getTopWordsCount(Integer limit);
}
