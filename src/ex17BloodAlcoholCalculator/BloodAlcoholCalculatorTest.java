package ex17BloodAlcoholCalculator;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Unit tests for Blood Alcohol Calculator.
 * Created by Yasmin on 7/7/2017.
 */
public class BloodAlcoholCalculatorTest
{
    private OutputStream os = new ByteArrayOutputStream();
    private PrintStream ps = new PrintStream(os);
    private BloodAlcoholCalculator bac;

    @Test
    public void man_with_illegal_bac() throws Exception
    {
        System.setOut(ps);
        bac = new BloodAlcoholCalculator(170, "M", 84, 5, 4.5 );
        bac.calculate();
        bac.printResults();
        assertEquals("Your BAC is 0.106" + System.lineSeparator() + "It's not legal for you to drive.", os.toString());
    }

    @Test
    public void woman_with_illegal_bac() throws Exception
    {
        System.setOut(ps);
        bac = new BloodAlcoholCalculator(115, "F", 5, 40, 3);
        bac.calculate();
        bac.printResults();
        assertEquals("Your BAC is 0.090" + System.lineSeparator() + "It's not legal for you to drive.", os.toString());
    }
    @Test
    public void man_with_legal_bac() throws Exception
    {
        System.setOut(ps);
        bac = new BloodAlcoholCalculator(170, "M", 16, 5, 4.5 );
        bac.calculate();
        bac.printResults();
        assertEquals("Your BAC is 0.000" + System.lineSeparator() + "You're good to drive.", os.toString());
    }

    @Test
    public void woman_with_legal_bac() throws Exception
    {
        System.setOut(ps);
        bac = new BloodAlcoholCalculator(115, "F", 8, 5, 1);
        bac.calculate();
        bac.printResults();
        assertEquals("Your BAC is 0.012" + System.lineSeparator() + "You're good to drive.", os.toString());
    }

}