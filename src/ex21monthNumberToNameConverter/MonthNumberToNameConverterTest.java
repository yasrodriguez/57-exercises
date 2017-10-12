package ex21monthNumberToNameConverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for MonthNumberToNameConverter.
 * Created by Yasmin on 7/25/2017.
 */

public class MonthNumberToNameConverterTest
{
    @Test
    public void Month_is_January() throws Exception
    {

        assertEquals("JANUARY", MonthNumberToNameConverter.getMonthName(1));
    }

    @Test
    public void Month_is_February() throws Exception
    {

        assertEquals("FEBRUARY", MonthNumberToNameConverter.getMonthName(2));
    }

    @Test
    public void Month_is_September() throws Exception
    {

        assertEquals("SEPTEMBER", MonthNumberToNameConverter.getMonthName(9));
    }

    @Test
    public void Month_is_December() throws Exception
    {

        assertEquals("DECEMBER", MonthNumberToNameConverter.getMonthName(12));
    }

    @Test
    public void Month_is_invalid() throws Exception
    {

        assertEquals("You must enter a number from 1 to 12. Try again.", MonthNumberToNameConverter.getMonthName(33));
    }

}