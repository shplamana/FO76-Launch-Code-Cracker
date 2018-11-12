package org.aion.decryption;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFind {

    /**
     * @param pattern
     * @param words
     * @return
     */
    public List<String> findWord(String pattern, List<String> words) {

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
