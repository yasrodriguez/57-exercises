package ex33magic8Ball;

import java.util.Random;

/**
 * Display a random response. The possible responses should be stored in a list.
 * Created by Yasmin on 8/9/2017
 */

public class Magic8Ball {
    private final static String[] responses = { "Yes", "No", "Maybe", "Ask again later"};

    public static String turnTheBall(){
        Random random = new Random();
        int indexSelected = random.nextInt(4); //should return a number from 0 to 3
        return responses[indexSelected];
    }
}
