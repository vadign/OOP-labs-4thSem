import java.io.*;
import java.lang.StringBuilder;
import java.util.Map;

public class Counter {

    private Map <String, Integer> counterMap; // <key, value>
    private int totalCounter;

    private void addWordInMap (StringBuilder myString){
        String currentWord;
        currentWord = myString.toString();

        int currentCountInMap;

        if (counterMap.containsKey(currentWord)) { // checks if we already have this word (key)
            currentCountInMap = counterMap.get(currentWord) + 1; // get() returns count of word (have key want value)
            counterMap.put(currentWord, currentCountInMap);
        }
        else
            counterMap.put(currentWord, 1);

        totalCounter++;
    }

    public void ReadInput() throws IOException {

        Reader reader = null;

            reader = new InputStreamReader(new FileInputStream("input.txt"));

            int currentSymbol = 0;
            StringBuilder myString = null;

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
    }

    public void sortMap(){



    }
}