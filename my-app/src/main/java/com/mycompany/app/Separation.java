/**
 * com.mycompany.app is the main package of this project.
 */

package com.mycompany.app;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

/**
* This is the class where we keep the input given from the user.
*/

public class Separation {
    /**
     * This is a field of the class.
     */
    private String inputText;
    /**
     * This ArrayList keeps all words with one letter that are in the input.
     */
    private ArrayList<String> oneLetter;
    /**
     * This ArrayList keeps all words with two letters that are in the input.
     */
    private ArrayList<String> twoLetters;
    /**
     * This ArrayList keeps all words with three letters that are in the input.
     */
    private ArrayList<String> threeLetters;
    /**
     * This ArrayList keeps all words with four letters that are in the input.
     */
    private ArrayList<String> fourLetters;
    /**
     * This ArrayList keeps all words with five letters that are in the input.
     */
    private ArrayList<String> fiveLetters;
    /**
     * This ArrayList keeps all words with six letters that are in the input.
     */
    private ArrayList<String> sixLetters;
    /**
     * This ArrayList keeps all words with seven letters that are in the input.
     */
    private ArrayList<String> sevenLetters;
    /**
     * This ArrayList keeps all words with more than seven letters that are in the input.
     */
    private ArrayList<String> moreLetters;

    /**
     * This is the constructor of the class.
     */
    public Separation() {
        this.inputText = "";
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
     *@param myInputText This is a setter.
     * This method is used count letters.
     */
    public final void setInputText(final String myInputText) {
       this.inputText = myInputText;
    }

    /**
     * This method is used to seperate the text and create the lists.
     *@param path This is the location of the input file if given
     *@return totalTime This is the time elapsed for separation.
     */
    public final long separateText(final String path) {
        //Text input and split
        final int oneL = 1;
        final int twoL = 2;
        final int threeL = 3;
        final int fourL = 4;
        final int fiveL = 5;
        final int sixL = 6;
        final int sevenL = 7;

        String inputFromUser = "";

        if (path == null) {
            Scanner input = new Scanner(System.in);
            inputFromUser = input.nextLine();
            setInputText(inputFromUser);
        } else {
            File inputFile = new File(path);
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(inputFile));
                byte[] fileInfo = Files.readAllBytes(Paths.get(path));
                inputFromUser = new String(fileInfo, StandardCharsets.UTF_8);
                setInputText(inputFromUser);
            }  catch (FileNotFoundException e) {
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

        long startTime = System.currentTimeMillis();

        String splitOne = "(,)|(\\.)|(\\!)|(\\ )|(\\?)|(\\:)|(\\<\\<)|(\\))";
        String splitTwo = "|(\\>\\>)|(\\;)|(\\')|(\\\")|(\\*)|(\\-)|(\\()";
        String splitThree = "|(\\^)|(\\&)|(\\`)|(\\~)|(\\#)|(\\/)|(\\_)";
        String finalSplit = splitOne + splitTwo + splitThree;
        String[] words = this.inputText.split(finalSplit);
        for (String word : words) {
            if (!word.equals("") && !word.equals("\n")) {
                if (word.length() == oneL) {
                    oneLetter.add(word.toLowerCase().toLowerCase());
                } else if (word.length() == twoL) {
                    twoLetters.add(word.toLowerCase());
                } else if (word.length() == threeL) {
                    threeLetters.add(word.toLowerCase());
                } else if (word.length() == fourL) {
                    fourLetters.add(word.toLowerCase());
                } else if (word.length() == fiveL) {
                    fiveLetters.add(word.toLowerCase());
                } else if (word.length() == sixL) {
                    sixLetters.add(word.toLowerCase());
                } else if (word.length() == sevenL) {
                    sevenLetters.add(word.toLowerCase());
                } else {
                    moreLetters.add(word.toLowerCase());
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        return totalTime;
    }
}
