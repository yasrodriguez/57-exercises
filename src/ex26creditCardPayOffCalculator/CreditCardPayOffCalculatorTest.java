package ex26creditCardPayOffCalculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Unit tests for the Credit Card Pay Off Calculator.
 */
public class CreditCardPayOffCalculatorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void book_example() throws Exception{
        CreditCardPayOffCalculator ccpaycalc = new CreditCardPayOffCalculator(5000, 12, 100);
        assertEquals(70, ccpaycalc.calculateMonthsUntilPaidOff());
    }

    @Test
    public void all_0() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("This loan will never be paid off.");
        CreditCardPayOffCalculator ccpaycalc = new CreditCardPayOffCalculator(100, 5.5, 0);
    }

    @Test
    public void apr_is_0() throws Exception{
        CreditCardPayOffCalculator ccpaycalc = new CreditCardPayOffCalculator(1000, 0, 100);
        assertEquals(10, ccpaycalc.calculateMonthsUntilPaidOff());
    }

    @Test
    public void balance_is_0() throws Exception{
       CreditCardPayOffCalculator ccpaycalc = new CreditCardPayOffCalculator(0, 5.5, 100);
        assertEquals(0, ccpaycalc.calculateMonthsUntilPaidOff());
    }

    @Test
    public void monthly_payment_is_0() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("This loan will never be paid off.");
        CreditCardPayOffCalculator ccpaycalc = new CreditCardPayOffCalculator(100, 5.5, 0);
    }
}