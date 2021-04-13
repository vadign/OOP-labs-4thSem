package com.nsu.ccfit.options;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

public class Dump implements Option {

    @Override
    public putType getType(){
        return putType.changingOption;
    }

    public void execute(ArrayList<String> text, Vector<String> args) throws Exception {

        FileWriter fileWriter;
        PrintWriter printWriter;

        fileWriter = new FileWriter(args.get(0));
        printWriter = new PrintWriter(fileWriter);

        for (String word : text) {
            printWriter.println(word);
        }

        fileWriter.close();
        printWriter.close();
    }

}