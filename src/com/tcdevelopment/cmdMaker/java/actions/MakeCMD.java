package com.tcdevelopment.cmdMaker.java.actions;

import com.tcdevelopment.cmdMaker.java.controller.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MakeCMD implements EventHandler<ActionEvent> {


    private MainController mainController;

    public MakeCMD(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void handle(ActionEvent event) {
        {
            String[] txtTable = mainController.getTxtText().getText().split(Constants.NEW_LINE);
            StringBuilder cmdTextBuilder = new StringBuilder("");
            cmdTextBuilder.append(Constants.BEFORE_TEST_COMMENT).append(Constants.TC_VARIABLES).append(Constants.MAIN_COMMANDS_SEPARATOR)
                    .append(Constants.NEW_LINE);
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
                    MmlCommandMultiplication mmlCommandMultiplication = new MmlCommandMultiplication(str,mainController);
                    cmdTextBuilder.append(mmlCommandMultiplication.makeOperation());
                }
            }
            mainController.getCmdText().setText(cmdTextBuilder.toString());


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

        public static final String TC_VARIABLES = "@CLEAR\n" +
                "@COMMENT \"GENERATED IN CMDmaker\" \n" +
                "@SET {tg} =   \"\"  \n" +
                "@SET {cell[0]} =   \"\"  \n" +
                "@SET {cell[1]} =   \"\"  \n" +
                "@SET {cell[2]} =   \"\"  \n" +
                "@SET {cell[3]} =   \"\"  \n" +
                "@COMPACT {cell}\n\n" +
                "@PRESERVE \n";

        public static final String BEFORE_TEST_COMMENT = "!FILL AND RUN BELOW COMMANDS IF NEEDED!\n\n";

        public static final String MAIN_COMMANDS_SEPARATOR = "!-----------------------------------------------! \n" +
                                                     "!------------------Main commands----------------! \n" +
                                                     "!-----------------------------------------------! \n" ;
    }
}
