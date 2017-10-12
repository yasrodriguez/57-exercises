package ex7areaCalculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for Area Calculator.
 * Created by Yasmin on 6/15/2017.
 */
public class AreaCalculatorTest {
    @Test
       public void wholeNumbers() {
        AreaCalculator calc = new AreaCalculator(15,20);
        calc.executeTest();
        assertEquals("300.000 square feet", calc.getArea());
        assertEquals("27.871 square meters", calc.getAreaInMeters());
    }

    @Test
    public void decimalNumbers() {
        AreaCalculator calc = new AreaCalculator(2.5,5.5);
        calc.executeTest();
        assertEquals("13.750 square feet", calc.getArea());
        assertEquals("1.277 square meters", calc.getAreaInMeters());
    }
}

