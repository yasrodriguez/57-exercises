package ex41nameSorter;

import org.junit.Rule;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import junitx.framework.FileAssert;
import org.junit.rules.ExpectedException;


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
}