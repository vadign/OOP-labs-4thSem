package com.nsu.ccfit.options;

import com.nsu.ccfit.Exception.WrongNumberOfArgs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Readfile implements Option {
    @Override
    public putType getType(){
        return putType.inputOption;
    }
    public void execute(ArrayList<String> text, Vector<String> args) throws FileNotFoundException, WrongNumberOfArgs {

            if (args.size() - 1 != 1){
                throw new WrongNumberOfArgs("You need to use 1 arg");
            }

            String currentFile = args.get(0);
            String currentString;

            Scanner input = new Scanner(new File(currentFile));
            text.clear();

            while(input.hasNextLine()){
                currentString = input.nextLine();
                String[] words = currentString.split(" ");
                for(var word : words){
                    text.add(word);
                }
            }
    }
}
