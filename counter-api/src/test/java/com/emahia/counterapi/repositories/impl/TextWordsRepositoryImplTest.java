package com.emahia.counterapi.repositories.impl;

import com.emahia.counterapi.utils.TextUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class TextWordsRepositoryImplTest {

    private static final Map<String, Integer> MAP = new HashMap<>();
    private static final String CASE = "case";
    public static final String TEST = "test";

    @InjectMocks
    private TextWordsRepositoryImpl textWordsRepository;

    @BeforeEach
    public void initData() {
        MAP.put(CASE, 2);
        MAP.put(TEST, 1);
        textWordsRepository.updateWordsCount(MAP);
    }

    @Test
    public void getTopWordsCountOK() {
        final Map<String, Integer> result = textWordsRepository.getTopWordsCount(1);

        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertTrue(result.entrySet().stream().findFirst().get().getKey() == CASE);
    }

    @Test
    public void getSearchWordsCountOK() {
        final Map<String, Integer> result = textWordsRepository.getSearchWordsCount(Arrays.asList(CASE));

        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertTrue(result.entrySet().stream().findFirst().get().getKey() == CASE);
        assertTrue(result.entrySet().stream().findFirst().get().getValue() == 2);
    }
}