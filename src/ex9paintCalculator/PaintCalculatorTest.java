package ex9paintCalculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for Paint Calculator.
 * Created by Yasmin on 6/21/2017.
 */
public class PaintCalculatorTest {
    @Test
    public void smallRoomRoundsUp()
    {
    PaintCalculator test = new PaintCalculator(12, 15);
    test.executeTest();
    assertEquals(1, test.getGallons());
}
    @Test
    public void bigRoomRoundsDown()
    {
        PaintCalculator test = new PaintCalculator(50, 45);
        test.executeTest();
        assertEquals(7, test.getGallons());
    }
    @Test
    public void noRounding()
    {
        PaintCalculator test = new PaintCalculator(50,7);
        test.executeTest();
        assertEquals(1, test.getGallons());
    }
}