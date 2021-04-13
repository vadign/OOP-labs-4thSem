package com.nsu.ccfit.options;

import java.util.*;
enum putType{
    inputOption,
    outputOption,
    changingOption
}

public interface Option {

    void execute(ArrayList<String> text, Vector<String> args) throws Exception;

    putType getType();

}


