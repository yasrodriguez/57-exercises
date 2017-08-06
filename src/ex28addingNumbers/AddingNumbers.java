package ex28addingNumbers;

import java.util.Scanner;

/**
 * Prompt the user for five numbers and compute the total.
 * Created by Yasmin on 8/6/2017
 */

public class AddingNumbers {

    public static void main(String[] args){

        double sum = 0;
        Scanner s = new Scanner(System.in);

        for(int i = 1; i <= 5; i++) {
            System.out.print("Enter a number: ");
            sum += s.nextDouble();
        }

        System.out.println("The total is " + sum);
    }
}
