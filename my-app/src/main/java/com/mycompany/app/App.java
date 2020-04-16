/**
 * com.mycompany.app is the main package of this project.
 */

package com.mycompany.app;

import java.util.Scanner;

/**
* The Spellchecker application is a simple implementation
* of a spellchecking program.
*
* @author  WeAreJava
* @version 1.0
* @since   2018-01-03
*/

public final class App {

/**
* This method is a default constructor.
*/

    private App() {
        //not called
    }

/**
* This method is used to begin the spellchecker.
* @param args is the arguments provided by the user.
*/

    public static void main(final String[] args) {
        System.out.println("Beggining of SpellCheck");
        System.out.println("Creating dictionary...");

        long startTime = System.currentTimeMillis();
        Dictionary dictionary = new Dictionary();
        long userStartTime1 = System.currentTimeMillis();
        Scanner keyboard;

        System.out.println("Choose the language of the dictionary.");
        System.out.print("Write 1 for greek dictionary ");
        System.out.println(" or 2 for english dictionary.");
        keyboard = new Scanner(System.in);
        Integer language = keyboard.nextInt();

        long userEndTime1 = System.currentTimeMillis();

        if (language.equals(1)) {
            String path = "/Users/Mac/Documents/GitHub/SpellCheck/my-app/greek.wl";
            dictionary.createDictionary(path);
            System.out.println("The greek dictionary is ready!");
        } else if (language.equals(2)) {
            String path = "/Users/Mac/Documents/GitHub/SpellCheck/my-app/en-US.dic";
            dictionary.createDictionary(path);
            System.out.println("The english dictionary is ready!");
        }

        long userStartTime2 = System.currentTimeMillis();

        System.out.println("Choose input method:");
        System.out.print("Write 1 for keyboard input ");
        System.out.println("or 2 for text input and press enter.");
        keyboard = new Scanner(System.in);
        Integer option = keyboard.nextInt();

        Separation separation = new Separation();
        long separationTime = 0;

        if (option.equals(1)) {
            System.out.println("You chose input from keyboard.");
            System.out.println("Please give the input you want to check...");
            separationTime = separation.separateText(null);
        } else if (option.equals(2)) {
            System.out.println("You chose input from text file.");
            System.out.println("Please give the name of the file.");
            keyboard = new Scanner(System.in);
            String inputPath = keyboard.nextLine();
            separationTime = separation.separateText(inputPath);
        }

        long userEndTime2 = System.currentTimeMillis();
        long userTotalTime = (userEndTime1 - userStartTime1) + (userEndTime2 - userStartTime2);

        System.out.println("Checking the given text...");
        ErrorChecking checker = new ErrorChecking();
        System.out.println("Checking for errors...");
        checker.checking(dictionary, separation);
        checker.printResults();
        System.out.println("Done checking for errors");
        System.out.println("Checking for suggestions");
        checker.getSuggestions(dictionary);
        System.out.println("End of program");

        long stopTime = System.currentTimeMillis();
        final long timeConverter = 1000.0;
        long elapsedTime = stopTime - startTime - userTotalTime + separationTime;
        System.out.println("The time elapsed is " + ((float) elapsedTime / timeConverter) + " seconds.");

        Runtime runtime = Runtime.getRuntime();
        //Run the garbage collector
        runtime.gc();
        //Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
    }
}
