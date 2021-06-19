package com.nsu.ccfit.tester;

import com.nsu.ccfit.options.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import junit.framework.TestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class myTester extends TestSuite {

    @Test
    public void dump() throws Exception {
        Dump dumpTester = new Dump();
        ArrayList<String> text = new ArrayList<>();
        Vector<String> args = new Vector<>();

        text.add("Vad");
        text.add("Vad1");
        text.add("VADIMMM");
        args.add("dumpTest.txt");

        dumpTester.execute(text, args);
        File inputFile = new File("outForTest.txt");
        Scanner input = new Scanner(inputFile);
        ArrayList<String> testedOutput = new ArrayList<>();

        String inputLine;
        while (input.hasNextLine()) {
            inputLine = input.nextLine();
            testedOutput.add(inputLine);
        }

        input.close();
        assertEquals(text, testedOutput);
    }

    @Test
    public void grep()throws Exception{
            Grep grepTest = new Grep();
            ArrayList<String> text = new ArrayList<>();
            ArrayList<String> testedOutput = new ArrayList<>();
            Vector<String> args = new Vector<>();

            text.add("Vadim");
            text.add("VadimDDDim1");
            text.add("VaaaaAAa");
            args.add("dim");

            testedOutput.addAll(text);
            grepTest.execute(testedOutput, args);
            text.remove(2);
            assertEquals(text, testedOutput);
        }

    @Test
    public void replace() throws Exception {
        Replace replaceTester = new Replace();
        ArrayList<String> text = new ArrayList<>();
        Vector<String> args = new Vector<>();

        text.add("Vadim");
        text.add("VadimIgn");
        text.add("vadign");

        ArrayList<String> testedOutput = new ArrayList<>(text);
        args.add("adim");
        args.add("ad");

        replaceTester.execute(testedOutput, args);
        text.clear();

        text.add("Vad");
        text.add("VadIgn");
        text.add("vadign");

        assertEquals(text, testedOutput);
    }

    @Test
    public void sort() throws Exception {
        Sort sortTest = new Sort();
        ArrayList<String> text = new ArrayList<>();
        Vector<String> args = new Vector<>();

        text.add("Vadim");
        text.add("Ignatenko");
        text.add("vadignat");

        ArrayList<String> testedOutput = new ArrayList<>(text);
        sortTest.execute(testedOutput, args);
        text.clear();
        text.add("Ignatenko");
        text.add("vadignat");
        text.add("Vadim");
        assertEquals(text, testedOutput);
    }


}
