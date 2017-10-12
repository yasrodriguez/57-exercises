package ex31heartRateCalculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Unit tests for Heart Rate Calculator.
 * Created by Yasmin Rodriguez on 8/7/17
 */
public class HeartRateCalculatorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void intensity_at_55_when_age_is_33_and_resting_heart_rate_is_90() throws Exception{
        HashMap targetHeartRates = HeartRateCalculator.calculate(33,90);
        assertEquals(143, targetHeartRates.get(55));
    }

    @Test
    public void intensity_at_60_when_age_is_33_and_resting_heart_rate_is_90() throws Exception{
        HashMap targetHeartRates = HeartRateCalculator.calculate(33,90);
        assertEquals(148, targetHeartRates.get(60));
    }

    @Test
    public void intensity_at_65_when_age_is_33_and_resting_heart_rate_is_90() throws Exception{
        HashMap targetHeartRates = HeartRateCalculator.calculate(33,90);
        assertEquals(153, targetHeartRates.get(65));
    }

    @Test
    public void intensity_at_70_when_age_is_33_and_resting_heart_rate_is_90() throws Exception{
        HashMap targetHeartRates = HeartRateCalculator.calculate(33,90);
        assertEquals(157, targetHeartRates.get(70));
    }

    @Test
    public void intensity_at_75_when_age_is_33_and_resting_heart_rate_is_90() throws Exception{
        HashMap targetHeartRates = HeartRateCalculator.calculate(33,90);
        assertEquals(162, targetHeartRates.get(75));
    }

    @Test
    public void intensity_at_80_when_age_is_33_and_resting_heart_rate_is_90() throws Exception{
        HashMap targetHeartRates = HeartRateCalculator.calculate(33,90);
        assertEquals(167, targetHeartRates.get(80));
    }

    @Test
    public void intensity_at_85_when_age_is_33_and_resting_heart_rate_is_90() throws Exception{
        HashMap targetHeartRates = HeartRateCalculator.calculate(33,90);
        assertEquals(172, targetHeartRates.get(85));
    }

    @Test
    public void intensity_at_90_when_age_is_33_and_resting_heart_rate_is_90() throws Exception{
        HashMap targetHeartRates = HeartRateCalculator.calculate(33,90);
        assertEquals(177, targetHeartRates.get(90));
    }

    @Test
    public void intensity_at_95_when_age_is_33_and_resting_heart_rate_is_90() throws Exception{
        HashMap targetHeartRates = HeartRateCalculator.calculate(33,90);
        assertEquals(182, targetHeartRates.get(95));
    }

    @Test
    public void intensity_at_65_when_age_is_0_and_resting_heart_rate_is_90() throws Exception{
        HashMap targetHeartRates = HeartRateCalculator.calculate(0,90);
        assertEquals(174, targetHeartRates.get(65));
    }

    @Test
    public void when_resting_heart_rate_is_0() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("If your heart rate is 0 or less, you're dead!");
        HashMap targetHeartRates = HeartRateCalculator.calculate(33,0);
    }

    @Test
    public void when_resting_heart_rate_and_age_is_0() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("If your heart rate is 0 or less, you're dead!");
        HashMap targetHeartRates = HeartRateCalculator.calculate(0,0);
    }

    @Test
    public void resting_heart_rate_is_less_than_0() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("If your heart rate is 0 or less, you're dead!");
        HashMap targetHeartRates = HeartRateCalculator.calculate(0,-10);
    }

    @Test
    public void age_is_less_than_0() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("You can't be less than 0 years!");
        HashMap targetHeartRates = HeartRateCalculator.calculate(-10, 80);
    }
}