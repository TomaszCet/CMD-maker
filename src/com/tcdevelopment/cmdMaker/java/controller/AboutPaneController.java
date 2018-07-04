package com.tcdevelopment.cmdMaker.java.controller;

import com.tcdevelopment.cmdMaker.java.actions.CloseStageAction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutPaneController implements Initializable {

    @FXML
    Button aboutBackButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        aboutBackButton.setOnAction(new CloseStageAction(aboutBackButton));
    }
}
