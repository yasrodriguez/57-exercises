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
        CarProblems cp = new CarProblems();
        cp.silent = true;
        cp.corrodedBattery = true;
        assertEquals("Clean terminals and try starting again.", CarTroubleshooter.troubleshoot(cp));
    }

    @Test
    public void battery_is_not_corroded()
    {
        CarProblems cp = new CarProblems();
        cp.silent = true;
        assertEquals("Replace cables and try again.", CarTroubleshooter.troubleshoot(cp));
    }

    @Test
    public void car_is_making_clicking_sound()
    {
        CarProblems cp = new CarProblems();
        cp.clickingNoise = true;
         assertEquals("Replace the battery.", CarTroubleshooter.troubleshoot(cp));
    }

    @Test
    public void car_is_failing_to_start()
    {
        CarProblems cp = new CarProblems();
        cp.failToStart = true;
        assertEquals("Check spark plug connections.", CarTroubleshooter.troubleshoot(cp));
    }

    @Test
    public void car_does_not_have_fuel_injection()
    {
        CarProblems cp = new CarProblems();
        cp.deadEngine = true;
        assertEquals("Check to ensure the choke is opening and closing.", CarTroubleshooter.troubleshoot(cp));
    }

    @Test
    public void car_has_fuel_injection()
    {
        CarProblems cp = new CarProblems();
        cp.deadEngine = true;
        cp.fuelInjection = true;
        assertEquals("Get it in for service.", CarTroubleshooter.troubleshoot(cp));
    }

    @Test
    public void car_has_a_problem_that_is_not_in_our_list()
    {
        CarProblems cp = new CarProblems();
        assertEquals("Sorry, we have no suggestions for your problem.", CarTroubleshooter.troubleshoot(cp));
    }
}
