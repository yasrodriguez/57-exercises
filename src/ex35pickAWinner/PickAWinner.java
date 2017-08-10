package ex35pickAWinner;

import java.util.ArrayList;
import java.util.Random;

/**
 * Prompt for name of contestants until the user enters a blank entry, then randomly select a winner.
 * Created by Yasmin on 8/10/2017
 */

public class PickAWinner {
    private ArrayList<String> contestants;

    public PickAWinner(){
        contestants = new ArrayList<>(10);
    }

    public void addContestant(String name){
       if(! name.equals("")){
            contestants.add(name);
       }
    }

    public String selectWinner(){
        if(contestants.isEmpty()) {
            return "Sorry you haven\'t entered any contestants";
        }
        else if(contestants.size()== 1) {
            return "Of course you know the winner can only be " + contestants.get(0);
        }
        else{
            Random random = new Random();
            int randomNumber = random.nextInt(contestants.size());
            return contestants.get(randomNumber);
        }
    }
}
