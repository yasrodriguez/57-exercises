package ex20multiStateSalesTaxCalculator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Unit tests for Multi State Sales Tax Calculator.
 * Created by Yasmin on 7/19/2017.
 */
public class SalesTaxCalculatorTest
{
    @Test
    public void Wisconsin_no_county()
    {
        SalesTaxCalculator stc = new SalesTaxCalculator(BigDecimal.valueOf(100), "WI", "");
        assertEquals("The tax is 5.50."+System.lineSeparator()+"The total is 105.50."+System.lineSeparator(), stc.test());
    }

    @Test
    public void Wisconsin_Eau_Claire()
    {
        SalesTaxCalculator stc = new SalesTaxCalculator(BigDecimal.valueOf(100), "WI", "Eau Claire");
        assertEquals("The tax is 6.00."+System.lineSeparator()+"The total is 106.00."+System.lineSeparator(), stc.test());
    }

    @Test
    public void Wisconsin_Dunn()
    {
        SalesTaxCalculator stc = new SalesTaxCalculator(BigDecimal.valueOf(100), "WI", "Dunn");
        assertEquals("The tax is 5.90."+System.lineSeparator()+"The total is 105.90."+System.lineSeparator(), stc.test());
    }

    @Test
    public void Illinois()
    {
        SalesTaxCalculator stc = new SalesTaxCalculator(BigDecimal.valueOf(100), "IL", "");
        assertEquals("The tax is 8.00."+System.lineSeparator()+"The total is 108.00."+System.lineSeparator(), stc.test());
    }

    @Test
    public void Michigan()
    {
        SalesTaxCalculator stc = new SalesTaxCalculator(BigDecimal.valueOf(100), "MI", "");
        assertEquals("The total is 100.00."+System.lineSeparator(), stc.test());
    }

}