package ex22numberChecker;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for Number Checker.
 * Created by Yasmin on 7/27/17.
 */

public class NumberCheckerTest
{
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void all_numbers_are_different() throws Exception
    {
        NumberChecker nc = new NumberChecker(3,2,1);
        assertEquals(3, nc.getLargestNumber());
    }

    @Test
    public void all_three_numbers_are_the_same() throws Exception
    {
        NumberChecker nc = new NumberChecker(1,1,1);
        exception.expect(NumberFormatException.class);
        exception.expectMessage("Numbers must be unique.");
        nc.getLargestNumber();
    }

    @Test
    public void two_numbers_are_the_same() throws Exception
    {
        NumberChecker nc = new NumberChecker(5,4,5);
        exception.expect(NumberFormatException.class);
        exception.expectMessage("Numbers must be unique.");
        nc.getLargestNumber();
    }
}
