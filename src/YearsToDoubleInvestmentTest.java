import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Unit tests for Years to Double Investment.
 * Created by Yasmin on 8/7/17.
 */
public class YearsToDoubleInvestmentTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void rate_is_5() throws Exception{
        assertEquals(14.4,YearsToDoubleInvestment.calculateYears(5),0);
    }

    @Test
    public void rate_is_0() throws Exception{
        exception.expect(ArithmeticException.class);
        exception.expectMessage("Rate can't be 0!");
        YearsToDoubleInvestment.calculateYears(0);
    }

}