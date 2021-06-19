package com.nsu.ccfit;

import com.nsu.ccfit.options.Option;
import com.nsu.ccfit.options.putType;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Logger;

public class Workflow {
    private static Logger myLogger = Logger.getLogger(Factory.class.getName());

    public void followInputInstruction(String fileName) throws Exception {
        ArrayList<String> text = new ArrayList<>();
        InFileReader myReader = new InFileReader();

        myReader.readInputFile(fileName);
        Map<String, String[]> options = myReader.getOptions();
        Vector<String> commands = myReader.getCommandOrder();

        myLogger.info("Working with options started");

        for (int i = 0; i < commands.size(); i++) {

            String optionName = options.get(commands.get(i))[0];

            Vector<String> args = new Vector<>();

            for (int j = 1; j < options.get(commands.get(i)).length; j++) {
                args.add(options.get(commands.get(i))[j]);
            }

            Option currentOption = Factory.getInstance().createOption(optionName);

            if (i == 0 && currentOption.getType() != putType.inputOption) {
                throw new Exception("You should start using input option");
            }

            if (i == options.size() - 1 && currentOption.getType() != putType.outputOption) {
                throw new Exception("You should end using output option");
            }

            try {
                currentOption.execute(text, args);
                myLogger.info(optionName + " executed");
            } catch (Exception e){
                myLogger.warning("Can't create option:  " + optionName);
            }
        }

        myLogger.info("Job done!");
    }

}

