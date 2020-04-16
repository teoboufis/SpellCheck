package com.mycompany.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;

/**
 * Unit test for simple App.
 */

public class AppTest {

    Dictionary dictionary;
    Separation separation;
    ErrorChecking checker;
    
    @Before
    public void init() throws Exception {
        dictionary = new Dictionary();
        separation = new Separation();
        checker = new ErrorChecking();
    }
    
    @Test
    public void shouldDictionaryBeCreatedCorrectly() {
        String dictionaryPath = "/Users/Mac/Documents/GitHub/SpellCheck/my-app/greekTest.wl";
        dictionary.createDictionary(dictionaryPath);
        assertEquals(3, dictionary.getOne().size());
        assertEquals(3, dictionary.getTwo().size());
        assertEquals(8, dictionary.getThree().size());
        assertEquals(6, dictionary.getFour().size());
        assertEquals(7, dictionary.getFive().size());
        assertEquals(4, dictionary.getSix().size());
        assertEquals(2, dictionary.getSeven().size());
        assertEquals(8, dictionary.getMore().size());
        System.out.println("Dictionary test passed!");
    }

    @Test
    public void shouldSeparationBeCorrect() {
        String separationPath = "/Users/Mac/Documents/GitHub/SpellCheck/my-app/testInput.txt";
        separation.separateText(separationPath);
        assertEquals(1, separation.getOne().size());
        assertEquals(1, separation.getThree().size());
        assertEquals(2, separation.getFour().size());
        assertEquals(2, separation.getFive().size());
        assertEquals(1, separation.getSix().size());
        assertEquals(1, separation.getSeven().size());
        assertEquals(1, separation.getMore().size());
        System.out.println("User's input test passed!");
    }

    @Test
    public void shouldFindErrors() {
        String dictionaryPath = "/Users/Mac/Documents/GitHub/SpellCheck/my-app/greekTest.wl";
        dictionary.createDictionary(dictionaryPath);
        String separationPath = "/Users/Mac/Documents/GitHub/SpellCheck/my-app/testInput.txt";
        separation.separateText(separationPath);
        checker.checking(dictionary, separation);
        assertEquals(3, checker.getErrors().size());
        System.out.println("Error checking test passed!");
    }

    @Test
    public void shouldFindSuggestions() {
        String dictionaryPath = "/Users/Mac/Documents/GitHub/SpellCheck/my-app/greekTest.wl";
        dictionary.createDictionary(dictionaryPath);
        String separationPath = "/Users/Mac/Documents/GitHub/SpellCheck/my-app/testInput.txt";
        separation.separateText(separationPath);
        checker.checking(dictionary, separation);
        ArrayList<String> suggestions = checker.compareWords(dictionary.getFive(), "είναι");
        assertEquals(suggestions.get(0), "είμαι");
        System.out.println("Suggestions test passed!");
    }
}
