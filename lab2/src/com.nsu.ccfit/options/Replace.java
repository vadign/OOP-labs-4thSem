package com.nsu.ccfit.options;

import com.nsu.ccfit.Exception.WrongNumberOfArgs;

import java.util.ArrayList;
import java.util.Vector;

public class Replace implements Option {
    @Override
    public putType getType() {
        return putType.changingOption;
    }

    public void execute(ArrayList<String> text, Vector<String> args) throws WrongNumberOfArgs {
        if (args.size() != 2){
            throw new WrongNumberOfArgs("You need to use 2 args");
        }

        String word1, word2;
        word1 = args.get(0);
        word2 = args.get(1);

        for (int i = 0; i < text.size(); i++) {
            String currentString = text.get(i);
            currentString = currentString.replaceAll(word1, word2);

            text.add(i+1, currentString);
            text.remove(i);
        }
    }
}
