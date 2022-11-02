package com.emahia.counterapi.services.impl;

import com.emahia.counterapi.repositories.TextWordsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class CreateTextWordsServiceImplTest {

    @Mock
    private TextWordsRepository textWordsRepository;

    @InjectMocks
    private CreateTextWordsServiceImpl createTextWordsService;

    @Test
    public void createTextWordsCountTestRepeatedWordOK() {
        final Map<String, Integer> wordsCountMap = new LinkedHashMap<>();
        wordsCountMap.put("testing", 2);


        createTextWordsService.createTextWordsCount("TesTING, tESting.");

        Mockito.verify(textWordsRepository, Mockito.times(1)).updateWordsCount(wordsCountMap);
    }

    @Test
    public void createTextWordsCountTestDifferentWordOK() {
        final Map<String, Integer> wordsCountMap = new LinkedHashMap<>();
        wordsCountMap.put("testing", 1);
        wordsCountMap.put("method", 1);

        createTextWordsService.createTextWordsCount("TesTING, Method.");

        Mockito.verify(textWordsRepository, Mockito.times(1)).updateWordsCount(wordsCountMap);
    }
}