package com.tcdevelopment.cmdMaker.java.actions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CloseStageAction implements EventHandler<ActionEvent> {

    Button backToMainWindowButton;

    public CloseStageAction(Button backButton) {
        this.backToMainWindowButton=backButton;
    }

    @Override
    public void handle(ActionEvent event) {
//                close active stage
        Stage stage = (Stage) backToMainWindowButton.getScene().getWindow();
        stage.close();

    }
}
