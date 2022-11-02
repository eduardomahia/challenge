package com.emahia.counterapi.repositories;

import java.util.List;
import java.util.Map;

public interface TextWordsRepository {

    public Map<String, Integer> getTopWordsCount(int topNumber);

    public Map<String, Integer> getSearchWordsCount(List<String> words);

    public Map<String, Integer> updateWordsCount(Map<String, Integer> WordCountEntityList);

}
