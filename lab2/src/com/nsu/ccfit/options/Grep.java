package com.nsu.ccfit.options;

import java.util.ArrayList;
import java.util.Vector;

public class Grep implements Option {
    @Override
    public putType getType() {
        return putType.changingOption;
    }

    public void execute(ArrayList<String> text, Vector<String> args) throws Exception {
        String word = args.get(0);

        for (int i = 0; i < text.size(); i++) {
            if (!text.get(i).contains(word)) {
                text.remove(i);
                i--;
            }
        }
    }


}