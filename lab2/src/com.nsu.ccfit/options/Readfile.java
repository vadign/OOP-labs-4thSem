package com.nsu.ccfit.options;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Readfile implements Option{
    @Override
    public putType getType(){
        return putType.inputOption;
    }
    public void execute(ArrayList<String> text, Vector<String> args) throws Exception {

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
