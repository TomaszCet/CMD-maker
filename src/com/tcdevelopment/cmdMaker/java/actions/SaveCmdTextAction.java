package com.tcdevelopment.cmdMaker.java.actions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCmdTextAction implements EventHandler<ActionEvent> {

    TextArea cmdText;
    public SaveCmdTextAction(TextArea cmdText) {
        this.cmdText = cmdText;
    }

    @Override
    public void handle(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CMD files (*.cmd)", "*.cmd");
        fileChooser.getExtensionFilters().add(extFilter);
        //Show save file dialog
        File file = fileChooser.showSaveDialog(cmdText.getScene().getWindow());

        if(file != null){
            saveFile(cmdText.getText(), file);
        }
    }

    private void saveFile(String content, File file){
        try {
            FileWriter  fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
//            System.out.println(ex.toString());
        }

    }
}
