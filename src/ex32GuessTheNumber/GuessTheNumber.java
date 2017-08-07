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
    private int level;
    private int randomNumber;
    private int numberOfGuesses;

    public GuessTheNumber(int level){
        random = new Random();
        setLevel(level);
        randomNumber = generateRandomNumber();
        numberOfGuesses = 0;
    }

    public GuessTheNumber(int level, long seed) {
        random = new Random(seed);
        setLevel(level);
        randomNumber = generateRandomNumber();
        numberOfGuesses = 0;
    }

    private void setLevel(int level){
        if(level < 1 || level > 3)
            throw new IllegalArgumentException("Level must be a number from 1 to 3.");
        this.level = level;
    }

    private int generateRandomNumber(){
        if(level == 1)
            return random.nextInt(10) + 1;
        else if(level == 2)
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
