package CompoundInterestCalculator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Unit tests for Compound Interest Calculator.
 * Created by Yasmin on 7/1/2017.
 */
public class CompoundInterestCalculatorTest
{
    @Test
    public void book_example()
    {
        CompoundInterestCalculator calc = new CompoundInterestCalculator(1500,4.3,6,4);
        calc.calculate();
        assertEquals(calc.getTotalAmount(), BigDecimal.valueOf(1938.84));
    }
    @Test
    public void random_example()
    {
            CompoundInterestCalculator calc = new CompoundInterestCalculator(2700.30,5.375,5,12);
            calc.calculate();
            assertEquals(calc.getTotalAmount(), BigDecimal.valueOf(3530.76));
    }
}