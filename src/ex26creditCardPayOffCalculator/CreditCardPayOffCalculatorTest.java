package ex26creditCardPayOffCalculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for the Credit Card Pay Off Calculator.
 */
public class CreditCardPayOffCalculatorTest {

    @Test
    public void book_example() throws Exception{
        CreditCardPayOffCalculator ccpaycalc = new CreditCardPayOffCalculator(5000, 12, 100);
        assertEquals(70, ccpaycalc.calculateMonthsUntilPaidOff(), 0);
    }

}