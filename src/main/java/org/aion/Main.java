package org.aion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
        primaryStage.setTitle("Fallout 76 Launch Code Cracker");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinHeight(425);
        primaryStage.setMinWidth(725);
        primaryStage.show();

    }

}
