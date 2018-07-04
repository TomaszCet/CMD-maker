package com.tcdevelopment.cmdMaker.java.controller;

import com.tcdevelopment.cmdMaker.java.actions.AboutStageCreation;
import com.tcdevelopment.cmdMaker.java.actions.HelpStageCreation;
import com.tcdevelopment.cmdMaker.java.actions.LabelEditable;
import com.tcdevelopment.cmdMaker.java.actions.MakeCMD;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextArea txtText;

    @FXML
    private TextArea cmdText;

    @FXML
    private Button transformationButton;

    @FXML
    private Button aboutButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button saveButton;

    @FXML
    private ChoiceBox<Integer> tgChoiceBox;

    @FXML
    private ChoiceBox<Integer> cellChoiceBox;

    @FXML
    private CheckBox tgCheckBox;

    @FXML
    private CheckBox cellCheckBox;

    @FXML
    private TextField listOfTgs;

    @FXML
    private  TextField listOfCells;

    public ChoiceBox<Integer> getTgChoiceBox() {
        return tgChoiceBox;
    }

    public void setTgChoiceBox(ChoiceBox<Integer> tgChoiceBox) {
        this.tgChoiceBox = tgChoiceBox;
    }

    public ChoiceBox<Integer> getCellChoiceBox() {
        return cellChoiceBox;
    }

    public void setCellChoiceBox(ChoiceBox<Integer> cellChoiceBox) {
        this.cellChoiceBox = cellChoiceBox;
    }

    public TextField getListOfTgs() {
        return listOfTgs;
    }

    public void setListOfTgs(TextField listOfTgs) {
        this.listOfTgs = listOfTgs;
    }

    public TextField getListOfCells() {
        return listOfCells;
    }

    public void setListOfCells(TextField listOfCells) {
        this.listOfCells = listOfCells;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        initialize Choice Boxes
        tgChoiceBox.getItems().addAll(1,2,3,4);
        tgChoiceBox.getSelectionModel().selectFirst();
        cellChoiceBox.getItems().addAll(1,2,3,4,5,6,7,8);
        cellChoiceBox.getSelectionModel().selectFirst();

        listOfTgs.setEditable(false);
        listOfCells.setEditable(false);


        tgCheckBox.setOnAction(new LabelEditable(tgCheckBox,listOfTgs));

        cellCheckBox.setOnAction(new LabelEditable(tgCheckBox,listOfTgs));

        transformationButton.setOnAction( new MakeCMD(txtText,cmdText));

        aboutButton.setOnAction(new AboutStageCreation());

        helpButton.setOnAction(new HelpStageCreation());
    }

}
