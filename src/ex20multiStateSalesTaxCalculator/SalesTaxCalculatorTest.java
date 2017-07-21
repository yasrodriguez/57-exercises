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
        assertEquals(BigDecimal.valueOf(5.50).setScale(2), stc.calculateTax());
        assertEquals(BigDecimal.valueOf(105.50).setScale(2), stc.calculateTotal());
    }

    @Test
    public void Wisconsin_Eau_Claire()
    {
        SalesTaxCalculator stc = new SalesTaxCalculator(BigDecimal.valueOf(100), "WI", "Eau Claire");
        assertEquals(BigDecimal.valueOf(6).setScale(2), stc.calculateTax());
        assertEquals(BigDecimal.valueOf(106).setScale(2), stc.calculateTotal());
    }

    @Test
    public void Wisconsin_Dunn()
    {
        SalesTaxCalculator stc = new SalesTaxCalculator(BigDecimal.valueOf(100), "WI", "Dunn");
        assertEquals(BigDecimal.valueOf(5.90).setScale(2), stc.calculateTax());
        assertEquals(BigDecimal.valueOf(105.90).setScale(2), stc.calculateTotal());
    }

    @Test
    public void Illinois()
    {
        SalesTaxCalculator stc = new SalesTaxCalculator(BigDecimal.valueOf(100), "IL", "");
        assertEquals(BigDecimal.valueOf(8).setScale(2), stc.calculateTax());
        assertEquals(BigDecimal.valueOf(108).setScale(2), stc.calculateTotal());
    }

    @Test
    public void Michigan()
    {
        SalesTaxCalculator stc = new SalesTaxCalculator(BigDecimal.valueOf(100), "MI", "");
        assertEquals(BigDecimal.valueOf(0).setScale(2), stc.calculateTax());
        assertEquals(BigDecimal.valueOf(100).setScale(2), stc.calculateTotal());
    }

}