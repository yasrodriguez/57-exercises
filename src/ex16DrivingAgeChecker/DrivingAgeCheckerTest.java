package ex16DrivingAgeChecker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Unit tests for Driving Age Checker.
 * Created by Yasmin on 7/5/2017.
 */
public class DrivingAgeCheckerTest
{
    private OutputStream os = new ByteArrayOutputStream();
    private PrintStream ps = new PrintStream(os);
    private DrivingAgeChecker ageChecker;

    @Test
    public void age_is_16() throws Exception
    {
        System.setOut(ps);
        ageChecker = new DrivingAgeChecker(16);
        ageChecker.checkAge();
        assertEquals("Congratulations, you are old enough to legally drive." + System.lineSeparator(), os.toString());
    }

    @Test
    public void age_is_less_than_16() throws Exception
    {
        System.setOut(ps);
        ageChecker = new DrivingAgeChecker(15);
        ageChecker.checkAge();
        assertEquals("Sorry, you are not old enough to legally drive." + System.lineSeparator(), os.toString());
    }

    @Test
    public void age_is_greater_than_16() throws Exception
    {
        System.setOut(ps);
        ageChecker = new DrivingAgeChecker(17);
        ageChecker.checkAge();
        assertEquals("Congratulations, you are old enough to legally drive." + System.lineSeparator(), os.toString());
    }
}