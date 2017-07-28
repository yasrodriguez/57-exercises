package ex23carTroubleshooter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
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
}
