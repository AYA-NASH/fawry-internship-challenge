package org.example;

import org.example.tests.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<TestCase> testCases = List.of(
                new TestCase1(),
                new TestCase2(),
                new TestCase3(),
                new TestCase4(),
                new TestCase5(),
                new TestCase6(),
                new TestCase7()
        );

        for (TestCase test : testCases){
            test.run();
        }
    }

}