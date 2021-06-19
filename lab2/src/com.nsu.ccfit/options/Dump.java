package com.nsu.ccfit.options;

import com.nsu.ccfit.Exception.WrongNumberOfArgs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

public class Dump implements Option {

    @Override
    public putType getType(){
        return putType.changingOption;
    }

    public void execute(ArrayList<String> text, Vector<String> args) throws WrongNumberOfArgs, IOException {

        if (args.size() != 1){
            throw new WrongNumberOfArgs("You need to use 1 arg");
        }

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