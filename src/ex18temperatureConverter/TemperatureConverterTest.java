package ex18temperatureConverter;

import org.junit.Test;
import static org.junit.Assert.*;
import ex18temperatureConverter.TemperatureConverter.*;

/**
 * Unit tests for Temperature Converter.
 * Created by Yasmin on 7/11/2017.
 */
public class TemperatureConverterTest
{
    private TemperatureConverter tc;

    @Test
    public void book_example() throws Exception
    {
        tc = new TemperatureConverter(TemperatureScale.Celsius, 32);
        assertEquals(0, tc.convert(), 0);
    }

    @Test
    public void convert_from_Celsius_to_Fahrenheit() throws Exception
    {
        tc = new TemperatureConverter(TemperatureScale.Farenheit, 27);
        assertEquals(81, tc.convert(), 0);
    }

    @Test
    public void convert_from_Fahrenheit_to_Celsius() throws Exception
    {
        tc = new TemperatureConverter(TemperatureScale.Celsius, 63);
        assertEquals(17, tc.convert(), 0);
    }

    @Test
    public void convert_negative_temperature() throws Exception
    {
        tc = new TemperatureConverter(TemperatureScale.Celsius, -25);
        assertEquals(-32, tc.convert(), 0);
    }
}