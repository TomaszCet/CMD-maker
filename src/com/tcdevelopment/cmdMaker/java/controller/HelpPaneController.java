package com.tcdevelopment.cmdMaker.java.controller;

import com.tcdevelopment.cmdMaker.java.actions.CloseStageAction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class HelpPaneController implements Initializable {

    @FXML
    Button helpBackButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        helpBackButton.setOnAction(new CloseStageAction(helpBackButton));
    }
}
