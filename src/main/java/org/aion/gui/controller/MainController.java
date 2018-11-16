package org.aion.gui.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.aion.gui.model.MainModel;

public class MainController {

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
    public RadioButton optDict;
    public RadioButton comDict;

    public ToggleGroup dict;

    public void execute(ActionEvent actionEvent) {

        solutions.setText("Waiting for solutions....");

        new Thread(() -> solutions.setText(new MainModel().execute(dict, getCipherText(), getCipherCode(), pattern.getText()))).start();

//        debug
//        new Thread(() -> solutions.setText(new MainModel().execute(dict, "ABDFHOPX", "06828161", pattern.getText()))).start();


    }

    private String getCipherText() {
        return cipherTextOne.getText() + cipherTextTwo.getText() + cipherTextThree.getText() + cipherTextFour.getText() + cipherTextFive.getText() + cipherTextSix.getText() + cipherTextSeven.getText() + cipherTextEight.getText();
    }

    private String getCipherCode() {
        return cipherCodeOne.getText() + cipherCodeTwo.getText() + cipherCodeThree.getText() + cipherCodeFour.getText() + cipherCodeFive.getText() + cipherCodeSix.getText() + cipherCodeSeven.getText() + cipherCodeEight.getText();
    }

}
