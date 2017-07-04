package ex14taxCalculator;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Unit tests for Tax Calculator.
 * Created by Yasmin on 7/3/2017.
 */
public class TaxCalculatorTest
{
    private OutputStream os = new ByteArrayOutputStream();
    private PrintStream ps = new PrintStream(os);

    @Test
    public void state_is_Wisconsin()
    {
        System.setOut(ps);
        TaxCalculator test = new TaxCalculator(10, "WI", true);
        test.calculate();
        test.printResults();
        assertEquals("The subtotal is $10.00." + System.lineSeparator() + "The tax is $0.55." + System.lineSeparator() + "The total is $10.55."+ System.lineSeparator(), os.toString());
    }
    @Test
    public void state_is_Michigan()
    {
        System.setOut(ps);
        TaxCalculator test = new TaxCalculator(15.99, "MI", true);
        test.calculate();
        test.printResults();
        assertEquals("The total is $15.99."+ System.lineSeparator(), os.toString());
    }
}