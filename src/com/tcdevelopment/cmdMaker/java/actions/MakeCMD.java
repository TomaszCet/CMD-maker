package com.tcdevelopment.cmdMaker.java.actions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

public class MakeCMD implements EventHandler<ActionEvent> {

    private TextArea txtText;
    private TextArea cmdText;

    public MakeCMD(TextArea input, TextArea output) {
        this.txtText = input;
        this.cmdText = output;
    }

    @Override
    public void handle(ActionEvent event) {
        {
            String[] txtTable = txtText.getText().split(Constants.NEW_LINE);
            StringBuilder cmdTextBuilder = new StringBuilder("");
            for (String str: txtTable) {
                str = replaceParameter(str, new ParameterPairs("cell"));
                str = replaceParameter(str, new ParameterPairs("tg"));
                if (str.matches(" *")){
                    cmdTextBuilder.append(Constants.NEW_LINE);
                    continue;
                }
                if (!str.matches("^ *.{5}:.*")) {
                    cmdTextBuilder.append("! ").append(str).append(" !\n");
                }
                else {
                    int splitPlace = str.indexOf(";")+1;
                    String cmd = str.substring(0,splitPlace);
                    String possibleComment = str.substring(splitPlace);
                    cmdTextBuilder.append(cmd)
                            .append(possibleComment.trim().length() >= 1 ? "         ! " + possibleComment.trim() + " !" : "")
                            .append(Constants.NEW_LINE);
                }
            }
            cmdText.setText(cmdTextBuilder.toString());


        }
    }

    public String replaceParameter(String str, ParameterPairs pair) {
        if (str.contains(pair.getDocParam())) {
            str = str.replace(pair.getDocParam(), pair.getMmlParam());
        }
        return str;
    }

    class Constants{

        public static final String NEW_LINE = "\n";

        public static final String TC_BEGINING = "@CLEAR\n" +
                "@COMMENT \"Author: etomcet\" \n" +
                "@SET {tg} =  \n" +
                "@SET {cell[0]} =   \"\"  \n" +
                "@SET {cell[1]} =   \"\"  \n" +
                "@SET {cell[2]} =   \"\"  \n" +
                "@COMPACT {cell}\n" +
                "@SIZE {cell} {cellsize}\n" +
                "\n" +
                "@PRESERVE \n";

    }
}
