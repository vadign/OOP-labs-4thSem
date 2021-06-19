package com.nsu.ccfit.options;

import com.nsu.ccfit.Exception.WrongNumberOfArgs;

import java.util.Vector;
import java.util.ArrayList;

public class Sort implements Option {
    @Override
    public void execute(ArrayList<String> text, Vector<String> args) throws WrongNumberOfArgs {
        if (args.size() != 0){
            throw new WrongNumberOfArgs("You need to use 0 arg");
        }

        text.sort((arg1, arg2) -> arg1.compareToIgnoreCase(arg2));
    }

    public putType getType() {
        return putType.changingOption;
    }
}
