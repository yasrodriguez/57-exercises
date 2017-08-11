package ex32GuessTheNumber;

import java.util.Scanner;


/**
 * This program implements Guess The Number.
 * Created by Yasmin on 8/7/2017
 */

public class GuessTheNumberDemo {

    private Scanner s;
    private String result;
    private GuessTheNumber.Level level;
    private GuessTheNumber gtn;

    public GuessTheNumberDemo(){
        s = new Scanner(System.in);
        result = "";
        createNewGame();
    }

    private void createNewGame(){
        System.out.print("Enter your level: 1 for Beginner, 2 for Intermediate, or  3 Advanced ");
        int number = s.nextInt();
        switch(number){
            case 1:
                level = GuessTheNumber.Level.Beginner;
                break;
            case 2:
                level = GuessTheNumber.Level.Intermediate;
                break;
            case 3:
                level = GuessTheNumber.Level.Advanced;
                break;
        }
        gtn =  new GuessTheNumber(level);
    }

    private void askForGuess() {

        while (!result.equals("Equal")) {
            if (level == GuessTheNumber.Level.Beginner)
                System.out.print("You must enter a number from 1 to 10: ");
            else if (level == GuessTheNumber.Level.Intermediate)
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





