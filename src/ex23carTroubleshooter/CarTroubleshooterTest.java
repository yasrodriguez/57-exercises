package ex23carTroubleshooter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for Car Troubleshooter.
 * Created by Yasmin on 7/28/2017
 */

public class CarTroubleshooterTest
{
    @Test
    public void battery_is_corroded()
    {
        CarTroubleshooter ct = new CarTroubleshooter(true,true,false,false,false,false);
        assertEquals("Clean terminals and try starting again.", ct.troubleshoot());
    }

    @Test
    public void battery_is_not_corroded()
    {
        CarTroubleshooter ct = new CarTroubleshooter(true,false,false,false,false,false);
        assertEquals("Replace cables and try again.", ct.troubleshoot());
    }

    @Test
    public void car_is_making_clicking_sound()
    {
        CarTroubleshooter ct = new CarTroubleshooter(false,false,true,false,false,false);
        assertEquals("Replace the battery.", ct.troubleshoot());
    }

    @Test
    public void car_is_failing_to_start()
    {
        CarTroubleshooter ct = new CarTroubleshooter(false,false,false,true,false,false);
        assertEquals("Check spark plug connections.", ct.troubleshoot());
    }

    @Test
    public void car_does_not_have_fuel_injection()
    {
        CarTroubleshooter ct = new CarTroubleshooter(false,false,false,false,true,false);
        assertEquals("Check to ensure the choke is opening and closing.", ct.troubleshoot());
    }

    @Test
    public void car_has_fuel_injection()
    {
        CarTroubleshooter ct = new CarTroubleshooter(false,false,false,false,true,true);
        assertEquals("Get it in for service.", ct.troubleshoot());
    }

    @Test
    public void car_has_a_problem_that_is_not_in_our_list()
    {
        CarTroubleshooter ct = new CarTroubleshooter(false,false,false,false,false,false);
        assertEquals("Sorry, we have no suggestions for your problem.", ct.troubleshoot());
    }
}
