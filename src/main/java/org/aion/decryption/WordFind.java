package org.aion.decryption;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordFind {

    /**
     * @param pattern
     * @return
     */
    public List<String> findWord(String pattern) {

        List<String> words = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/words/words_alpha.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

        List<String> matchedWords = new ArrayList<>();

        Pattern keywordPattern = Pattern.compile(pattern);

        Matcher m;

        for (String word : words) {
            m = keywordPattern.matcher(word);
            if (m.matches()) {
                matchedWords.add(word);
            }
        }


        return matchedWords;
    }
}
