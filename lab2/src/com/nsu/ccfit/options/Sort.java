package com.nsu.ccfit.options;

import java.util.Vector;
import java.util.ArrayList;

public class Sort implements Option {
    @Override
    public void execute(ArrayList<String> text, Vector<String> args) throws Exception {
        text.sort((arg1, arg2) -> arg1.compareToIgnoreCase(arg2));
    }

    public putType getType() {
        return putType.changingOption;
    }
}
