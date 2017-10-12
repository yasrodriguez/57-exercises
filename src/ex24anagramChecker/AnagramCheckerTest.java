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
    public void is_one_word_anagram () throws Exception
    {
        AnagramChecker ac = new AnagramChecker();
        boolean result = ac.isAnagram("tone","note");
        assertEquals(true, result);
    }

    @Test
    public void is_not_an_anagram () throws Exception
    {
        AnagramChecker ac = new AnagramChecker();
        boolean result = ac.isAnagram("happy","learn");
        assertEquals(false, result);
    }

    @Test
    public void is_multiple_words_anagram () throws Exception
    {
        AnagramChecker ac = new AnagramChecker();
        boolean result = ac.isAnagram("public relations","crap built on lies");
        assertEquals(true, result);
    }
}
