package com.tcdevelopment.cmdMaker.conctroller;

import com.tcdevelopment.cmdMaker.actions.MakeCMD;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextArea txtText;

    @FXML
    private TextArea cmdText;

    @FXML
    private Button transformationButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        transformationButton.setOnAction( new MakeCMD(txtText,cmdText));

    }

}
