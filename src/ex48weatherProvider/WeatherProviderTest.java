package ex48weatherProvider;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Weather Provider.
 */
public class WeatherProviderTest {

    @Test
    public void integration_test() throws Exception{
        String apiKey = "12345"; //Must enter a valid key
        WeatherProvider wp = new WeatherProvider(apiKey);
        System.out.println(wp.getTemperature("London"));
        System.out.println(wp.getTemperature("Ann Arbor"));
    }
}