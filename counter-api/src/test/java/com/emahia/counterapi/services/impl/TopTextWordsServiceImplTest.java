package com.emahia.counterapi.services.impl;

import static org.junit.Assert.*;

import com.emahia.counterapi.repositories.TextWordsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class TopTextWordsServiceImplTest {

    private static final Map<String, Integer> RESULT_MAP = new HashMap<>();

    @Mock
    private TextWordsRepository textWordsRepository;

    @InjectMocks
    private TopTextWordsServiceImpl topTextWordsService;

    @Test
    public void getTopWordsCountOK() {
        Mockito.doReturn(RESULT_MAP).when(textWordsRepository).getTopWordsCount(2);
        final Map<String, Integer> result = topTextWordsService.getTopWordsCount(2);

        Mockito.verify(textWordsRepository, Mockito.times(1)).getTopWordsCount(2);
        assertEquals(RESULT_MAP, result);
    }

    @Test
    public void getTopWordsCountIncorrectLimitValueOK() {
        Mockito.doReturn(RESULT_MAP).when(textWordsRepository).getTopWordsCount(20);
        final Map<String, Integer> result = topTextWordsService.getTopWordsCount(-5);

        Mockito.verify(textWordsRepository, Mockito.times(1)).getTopWordsCount(20);
        assertEquals(RESULT_MAP, result);
    }
}