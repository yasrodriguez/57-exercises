package ex19bmiCalculator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Unit tests for BMI Calculator.
 * Created by Yasmin on 7/17/2017.
 */
public class BMICalculatorTest
{
    private BMICalculator bmic;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void happy_path() throws Exception
    {
        bmic = new BMICalculator("130", "64");

    }

    @Test
    public void non_numeric_weight() throws Exception
    {
        exception.expect(NumberFormatException.class);
        exception.expectMessage("There is something wrong with your input. You must enter a number.");
        bmic = new BMICalculator("abc", "64");

    }
}
