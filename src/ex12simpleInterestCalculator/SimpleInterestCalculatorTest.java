package ex12simpleInterestCalculator;

import org.junit.Test;

import java.math.*;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for Simple Interest Calculator.
 * Created by Yasmin on 6/27/2017.
 */
public class SimpleInterestCalculatorTest
{
    @Test
    public void book_example()
    {
        SimpleInterestCalculator sic = new SimpleInterestCalculator(1500,4.3,4);
        sic.calculate();
        assertEquals(BigDecimal.valueOf(1758.00).setScale(2), sic.getTotalAccrued());
    }
    @Test
    public void round_down_example()
    {
        SimpleInterestCalculator sic = new SimpleInterestCalculator(150, 7.375,1 );
        sic.calculate();
        assertEquals(BigDecimal.valueOf(161.07).setScale(2), sic.getTotalAccrued());
    }
    @Test
    public void round_up_example()
    {
        SimpleInterestCalculator sic = new SimpleInterestCalculator(123, 4.5,3 );
        sic.calculate();
        assertEquals(BigDecimal.valueOf(139.61).setScale(2), sic.getTotalAccrued());
    }
}
