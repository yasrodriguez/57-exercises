package ex38numberFilter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Unit tests for Number Filter.
 * Created by Yasmin on 8/15/17
 */
public class NumberFilterTest {

    @Test
    public void a_list_of_even_and_odd_numbers_returns_only_even_numbers(){
        //arrange
        int[] numbers = NumberFilter.convertToArray("123 4 34 5");

        ArrayList<Integer> expectedEvenNumbers = new ArrayList<>();
        expectedEvenNumbers.add(4);
        expectedEvenNumbers.add(34);

        //act
        ArrayList<Integer>  evenNumbers = NumberFilter.filterEvenNumbers(numbers);

       //assert
        assertTrue(evenNumbers.containsAll(expectedEvenNumbers));
    }

    @Test
    public void a_list_of_odd_numbers_returns_an_empty_array(){
        //arrange
        int[] numbers = NumberFilter.convertToArray("3 5 7");

        ArrayList<Integer> expectedEvenNumbers = new ArrayList<>();

        //act
        ArrayList<Integer>  evenNumbers = NumberFilter.filterEvenNumbers(numbers);

        //assert
        assertTrue(evenNumbers.containsAll(expectedEvenNumbers));
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void a_list_with_non_numeric_characters_returns_an_exception(){
        //arrange & assert
        exception.expect(NumberFormatException.class);
        exception.expectMessage("Your list contains non-numeric characters.");

        //act
        int[] numbers = NumberFilter.convertToArray("10 5 33 7A");
    }
}