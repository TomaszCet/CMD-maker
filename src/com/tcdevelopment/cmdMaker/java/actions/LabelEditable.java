package com.tcdevelopment.cmdMaker.java.actions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class LabelEditable implements EventHandler<ActionEvent> {

    private CheckBox checkBox;
    private TextField textField;


    public LabelEditable(CheckBox checkBox, TextField textField) {
        this.checkBox = checkBox;
        this.textField = textField;
    }

    @Override
    public void handle(ActionEvent event) {
        if (checkBox.isSelected()){
            textField.setEditable(true);
        } else {
            textField.clear();
            textField.setEditable(false);
        }
    }
}
