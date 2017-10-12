package ex2characterCounter;

import java.util.Scanner;

/**
 * Prompt for a string and display the number of characters it contains.
 */
public class CharacterCounter {

    private void countCharacters(){
        Scanner s = new Scanner (System.in);
        System.out.print ("Enter a string: ");
        String word =  s.next();
        int length = word.length();
        System.out.println(word + " has " + length + " characters.");
    }

    public static void execute(){
        CharacterCounter counter = new CharacterCounter();
        counter.countCharacters();
    }
}
