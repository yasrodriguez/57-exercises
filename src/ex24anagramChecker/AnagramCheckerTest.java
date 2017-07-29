package ex24anagramChecker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for Anagram Checker.
 * Created by Yasmin on 7/29/2017
 */

public class AnagramCheckerTest
{
    @Test
    public void same_length () throws Exception
    {
        AnagramChecker ac = new AnagramChecker();
        boolean result = ac.isSameLength("happy","learn");
        assertEquals(true, result);
    }
}
