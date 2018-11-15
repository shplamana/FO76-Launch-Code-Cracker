package org.aion.gui.model;

import org.aion.decryption.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainModel {

    public String execute(String cipherText, String cipherCode, String pattern) {

        // Load the dictionary
        List<String> words = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/words/words_alpha_no_dupes.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

        // Find possible keywords
        List<String> keywords = new WordFind().findWord(pattern, words);

        // Find keywords that match our cipher text length
        List<String> wordsWeWant = new ArrayList<>();
        for (String word : words) {
            if (word.length() == cipherText.length()) {
                wordsWeWant.add(word);
            }
        }

        // Decipher with all possible keywords
        List<Solution> solutionsList = new ArrayList<>();
        for (String keyword : keywords) {
            solutionsList.add(
                    new Solution(cipherText, new KeywordCipher().decrypt(cipherText, keyword), "")
            );
        }

//        for (Solution solution : solutionsList) {
//            solution.setCodeword(Scrambler.unscramble(solution.getDecoded(), wordsWeWant));
//        }

        // Unscramble deciphered text
        solutionsList = Scrambler.unscramble(solutionsList, wordsWeWant);

        // Do the text/cipher substitution
        List<String> codeSolutions = new ArrayList<>();
        for (Solution solution : solutionsList) {
            if (!solution.getCodeword().isEmpty()) {
                codeSolutions.add(
                        Substitution.codeSubstitution(cipherText, cipherCode, solution.getDecoded(), solution.getCodeword())
                );
            }
        }

        return String.join("\n", codeSolutions);

    }

}
