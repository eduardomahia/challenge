package com.emahia.counterapi.config;

import com.emahia.counterapi.services.CreateTextWordsService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
public class DataInitConfig {

    private CreateTextWordsService createTextWordsService;

    @PostConstruct
    public void initData(){

        createTextWordsService.createTextWordsCount(getInitText());
    }

    private String getInitText() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("data/text.txt")) {
            if (is == null) return StringUtils.EMPTY;
            try (InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader reader = new BufferedReader(isr)) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return StringUtils.EMPTY;
        }
    }
}
