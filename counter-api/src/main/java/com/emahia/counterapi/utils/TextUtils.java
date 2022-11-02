package com.emahia.counterapi.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TextUtils {

    public static final String REGEX = "[a-zA-Z]+";

    public static List<String> getNormalizedWordsFromText(final String text){
        final List<String> normalizedTextWords = new ArrayList<>();

        if (StringUtils.isNoneEmpty(text)){
            final Pattern pattern = Pattern.compile(REGEX);
            final Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                final String normalizedWord = getTextNormalized(matcher.group());
                normalizedTextWords.add(normalizedWord);
            }
        }
        return normalizedTextWords;
    }

    public static String getTextNormalized(final String text){

        return (StringUtils.isNoneEmpty(text)? text.toLowerCase().trim(): text);
    }
}
