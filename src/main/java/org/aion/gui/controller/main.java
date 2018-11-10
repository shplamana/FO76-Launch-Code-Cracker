package org.aion.gui.controller;

import javafx.event.ActionEvent;
import org.aion.decryption.Scrambler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class main {

    public void exectue(ActionEvent actionEvent) {
        Scrambler.findOptions("glanoity", new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/words/words_alpha.txt"), StandardCharsets.UTF_8)).lines().collect(Collectors.toList()));
    }

}
