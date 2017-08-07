package ex32GuessTheNumber;

import java.util.Scanner;

/**
 * This program implements Guess The Number.
 * Created by Yasmin on 8/7/2017
 */

public class GuessTheNumberDemo {

    private Scanner s;
    private String result;
    private int level;
    private GuessTheNumber gtn;

    public GuessTheNumberDemo(){
        s = new Scanner(System.in);
        result = "";
        createNewGame();
    }

    private void createNewGame(){
        System.out.print("Enter a level from 1 to 3: ");
        level = s.nextInt();
        gtn =  new GuessTheNumber(level);
    }

    private void askForGuess() {

        while (!result.equals("Equal")) {
            if (level == 1)
                System.out.print("You must enter a number from 1 to 10: ");
            else if (level == 2)
                System.out.print("You must enter a number from 1 to 100: ");
            else
                System.out.print("You must enter a number from 1 to 1000: ");

            result = gtn.play(s.nextInt());

            if(result.equals("Equal"))
                printResultAndAskToPlayAgain();
            else
                System.out.println(result);
        }
    }

    private void printResultAndAskToPlayAgain(){

            System.out.println("You guessed the number in " + gtn.getNumberOfGuesses() + " attempts!");

            System.out.println("Would you like to play again? Enter Y or N.");
            if(s.next().equalsIgnoreCase("Y")) {
                GuessTheNumberDemo gtnd = new GuessTheNumberDemo();
                gtnd.askForGuess();
            }
    }

    public static void main(String[]args) {
        GuessTheNumberDemo gtnd = new GuessTheNumberDemo();
        gtnd.askForGuess();
    }
}





