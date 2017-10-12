package ex28addingNumbers;


/**
 * Accept an array of numbers and compute the total.
 * Created by Yasmin on 8/6/2017
 */

public class AddingNumbers {

    public static double sum(double[] numbers){
        double sum = 0;

        for( double number : numbers){
            sum += number;
        }
        return sum;
    }
}
