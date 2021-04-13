package com.nsu.ccfit;

import java.io.File;
import java.util.*;

public class InFileReader {
    private Map<String, String[]> options = new HashMap<>();
    private Vector<String> commandOrder = new Vector<>();
    private boolean isCsedInFile;

    public Map<String, String[]> getOptions() {
        return options;
    }
    public Vector<String> getCommandOrder() {
        return commandOrder;
    }
    public void readInputFile(String fileName) throws Exception {

        Scanner sc = new Scanner(new File(fileName));
        isCsedInFile = false;

        String currentString = sc.nextLine();
        if (!currentString.equals("desc")) {
            throw new Exception("desc is not found. Add it in begin of input to continue.");
        }

        while (sc.hasNextLine()) {
            currentString = sc.nextLine();
            if (currentString.equals("csed")) {
                isCsedInFile = true;
                break;
            }

            if (currentString.equals("")) {
                continue;
            }

            String[] wordsInCurrentString = currentString.split(" ");
            String operationID = wordsInCurrentString[0];

            if (!wordsInCurrentString[1].equals("=")) {
                throw new Exception("'=' expected before operationID");
            }

            String[] wordsToAdd = new String[3];
            System.arraycopy(wordsInCurrentString, 2, wordsToAdd, 0, wordsInCurrentString.length - 2);
            options.put(operationID, wordsToAdd);
        }


        if (!isCsedInFile) {
            throw new Exception("csed is not found. Add it before all operations ID to continue");
        }

        currentString = sc.nextLine();
        if (currentString.equals("")) {
            throw new Exception("Operation queue not found. Add it usign '->' ");
        }

        String[] wordsInCurrentString = currentString.split(" ");

        for (int i = 0; i < wordsInCurrentString.length; i++) {

            if ((i % 2 == 0) && (wordsInCurrentString[i].equals("->"))) {
                throw new Exception("Expected operationID between '->'");
            }

            if ((i % 2 != 0) && !(wordsInCurrentString[i].equals("->"))) {
                throw new Exception("Expected '->' between operationID");
            }

            if (i % 2 == 0 && !wordsInCurrentString[i].equals("->")) {
                commandOrder.add(wordsInCurrentString[i]);
            }

        }
    }
}
