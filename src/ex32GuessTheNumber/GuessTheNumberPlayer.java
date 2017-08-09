package ex32GuessTheNumber;

/**
 * Challenge: Write an AI player that is guaranteed to take <= log(n) guesses:
 * Level 1 - 4 or less guesses
 * Level 2 - 7 or less guesses
 * Level 3 - 10 or less guesses *
 * Created by Yasmin on 8/9/2017
 */

public class GuessTheNumberPlayer {
    private GuessTheNumber gtn;
    private int lowerBoundary;
    private int upperBoundary;

    public GuessTheNumberPlayer(int level){

        gtn = new GuessTheNumber(level);
        lowerBoundary = 1;

        if(level == 1){
            upperBoundary = 10;
        }
        else if (level == 2){
            upperBoundary = 100;
        }
        else{
            upperBoundary = 1000;
        }
    }

    private int determineBestGuess(){
        int bestGuess = (upperBoundary - lowerBoundary) / 2 + lowerBoundary;
        System.out.println(bestGuess);
        return bestGuess;
    }

    public void playTheBestGuess(){

        boolean found = false;
        int guess = 0;

        while(! found){

            guess = determineBestGuess();
            String result = gtn.play(guess);

            if (result.equals("Too Low")) {
                lowerBoundary = guess + 1;
            } else if (result.equals("Too High")) {
                upperBoundary = guess - 1;
            } else {
                found = true;
            }
        }
        System.out.println("Good job guessing the number " + guess + " in " + gtn.getNumberOfGuesses()
                + " attempts. \n");
    }

    public static void main(String[] args){
        System.out.println("Playing level 1:");
        GuessTheNumberPlayer gtnp1 = new GuessTheNumberPlayer(1);
        gtnp1.playTheBestGuess();

        System.out.println("Playing level 2:");
        GuessTheNumberPlayer gtnp2 = new GuessTheNumberPlayer(2);
        gtnp2.playTheBestGuess();

        System.out.println("Playing level 3:");
        GuessTheNumberPlayer gtnp3 = new GuessTheNumberPlayer(3);
        gtnp3.playTheBestGuess();
    }
}
