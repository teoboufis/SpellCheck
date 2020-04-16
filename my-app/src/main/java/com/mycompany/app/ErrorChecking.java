/**
 * com.mycompany.app is the main package of this project.
 */

package com.mycompany.app;

import java.util.ArrayList;

/**
* This is the class that implemets the checks.
*/

public class ErrorChecking {
    /**
     * This ArrayList keeps all the errors found.
     */
    private ArrayList<String> errors;
    /**
     * This counter keeps the number of the errors found.
     */
    private int errorCount;

    /**
     * This is the constructor of the class.
     */
    public ErrorChecking() {
        this.errors = new ArrayList<String>();
        this.errorCount = 0;
    }

    /**
     * This is a getter function.
     * @return this.errors is the arrayList of the errors.
     */
    public final ArrayList<String> getErrors() {
        return this.errors;
    }


    /**
    * This method is used in order to check if a word exists in the dictionary.
    * We check all the lists (one-one, two-two).
    * @param dict This is the dictionary of the spellchecker.
    * @param separ This is the seperation text for the spellchecker.
    */
    public final void checking(final Dictionary dict, final Separation separ) {
        ArrayList<String> checkerDict = new ArrayList<String>();
        ArrayList<String> checkerText = new ArrayList<String>();

        checkerDict = dict.getOne();
        checkerText = separ.getOne();
        crossChecking(checkerDict, checkerText);
        checkerDict = dict.getTwo();
        checkerText = separ.getTwo();
        crossChecking(checkerDict, checkerText);
        checkerDict = dict.getThree();
        checkerText = separ.getThree();
        crossChecking(checkerDict, checkerText);
        checkerDict = dict.getFour();
        checkerText = separ.getFour();
        crossChecking(checkerDict, checkerText);
        checkerDict = dict.getFive();
        checkerText = separ.getFive();
        crossChecking(checkerDict, checkerText);
        checkerDict = dict.getSix();
        checkerText = separ.getSix();
        crossChecking(checkerDict, checkerText);
        checkerDict = dict.getSeven();
        checkerText = separ.getSeven();
        crossChecking(checkerDict, checkerText);
        checkerDict = dict.getMore();
        checkerText = separ.getMore();
        crossChecking(checkerDict, checkerText);
    }

    /**
    * This method is used to check every word of the dictionary for example
    * having two letters with all the words of the text that have 2 letters.
    * @param checkerDict This is the dictionary of the spellchecker.
    * @param checkerText This is the seperated text for the spellchecker.
    */
    //Checks if the two words are the same
    public final void crossChecking(final ArrayList<String> checkerDict,
    final ArrayList<String> checkerText) {
        for (String word : checkerText) {
            if (!checkerDict.contains(word)) {
                errors.add(word);
                errorCount++;
            }
        }
    }

    /**
    * This method is used to print the errors.
    */
    public final void printResults() {
        if (errorCount > 0) {
            System.out.println("Printing errors:");
            for (String word : errors) {
                System.out.println(word);
            }
        } else if (errorCount == 0) {
            System.out.println("No errors found.");
        }
    }

    /**
    * This method is used to find suggestions.
    * @param dict This is the dictionary of the spellchecker.
    */
    public final void getSuggestions(final Dictionary dict) {
        final int twoL = 2;
        final int threeL = 3;
        final int fourL = 4;
        final int fiveL = 5;
        final int sixL = 6;
        final int sevenL = 7;
        for (String word : errors) {
            if (word.length() == twoL) {
                ArrayList<String> twoLetters = dict.getTwo();
                compareWords(twoLetters, word);
            } else if (word.length() == threeL) {
                ArrayList<String> threeLetters = dict.getThree();
                compareWords(threeLetters, word);
            } else if (word.length() == fourL) {
                ArrayList<String> fourLetters = dict.getFour();
                compareWords(fourLetters, word);
            } else if (word.length() == fiveL) {
                ArrayList<String> fiveLetters = dict.getFive();
                compareWords(fiveLetters, word);
            } else if (word.length() == sixL) {
                ArrayList<String> sixLetters = dict.getSix();
                compareWords(sixLetters, word);
            } else if (word.length() == sevenL) {
                ArrayList<String> sevenLetters = dict.getSeven();
                compareWords(sevenLetters, word);
            } else if (word.length() > sevenL) {
                ArrayList<String> moreLetters = dict.getMore();
                compareWords(moreLetters, word);
            }
        }
        return;
    }

    /**
    * This method is used to check if there is a word with only one different
    * letter from the original word given. If they have only one difference,
    * the word is considered a suggestion.
    * @param wordsList This is the list of the words with a certain size.
    * @param word This is the word checked for suggestions.
    * @return suggestions This is the list with the suggestions.
    */
    public final ArrayList<String> compareWords(final ArrayList<String> wordsList,
    final String word) {
        int errorCounter = 0;
        char[] wordArray = word.toCharArray();
        ArrayList<String> suggestions = new ArrayList<String>();
        for (String dictWord : wordsList) {
            char[] dictWordArray = dictWord.toCharArray();
            if (word.length() == dictWord.length()) {
                for (int i = 0; i < word.length(); ++i) {
                    if (wordArray[i] != dictWordArray[i]) {
                        errorCounter++;
                    }
                }
                if (errorCounter == 1) {
                    suggestions.add(dictWord);
                }
            }
            errorCounter = 0;
        }
        if (suggestions.size() > 0) {
            System.out.println("Printing suggestions for " + word);
            for (String tempWord : suggestions) {
                System.out.println(tempWord);
            }
        } else {
            System.out.println("No suggestions for " + word + " found.");
        }
        return suggestions;
    }
}
