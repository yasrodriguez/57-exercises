package ex19bmiCalculator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.InputMismatchException;

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
    public void initialize_BMI() throws Exception
    {
        bmic = new BMICalculator(130, 64);
    }

    @Test
    public void weight_is_0() throws Exception
    {
        exception.expect(NumberFormatException.class);
        exception.expectMessage("Input can't be 0.");
        bmic = new BMICalculator(0, 64);
    }

    @Test
    public void height_is_0() throws Exception
    {
        exception.expect(NumberFormatException.class);
        exception.expectMessage("Input can't be 0.");
        bmic = new BMICalculator(120, 0);
    }

    @Test
    public void normal_weight() throws Exception
    {
        bmic = new BMICalculator(130,64);
        bmic.calculateBmi();
        assertEquals("Your BMI is 22.3."+ System.lineSeparator()+ "You are within the ideal weight range.", bmic.evaluateBmi());
    }

    @Test
    public void normal_weight_lower_corner_case() throws Exception
    {
        bmic = new BMICalculator(125,69);
        bmic.calculateBmi();
        assertEquals("Your BMI is 18.5."+ System.lineSeparator()+ "You are within the ideal weight range.", bmic.evaluateBmi());
    }

    @Test
    public void underweight() throws Exception
    {
        bmic = new BMICalculator(100,69);
        bmic.calculateBmi();
        assertEquals("Your BMI is 14.8."+ System.lineSeparator()+ "You are underweight.", bmic.evaluateBmi());
    }

    @Test
    public void overweight() throws Exception
    {
        bmic = new BMICalculator(230, 64);
        bmic.calculateBmi();
        assertEquals("Your BMI is 39.5."+ System.lineSeparator()+ "You are overweight.", bmic.evaluateBmi());
    }


}
