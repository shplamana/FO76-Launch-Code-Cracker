package org.aion.gui.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.aion.decryption.KeywordCipher;
import org.aion.decryption.Scrambler;
import org.aion.decryption.WordFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class main {

    public TextField cipherTextOne;
    public TextField cipherTextTwo;
    public TextField cipherTextThree;
    public TextField cipherTextFour;
    public TextField cipherTextFive;
    public TextField cipherTextSix;
    public TextField cipherTextSeven;
    public TextField cipherTextEight;
    public TextField cipherCodeOne;
    public TextField cipherCodeTwo;
    public TextField cipherCodeThree;
    public TextField cipherCodeFour;
    public TextField cipherCodeFive;
    public TextField cipherCodeSix;
    public TextField cipherCodeSeven;
    public TextField cipherCodeEight;

    public TextField pattern;
    public TextArea solutions;
    public Button execute;

    private List<String> words;

    public main() {
        words = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/words/words_alpha.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
    }

    public void execute(ActionEvent actionEvent) {

        List<String> keywords = new WordFind().findWord(pattern.getText(), words);
        List<String> unscrambled = new ArrayList<>();

        for (String keyword : keywords) {

            String decryptedText = new KeywordCipher().decrypt(getCipherText(), keyword);

            solutions.setText(Scrambler.findOptions(decryptedText, words));
        }

        solutions.setText("something goes here");

    }

    private String getCipherText() {
        return cipherTextOne.getText() + cipherTextTwo.getText() + cipherTextThree.getText() + cipherTextFour.getText() + cipherTextFive.getText() + cipherTextSix.getText() + cipherTextSeven.getText() + cipherTextEight.getText();
    }

    private String getCipherCode() {
        return cipherCodeOne.getText() + cipherCodeTwo.getText() + cipherCodeThree.getText() + cipherCodeFour.getText() + cipherCodeFive.getText() + cipherCodeSix.getText() + cipherCodeSeven.getText() + cipherCodeEight.getText();
    }

}
