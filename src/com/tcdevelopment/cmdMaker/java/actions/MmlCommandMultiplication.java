package com.tcdevelopment.cmdMaker.java.actions;

import com.tcdevelopment.cmdMaker.java.controller.MainController;
import javafx.scene.control.TextField;


public class MmlCommandMultiplication {

    private String commandToMultiple;
    private MainController mainController;

    public MmlCommandMultiplication(String lineToMultiply, MainController mainController) {
        this.commandToMultiple=lineToMultiply;
        this.mainController = mainController;
    }

    public String makeOperation(){
//        initialize parameters
        StringBuilder multipliedLine = new StringBuilder("");
        boolean haveAListOfCells = true;
        boolean haveAListOfTgs = true;
        TextField tgList = mainController.getListOfTgs();
        TextField cellList = mainController.getListOfCells();
        String[] tgArray = tgList.getText().split(",");
        String[] cellArray = mainController.getListOfCells().getCharacters().toString().split(",");
        int tgNumber = tgArray.length;
        int cellNumber = cellArray.length;

//        check if lists ara enabled
        if (!tgList.isEditable()){
            tgNumber = mainController.getTgChoiceBox().getValue();
            haveAListOfTgs = false;
        }
        if (!cellList.isEditable()){
            cellNumber = mainController.getTgChoiceBox().getValue();
            haveAListOfCells = false;
        }

        int splitPlace = commandToMultiple.indexOf(";")+1;
        String possibleComment = commandToMultiple.substring(splitPlace);
        if (commandToMultiple.contains("{tg}") && haveAListOfTgs){
            for (int i = 0; i < tgNumber; i++){
                String tmpCommand = commandToMultiple.substring(0,splitPlace);
                String cmd = tmpCommand.replace("{tg}",tgArray[i]);
                multipliedLine.append(cmd)
                        .append(possibleComment.trim().length() >= 1 ? "         ! " + possibleComment.trim() + " !" : "")
                        .append(MakeCMD.Constants.NEW_LINE);
            }
        } else if (commandToMultiple.contains("{tg}") && !haveAListOfTgs){
            for (int i = 0; i < tgNumber; i++){
                String tmpCommand = commandToMultiple.substring(0,splitPlace);
                String cmd = tmpCommand.replace("{tg}","{tg["+i+"]}");
                multipliedLine.append(cmd)
                        .append(possibleComment.trim().length() >= 1 ? "         ! " + possibleComment.trim() + " !" : "")
                        .append(MakeCMD.Constants.NEW_LINE);
            }
        }

        if (commandToMultiple.contains("{cell}") && haveAListOfCells){
            for (int i = 0; i < cellNumber; i++){
                String tmpCommand = commandToMultiple.substring(0,splitPlace);
                String cmd = tmpCommand.replace("{cell}",cellArray[i]);
                multipliedLine.append(cmd)
                        .append(possibleComment.trim().length() >= 1 ? "         ! " + possibleComment.trim() + " !" : "")
                        .append(MakeCMD.Constants.NEW_LINE);
            }
        } else if (commandToMultiple.contains("{cell}") && !haveAListOfCells){
            for (int i = 0; i < cellNumber; i++){
                String tmpCommand = commandToMultiple.substring(0,splitPlace);
                String cmd = tmpCommand.replace("{cell}","{cell["+i+"]}");
                multipliedLine.append(cmd)
                        .append(possibleComment.trim().length() >= 1 ? "         ! " + possibleComment.trim() + " !" : "")
                        .append(MakeCMD.Constants.NEW_LINE);
            }
        }
        return multipliedLine.toString();
    }
}
