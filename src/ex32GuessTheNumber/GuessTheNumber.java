package ex32GuessTheNumber;

import java.util.Random;
/**
 * Guess the Number is a game with 3 levels of difficulty.
 * Level 1 - Guess a number between 1 and 10
 * Level 2 - Guess a number between 1 and 100
 * Level 3 - Guess a number between 1 and 1000
 * The program picks a random number in the range and prompts the player to guess, giving hints as to whether the
 * number is too low or too high. Once the player guesses correctly, the program presents the number of guesses
 * and asks the player if they want to play again.
 * Created by Yasmin on 8/7/2017
 */

public class GuessTheNumber {

    private Random random;
    private Level selectedLevel;
    private int randomNumber;
    private int numberOfGuesses;

    enum Level{
        L1,L2,L3
    }

    public GuessTheNumber(int level){
        random = new Random();
        selectedLevel = Level.valueOf("L"+level);
        randomNumber = generateRandomNumber();
        numberOfGuesses = 0;
    }

     GuessTheNumber(int level, long seed) {
        random = new Random(seed);
         selectedLevel = Level.valueOf("L"+level);
        randomNumber = generateRandomNumber();
        numberOfGuesses = 0;
    }

    private int generateRandomNumber(){
        if(selectedLevel == Level.L1)
            return random.nextInt(10) + 1;
        else if(selectedLevel == Level.L2)
            return random.nextInt(100) + 1;
        else
            return random.nextInt(1000) + 1;
        }

    public String play(int guess) {

            numberOfGuesses++;

            if (guess < randomNumber)
                return "Too Low";
            else if (guess > randomNumber)
                return "Too High";
            else
                return "Equal";
    }

    public int getNumberOfGuesses(){
        return numberOfGuesses;
    }

    public int getRandomNumber(){
        return randomNumber;
    }
}
