package ex18temperatureConverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for Temperature Converter.
 * Created by Yasmin on 7/11/2017.
 */
public class TemperatureConverterTest
{
    private TemperatureConverter tp;

    @Test
    public void book_example() throws Exception
    {
        tp = new TemperatureConverter("C", 32);
        assertEquals(0, tp.convert(), 0);
    }

    @Test
    public void convert_from_Celsius_to_Fahrenheit() throws Exception
    {
        tp = new TemperatureConverter("F", 27);
        assertEquals(81, tp.convert(), 0);
    }

    @Test
    public void convert_from_Fahrenheit_to_Celsius() throws Exception
    {
        tp = new TemperatureConverter("C", 63);
        assertEquals(17, tp.convert(), 0);
    }

}