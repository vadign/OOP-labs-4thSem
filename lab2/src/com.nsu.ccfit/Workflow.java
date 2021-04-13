package com.nsu.ccfit;

import com.nsu.ccfit.options.Option;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

public class Workflow {
    public void followInputInstruction(String fileName) throws Exception {
        ArrayList<String> text = new ArrayList<>();
        InFileReader myReader = new InFileReader();

        myReader.readInputFile(fileName);
        Map<String, String[]> options = myReader.getOptions();
        Vector<String> commands = myReader.getCommandOrder();

        for (int i = 0; i < commands.size(); i++) {
            String optionName = options.get(commands.get(i))[0];
            Vector<String> args = new Vector<>();

            for (int j = 1; j < options.get(commands.get(i)).length; j++) {
                args.add(options.get(commands.get(i))[j]);
            }


            Option currentOption = Factory.getInstance().createOption(optionName);

            if (currentOption == null) continue;

            currentOption.execute(text, args);

        }
    }

}

