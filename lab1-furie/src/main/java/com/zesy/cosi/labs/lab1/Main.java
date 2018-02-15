package com.zesy.cosi.labs.lab1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        URL fxmlURL = getClass().getClassLoader().getResource("sample.fxml");
        if (fxmlURL != null) {
            try {
                Parent root = FXMLLoader.load(fxmlURL);
                primaryStage.setTitle("Преобразования Фурье");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Can not load fxml file");
        }
    }
}
