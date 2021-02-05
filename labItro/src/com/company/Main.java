package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Counter myCounter = new Counter();

        myCounter.ReadInput();
        myCounter.writeOutput();
    }

}
