package com.zesy.cosi.labs.lab1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class Main {//extends Application {

    public static void main(String[] args) throws Exception {
        InputStream tmp = Main.class.getClassLoader().getResourceAsStream("sample.fxml");
        System.out.println(tmp.available());
    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("../../resources/sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
}
