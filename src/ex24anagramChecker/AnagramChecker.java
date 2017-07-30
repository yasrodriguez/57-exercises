package ex24anagramChecker;

import java.util.Arrays;

/**
 * Compare two strings and determine if they're an anagram (word formed by rearranging the letters of another).
 * Constraints: Use a function isAnagram that takes two words and returns true or false.
 * Check that both words are the same length.
 * Created by Yasmin on 7/29/2017
 */

public class AnagramChecker
{

    public boolean isAnagram(String word1, String word2)
    {
        word1 = removeWhiteSpaces(word1);
        word2 = removeWhiteSpaces(word2);

        if(isSameLength(word1, word2))
        {
            char[] array1 = word1.toCharArray();
            char[] array2 = word2.toCharArray();

            Arrays.sort(array1);
            Arrays.sort(array2);

            word1 = String.valueOf(array1);
            word2 = String.valueOf(array2);

            return word1.equals(word2);
        }
        return false;
    }

    private String removeWhiteSpaces(String word)
    {
        return word.replace(" ","");
    }

    private boolean isSameLength(String word1, String word2)
    {
        return word1.length() == word2.length();
    }
}
