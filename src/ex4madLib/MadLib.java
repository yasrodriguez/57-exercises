package ex4madLib;
import java.util.Scanner;

/**
 * Prompt the user for a noun, verb, adverb, and adjective
 * and use the values provided to fill the blanks in a made up story using string interpolation
 * (or String templating in Java).
 * Created by Yasmin on 6/11/2017.
 */
public class MadLib {

    private void writeMadLib(){
        Scanner s = new Scanner (System.in);
        System.out.print("Enter a noun: ");
        String noun = s.next();
        System.out.print("Enter a verb: ");
        String verb = s.next();
        System.out.print("Enter an adjective: ");
        String adjective = s.next();
        System.out.print("Enter an adverb: ");
        String adverb = s.next();
        String storyTemplate = "The %s %s %s %s. That's hilarious!";
        System.out.print(String.format(storyTemplate, adjective, noun, verb, adverb));
    }

    public static void execute(){
        MadLib ml = new MadLib();
        ml.writeMadLib();
    }
}
