/**
 * com.mycompany.app is the main package of this project.
 */

package com.mycompany.app;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;

/**
* This class creates a dictionary.
*/

public class Dictionary {
    /**
     * This is a field of the class.
     */
    private String dictionary;
    /**
     * This ArrayList keeps all words with one letter that are in the dictionary.
     */
    private ArrayList<String> oneLetter;
    /**
     * This ArrayList keeps all words with two letters that are in the dictionary.
     */
    private ArrayList<String> twoLetters;
    /**
     * This ArrayList keeps all words with three letters that are in the dictionary.
     */
    private ArrayList<String> threeLetters;
    /**
     * This ArrayList keeps all words with four letters that are in the dictionary.
     */
    private ArrayList<String> fourLetters;
    /**
     * This ArrayList keeps all words with five letters that are in the dictionary.
     */
    private ArrayList<String> fiveLetters;
    /**
     * This ArrayList keeps all words with six letters that are in the dictionary.
     */
    private ArrayList<String> sixLetters;
    /**
     * This ArrayList keeps all words with seven letters that are in the dictionary.
     */
    private ArrayList<String> sevenLetters;
    /**
     * This ArrayList keeps all words with more than seven letters that are in the dictionary.
     */
    private ArrayList<String> moreLetters;

    /**
     * This is the constructor of the class.
     * It creates all the ArrayLists.
     */
    public Dictionary() {
        this.oneLetter = new ArrayList<String>();
        this.twoLetters = new ArrayList<String>();
        this.threeLetters = new ArrayList<String>();
        this.fourLetters = new ArrayList<String>();
        this.fiveLetters = new ArrayList<String>();
        this.sixLetters = new ArrayList<String>();
        this.sevenLetters = new ArrayList<String>();
        this.moreLetters = new ArrayList<String>();
    }

/**
* This method is used to return the ArrayLists.
* We need them because these fields are private.
* @return this.oneLetter is an ArrayList.
*/

    public final ArrayList<String> getOne() {
        return this.oneLetter;
    }

/**
* This method is used to return the ArrayLists.
* We need them because these fields are private.
* @return this.twoLetters is an ArrayList.
*/

    public final ArrayList<String> getTwo() {
        return this.twoLetters;
    }

/**
* This method is used to return the ArrayLists.
* We need them because these fields are private.
* @return this.threeLetters is an ArrayList.
*/

    public final ArrayList<String> getThree() {
        return this.threeLetters;
    }

/**
* This method is used to return the ArrayLists.
* We need them because these fields are private.
* @return this.fourLetters is an ArrayList.
*/

    public final ArrayList<String> getFour() {
        return this.fourLetters;
    }
/**
* This method is used to return the ArrayLists.
* We need them because these fields are private.
* @return this.fiveLetters is an ArrayList.
*/

    public final ArrayList<String> getFive() {
        return this.fiveLetters;
    }
/**
* This method is used to return the ArrayLists.
* We need them because these fields are private.
* @return this.sixLetters is an ArrayList.
*/

    public final ArrayList<String> getSix() {
        return this.sixLetters;
    }
/**
* This method is used to return the ArrayLists.
* We need them because these fields are private.
* @return this.sevenLetters is an ArrayList.
*/

    public final ArrayList<String> getSeven() {
        return this.sevenLetters;
    }
/**
* This method is used to return the ArrayLists.
* We need them because these fields are private.
* @return this.moreLetters is an ArrayList.
*/

    public final ArrayList<String> getMore() {
        return this.moreLetters;
    }


/**
* This method is used to create the dictionary.
* We open the file, we read it line by line and given the fact that
* each line contains only one word, we split the words and we put every
* word in the ArrayList that has the number of letters.
* All the possible exceptions are caught.
* @param dictionaryPath This is the path where the dictionary is saved.
*/
    public final void createDictionary(final String dictionaryPath) {
        final int oneL = 1;
        final int twoL = 2;
        final int threeL = 3;
        final int fourL = 4;
        final int fiveL = 5;
        final int sixL = 6;
        final int sevenL = 7;
        File dictionaryFile = new File(dictionaryPath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(dictionaryFile));
            String text = null;
            while ((text = reader.readLine()) != null) {
                if (text.length() == oneL) {
                    oneLetter.add(text);
                } else if (text.length() == twoL) {
                    twoLetters.add(text);
                } else if (text.length() == threeL) {
                    threeLetters.add(text);
                } else if (text.length() == fourL) {
                    fourLetters.add(text);
                } else if (text.length() == fiveL) {
                    fiveLetters.add(text);
                } else if (text.length() == sixL) {
                    sixLetters.add(text);
                } else if (text.length() == sevenL) {
                    sevenLetters.add(text);
                } else {
                    moreLetters.add(text);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
