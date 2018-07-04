package com.tcdevelopment.cmdMaker.java.actions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelpStageCreation implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Stage helpStage = new Stage();
        Parent helpParent;
        try {
            helpParent = FXMLLoader.load(getClass().getResource("../view/help.fxml"));
            helpStage.setScene(new Scene(helpParent));
            helpStage.initModality(Modality.APPLICATION_MODAL);
            helpStage.setTitle("Help");
            helpStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
