package com.tcdevelopment.cmdMaker.java.actions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutStageCreation implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Stage aboutStage = new Stage();
        Parent aboutParent;
        try {
            aboutParent = FXMLLoader.load(getClass().getResource("../view/about.fxml"));
            aboutStage.setScene(new Scene(aboutParent));
            aboutStage.initModality(Modality.APPLICATION_MODAL);
            aboutStage.setTitle("About");
            aboutStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
