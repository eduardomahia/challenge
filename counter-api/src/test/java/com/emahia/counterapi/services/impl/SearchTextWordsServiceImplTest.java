package com.emahia.counterapi.services.impl;

import com.emahia.counterapi.repositories.TextWordsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SearchTextWordsServiceImplTest {

    private static final Map<String, Integer> RESULT_MAP = new HashMap<>();

    @Mock
    private TextWordsRepository textWordsRepository;

    @InjectMocks
    private SearchTextWordsServiceImpl searchTextWordsService;

    @Test
    public void getSearchWordsCountOK() {
        final List<String> words = new ArrayList<>();
        Mockito.doReturn(RESULT_MAP).when(textWordsRepository).getSearchWordsCount(words);
        final Map<String, Integer> result = searchTextWordsService.getSearchWordsCount(words);

        Mockito.verify(textWordsRepository, Mockito.times(1)).getSearchWordsCount(words);
        assertEquals(RESULT_MAP, result);
    }
}