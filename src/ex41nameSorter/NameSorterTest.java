package ex41nameSorter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import junitx.framework.FileAssert;



/**
 * Unit tests for Name Sorter
 * Completed by Yasmin on 8/20/17
 */

public class NameSorterTest {

    @Test
    public void test_that_file_containing_names_is_read_sorted_and_printed_to_output_file_correctly() throws Exception {
        //arrange
        NameSorter ns = new NameSorter();
        File output = new File("src/ex41nameSorter/sorted-names.txt");
        File expectedOutput = new File("src/ex41nameSorter/expected-names.txt");

        //act
        ns.readFile("src/ex41nameSorter/names.txt");
        ns.writeToFile("src/ex41nameSorter/sorted-names.txt");

        //assert
        FileAssert.assertEquals(expectedOutput, output);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void test_that_a_file_that_does_not_exist_throws_a_file_not_found_exception() throws Exception {
        //assert
        exception.expect(FileNotFoundException.class);

        //arrange
        NameSorter ns = new NameSorter();

        //act
        ns.readFile("src/ex41nameSorter/asdf.txt");
    }

    @Test
    public void test_that_an_empty_file_returns_a_message_and_is_not_processed() throws Exception{
        //Setup to capture standard output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //arrange
        NameSorter ns = new NameSorter();

        //act
        ns.readFile("src/ex41nameSorter/empty-file.txt");

        //assert
        assertEquals("File is empty.", outContent.toString());

        //cleanup
        System.setOut(null);


    }
}