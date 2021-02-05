package com.company;

import java.io.*;
import java.lang.StringBuilder;
import java.util.*;

public class Counter {

    private Map<String, Integer> counterMap; // <key, value>
    private List<Map.Entry<String, Integer>> listToSort;
    private int totalOfWords;

    private void addWordInMap(StringBuilder myString) {
        String currentWord;
        currentWord = myString.toString();

        int currentCountInMap;

        if (counterMap.containsKey(currentWord)) { // checks if we already have this word (key)
            currentCountInMap = counterMap.get(currentWord) + 1; // get() returns count of word (have key want value)
            counterMap.put(currentWord, currentCountInMap);
        } else
            counterMap.put(currentWord, 1);

        totalOfWords++;
    }

    public void ReadInput() throws IOException {

        Reader reader = null;

        reader = new InputStreamReader(new FileInputStream("input.txt"));

        int currentSymbol = 0;
        StringBuilder myString = new StringBuilder();

        while (true) {
            currentSymbol = reader.read();

            if (currentSymbol == -1) { // reader.read() = -1, if input was ended
                addWordInMap(myString);
                break;
            }

            if (Character.isLetterOrDigit(currentSymbol))
                myString.append(currentSymbol);
            else
                addWordInMap(myString);
        }
        reader.close();
    }

    public void writeOutput() throws IOException {

        Writer writer = new OutputStreamWriter(new FileOutputStream("output.csv"));

        listToSort.addAll(counterMap.entrySet());
        listToSort.sort((first, second) -> -(first.getValue().compareTo(second.getValue())));

        for (Map.Entry<String, Integer> currentWord
                : listToSort) {

            double currentWordFrequency = (double) currentWord.getValue() / totalOfWords;
            writer.write(currentWord.getKey() + '\t' + currentWord.getValue() + '\t' + currentWordFrequency + '\n');
        }

        writer.close();
    }
}