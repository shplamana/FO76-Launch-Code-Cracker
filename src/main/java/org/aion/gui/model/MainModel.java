package org.aion.gui.model;

import org.aion.decryption.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class MainModel {

    private List<String> words;

    public MainModel() {
        words = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/words/words_alpha.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
    }

    public String execute(String cipherText, String cipherCode, String pattern) {

        cipherText = "ABDFHOPX"; // debug
        cipherCode = "06828161"; // debug
        String finalCipherText = cipherText;
        String finalCipherCode = cipherCode;

        List<String> keywords = new WordFind().findWord(pattern, words);
        List<String> deciphered = keywords.stream().map(keyword -> new KeywordCipher().decrypt(finalCipherText, keyword)).collect(Collectors.toList());
        List<Solution> solutionsList = deciphered.stream().map(s -> new Solution(finalCipherText, s, Scrambler.findOptions(s, words))).collect(Collectors.toList());
        List<String> codeSolutions = solutionsList.stream().filter(solution -> !solution.getCodeword().isEmpty()).map(solution -> Substitution.codeSubstitution(finalCipherText, finalCipherCode, solution.getDecoded(), solution.getCodeword())).collect(Collectors.toList());

        return String.join("\n", codeSolutions);

    }

}
