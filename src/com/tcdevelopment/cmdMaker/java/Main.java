package com.tcdevelopment.cmdMaker.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        int height = 425;
        int width = 600;
        Parent root = FXMLLoader.load(getClass().getResource("view/mainPane.fxml"));
        primaryStage.setTitle("CMD Maker");
        primaryStage.setScene(new Scene(root, 600, 425));
//        Add icon to the app
        Image icon = new Image("file:cmdIcon.png");
        primaryStage.getIcons().add(icon);
//        wymiary
        primaryStage.setMinHeight(height+50);
        primaryStage.setMinWidth(width+20);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
