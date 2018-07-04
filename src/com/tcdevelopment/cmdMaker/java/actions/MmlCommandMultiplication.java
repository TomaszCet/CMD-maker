package com.tcdevelopment.cmdMaker.java.actions;

import com.tcdevelopment.cmdMaker.java.controller.MainController;



public class MmlCommandMultiplication {

    private String commandToMultiple;
    public MmlCommandMultiplication(String lineToMultiply) {
        this.commandToMultiple=lineToMultiply;
    }

    private String makeOperation(){
        StringBuilder multipliedLine = new StringBuilder("");
        boolean haveAListOfCells = true;
        boolean haveAListOfTgs = true;
        MainController mainController = new MainController();
        String[] tgArray = mainController.getListOfTgs().getCharacters().toString().split(",");
        String[] cellArray = mainController.getListOfCells().getCharacters().toString().split(",");
        int tgNumber = tgArray.length;
        int cellNumber = cellArray.length;

        if (tgNumber  == 0){
            tgNumber = mainController.getTgChoiceBox().getValue().intValue();
            haveAListOfTgs = false;
        }

        if (cellNumber  == 0){
            cellNumber = mainController.getTgChoiceBox().getValue().intValue();
            haveAListOfCells = false;
        }

        int splitPlace = commandToMultiple.indexOf(";")+1;
        String possibleComment = commandToMultiple.substring(splitPlace);

        if (commandToMultiple.contains("{tg}") && haveAListOfTgs){
            for (int i = 0; i < tgNumber; i++){
                String tmpCommand = commandToMultiple.replace("{tg}",tgArray[i]);
                String cmd = tmpCommand.substring(0,splitPlace);
                multipliedLine.append(cmd)
                        .append(possibleComment.trim().length() >= 1 ? "         ! " + possibleComment.trim() + " !" : "")
                        .append(MakeCMD.Constants.NEW_LINE);
            }

        } else if (commandToMultiple.contains("{tg}") && !haveAListOfCells){
            for (int i = 0; i < tgNumber; i++){
                String cmd = commandToMultiple.substring(0,splitPlace);
                multipliedLine.append(cmd)
                        .append(possibleComment.trim().length() >= 1 ? "         ! " + possibleComment.trim() + " !" : "")
                        .append(MakeCMD.Constants.NEW_LINE);
            }

        }

        return multipliedLine.toString();
    }
}
