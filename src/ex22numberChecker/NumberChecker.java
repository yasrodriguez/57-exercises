package ex22numberChecker;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Ask for 3 numbers. Check that they're all different and display the largest number.
 * If they're not different, exit the program.
 * Constraint: Don't use a built-in function to get the largest number.
 * Created by Yasmin on 7/26/17.
 */

public class NumberChecker
{
    private ArrayList <Integer> numbers;

    public NumberChecker (int number1, int number2, int number3)
    {
        numbers = new ArrayList<>();
        numbers.add(number1);
        numbers.add(number2);
        numbers.add(number3);
    }

    public void hasUniqueNumbers()
    {
        boolean unique = true;
        Collections.sort(numbers);

        for (int i = 0; i < numbers.size(); i++)
        {

        }
    }


}
