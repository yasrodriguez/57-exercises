package ex38numberFilter;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Accept a list of numbers separated by spaces. Print out a list containing only the even numbers.
 * Constraints:
 * Convert the input to an array.
 * Write your own algorithm, don't use the language built-in filter or enumeration feature.
 * Use a function filterEvenNumbers that takes in the original array and returns the new array.
 * Created by Yasmin on 8/15/2017
 */

public class NumberFilter {

    public static ArrayList<Integer> filterEvenNumbers(int[] numberList){
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        for(int number: numberList){
            if (number % 2 == 0){
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }

    public static int[] convertToArray(String numbers){
        String[] strNumberList = numbers.split(" ");

        int[] numberList = new int[strNumberList.length];
        for (int i = 0; i < numberList.length; i++){
            if (isNumeric(strNumberList[i])) {
                numberList[i] = Integer.parseInt(strNumberList[i]);
            }
            else{
                throw new NumberFormatException("Your list contains non-numeric characters.");
            }
        }
        return numberList;
    }

    private static boolean isNumeric(String strNumber){
        return  Pattern.matches("^[0-9]+$", strNumber );
    }
}
