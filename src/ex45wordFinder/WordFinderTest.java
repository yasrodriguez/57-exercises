package ex45wordFinder;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

/**
 * Unit tests for Word Finder.
 */
public class WordFinderTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void test_that_an_empty_file_returns_an_exception() throws Exception{
        //assert
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("File is empty.");

        //arrange
        WordFinder wf = new WordFinder();

        //act
        wf.readFile("src/ex45wordFinder/empty-file.txt");
    }

    @Test
    public void test_that_all_instances_of_Toto_are_replaced_with_Clifford_in_the_text_of_Wizard_of_Oz() throws Exception{
        //arrange
        WordFinder wf = new WordFinder();
        wf.readFile("src/ex45wordFinder/wizard-of-oz.txt");

        //act
        wf.replace("Toto", "Clifford");
        String newFile = wf.writeFile();

        //assert
        assertTrue(!newFile.contains("Toto"));
    }
}