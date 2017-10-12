package ex46wordCounter;

import org.junit.Test;
import java.util.TreeSet;
import static org.junit.Assert.*;

/**
 * Unit tests for Word Counter.
 */
public class WordCounterTest {

    @Test
    public void test_that_count_for_the_word_Annabelle_is_correct()throws Exception{
        //arrange
        WordCounter wc = new WordCounter();
        Word Annabel = new Word("Annabel", 0);

        //act
        wc.count("src/ex46wordCounter/annabel-lee.txt");
        TreeSet<Word> words = wc.getWordInventory();

        //assert
       int actualCount = words.floor(Annabel).getCount();
       assertTrue(actualCount == 7);
    }

    @Test
    public void test_that_words_are_printed_in_descending_order_of_frequency()throws Exception{
        //arrange
        WordCounter wc = new WordCounter();
        String expectedReport =
                "the         : **************************\n" +
                "by          : ***********\n" +
                "a           : *********\n" +
                "and         : ********\n" +
                "Annabel     : *******\n" +
                "In          : *******\n" +
                "her         : *******\n" +
                "was         : *******\n" +
                "And         : ******\n" +
                "Of          : ******\n" +
                "this        : ******\n" +
                "Lee;        : *****\n" +
                "kingdom     : *****\n" +
                "love        : *****\n" +
                "my          : *****\n" +
                "I           : ****\n" +
                "beautiful   : ****\n" +
                "of          : ****\n" +
                "than        : ****\n" +
                "in          : ***\n" +
                "many        : ***\n" +
                "sea,        : ***\n" +
                "that        : ***\n" +
                "But         : **\n" +
                "Heaven      : **\n" +
                "That        : **\n" +
                "ago,        : **\n" +
                "all         : **\n" +
                "came        : **\n" +
                "darling�my  : **\n" +
                "down        : **\n" +
                "far         : **\n" +
                "from        : **\n" +
                "lived       : **\n" +
                "loved       : **\n" +
                "maiden      : **\n" +
                "me.         : **\n" +
                "never       : **\n" +
                "out         : **\n" +
                "reason      : **\n" +
                "sea.        : **\n" +
                "sepulchre   : **\n" +
                "she         : **\n" +
                "soul        : **\n" +
                "there       : **\n" +
                "we�         : **\n" +
                "wind        : **\n" +
                "with        : **\n" +
                "(as         : *\n" +
                "A           : *\n" +
                "By          : *\n" +
                "Can         : *\n" +
                "Chilling    : *\n" +
                "Coveted     : *\n" +
                "For         : *\n" +
                "Heaven,     : *\n" +
                "It          : *\n" +
                "Lee.        : *\n" +
                "Lee�        : *\n" +
                "My          : *\n" +
                "Nor         : *\n" +
                "So          : *\n" +
                "Than        : *\n" +
                "The         : *\n" +
                "To          : *\n" +
                "Went        : *\n" +
                "With        : *\n" +
                "Yes!�that   : *\n" +
                "above       : *\n" +
                "angels      : *\n" +
                "angels,     : *\n" +
                "away        : *\n" +
                "be          : *\n" +
                "beams,      : *\n" +
                "blew        : *\n" +
                "bore        : *\n" +
                "bride,      : *\n" +
                "bright      : *\n" +
                "bringing    : *\n" +
                "but         : *\n" +
                "child       : *\n" +
                "child,      : *\n" +
                "chilling    : *\n" +
                "cloud       : *\n" +
                "cloud,      : *\n" +
                "demons      : *\n" +
                "dissever    : *\n" +
                "dreams      : *\n" +
                "envying     : *\n" +
                "ever        : *\n" +
                "eyes        : *\n" +
                "feel        : *\n" +
                "half        : *\n" +
                "happy       : *\n" +
                "highborn    : *\n" +
                "it          : *\n" +
                "killing     : *\n" +
                "kinsmen     : *\n" +
                "know        : *\n" +
                "know,       : *\n" +
                "lie         : *\n" +
                "life        : *\n" +
                "long        : *\n" +
                "love�       : *\n" +
                "may         : *\n" +
                "me          : *\n" +
                "me,         : *\n" +
                "men         : *\n" +
                "me�         : *\n" +
                "moon        : *\n" +
                "more        : *\n" +
                "name        : *\n" +
                "neither     : *\n" +
                "night,      : *\n" +
                "night-tide, : *\n" +
                "no          : *\n" +
                "not         : *\n" +
                "older       : *\n" +
                "other       : *\n" +
                "our         : *\n" +
                "rise,       : *\n" +
                "sea         : *\n" +
                "sea)        : *\n" +
                "sea�        : *\n" +
                "seraphs     : *\n" +
                "shut        : *\n" +
                "side        : *\n" +
                "so          : *\n" +
                "so,         : *\n" +
                "sounding    : *\n" +
                "stars       : *\n" +
                "stronger    : *\n" +
                "that,       : *\n" +
                "those       : *\n" +
                "thought     : *\n" +
                "to          : *\n" +
                "tomb        : *\n" +
                "under       : *\n" +
                "up          : *\n" +
                "we          : *\n" +
                "were        : *\n" +
                "who         : *\n" +
                "whom        : *\n" +
                "wing�d      : *\n" +
                "wiser       : *\n" +
                "without     : *\n" +
                "year        : *\n" +
                "you         : *\n"
               ;

        //act
        wc.count("src/ex46wordCounter/annabel-lee.txt");
        String actualReport = wc.generateHistogram();

        //assert
        assertEquals(expectedReport, actualReport);
    }
}