package org.aion.gui.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.aion.decryption.KeywordCipher;
import org.aion.decryption.Scrambler;
import org.aion.decryption.WordFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class main {

    public TextArea cipherText;
    public TextArea pattern;
    public TextArea solutions;
    public Button execute;

    public void exectue(ActionEvent actionEvent) {

        List<String> keywords = new WordFind().findWord(pattern.getText());

        List<String> words = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/words/words_alpha.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

        for (String keyword : keywords) {

            String decryptedText = new KeywordCipher().decrypt(cipherText.getText(), keyword);

            solutions.setText(Scrambler.findOptions(decryptedText, words));
        }

    }

}
