package com.tcdevelopment.cmdMaker.conctroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private static final String NEW_LINE = "\n";
    @FXML
    private TextArea txtText;

    @FXML
    private TextArea cmdText;

    @FXML
    private Button transformationButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        transformationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final String TC_BEGINING = "@CLEAR\n" +
                        "@COMMENT \"Author: etomcet\" \n" +
                        "@SET {tg} =  505\n" +
                        "@SET {cell[0]} =   \"481C6\"    \n" +
                        "@SET {cell[1]} =   \"\"  \n" +
                        "@SET {cell[2]} =   \"\"  \n" +
                        "@COMPACT {cell}\n" +
                        "@SIZE {cell} {cellsize}\n" +
                        "\n" +
                        "@PRESERVE ";
                String[] txtTable = txtText.getText().split(NEW_LINE);
                StringBuilder cmdTextBuilder = new StringBuilder(TC_BEGINING);
                for (String str: txtTable) {
                    if (str.contains("<cell>")){
                        str=str.replace("<cell>","{cell}");
                    }
                    if (str.contains("<tg>")){
                        str=str.replace("<tg>","{tg}");
                    }
                    if (str.matches(" *")){
                        cmdTextBuilder.append(NEW_LINE);
                        continue;
                    }
                    if (!str.matches("^ *.{5}:.*")) {
                        cmdTextBuilder.append("! ").append(str).append(" !\n");
                    }
                    else {
                        int splitPlace = str.indexOf(";")+1;
                        String cmd = str.substring(0,splitPlace);
                        cmdTextBuilder.append(cmd).append(str.substring(splitPlace).trim().length() >= 1?"         ! "+str.substring(splitPlace).trim()+" !":"").append(NEW_LINE);
                    }
                }
                cmdText.setText(cmdTextBuilder.toString());


            }
        });

    }

}
