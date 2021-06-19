package com.nsu.ccfit.options;

import com.nsu.ccfit.Exception.WrongNumberOfArgs;

import java.util.ArrayList;
import java.util.Vector;

public class Grep implements Option {
    @Override
    public putType getType() {
        return putType.changingOption;
    }

    public void execute(ArrayList<String> text, Vector<String> args) throws WrongNumberOfArgs {

        if (args.size() != 1){
            throw new WrongNumberOfArgs("You need to use 1 arg");
        }

        String word = args.get(0);

        for (int i = 0; i < text.size(); i++) {
            if (!text.get(i).contains(word)) {
                text.remove(i);
                i--;
            }
        }
    }


}