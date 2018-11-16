package org.aion.gui.model;

import javafx.scene.control.ToggleGroup;
import org.aion.decryption.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainModel {

    public String execute(ToggleGroup dict, String cipherText, String cipherCode, String pattern) {

        String keywordsPath = null;
        String wordsPath = null;

        if (dict.getSelectedToggle() == dict.getToggles().get(0)) {

            keywordsPath = "/words/words_alpha_no_dupes.txt";
            wordsPath = "/words/words_alpha_8.txt";

        } else if (dict.getSelectedToggle() == dict.getToggles().get(1)) {

            keywordsPath = "/words/words_alpha.txt";
            wordsPath = "/words/words_alpha.txt";

        }

        // Load the dictionary
        List<String> words = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(keywordsPath), StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

        // Find possible keywords
        List<String> keywords = new WordFind().findWord(pattern, words);

        // Get a list of words that match our cipher text length
        List<String> wordsWeWant = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(wordsPath), StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

        // Decipher with all possible keywords
        List<Solution> solutionsList = new ArrayList<>();
        for (String keyword : keywords) {
            solutionsList.add(
                    new Solution(cipherText, new KeywordCipher().decrypt(cipherText, keyword), "")
            );
        }

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

        if (!codeSolutions.isEmpty()) {
            return String.join("\n", codeSolutions);
        } else {
            return "No solutions found, please check input";
        }

    }

}
