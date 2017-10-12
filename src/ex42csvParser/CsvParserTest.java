package ex42csvParser;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Unit tests for CSV parser.
 * Created by Yasmin on 8/21/17
 */


public class CsvParserTest {

    @Test
    public void test_that_employees_from_a_csv_file_are_read_and_printed_correctly() throws Exception{
        //arrange
        EmployeeReport er = new EmployeeReport();
        String expectedReport =
                "Ling          Mai      $ 55,900.00" + System.lineSeparator() +
                "Johnson       Jim      $ 56,500.00" + System.lineSeparator() +
                "Jones         Aaron    $ 46,000.00" + System.lineSeparator() +
                "Jones         Chris    $ 34,500.00" + System.lineSeparator() +
                "Swift         Geoffrey $ 14,200.00" + System.lineSeparator() +
                "Xiong         Fong     $ 65,000.00" + System.lineSeparator() +
                "Zarnecki      Sabrina  $ 51,500.00" + System.lineSeparator() +
                "Rodriguez     Yasmin   $100,000.00" + System.lineSeparator() +
                "Fenstermacher Van      $ 75,000.00" + System.lineSeparator();

        //act
        ArrayList<Employee> employees = CsvParser.readFile("src/ex42csvParser/employees.csv");
        String actualReport = er.getEmployeeReport(employees);

        //assert
        assertEquals(expectedReport, actualReport);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void test_that_a_file_that_does_not_exist_throws_a_file_not_found_exception() throws Exception{
        //assert
        exception.expect(FileNotFoundException.class);

        //arrange


        //act
        CsvParser.readFile("src/ex42csvParser/wefasdfs.csv");
    }

    @Test
    public void test_that_an_empty_file_prints_in_the_report_a_message_that_there_are_no_employees() throws Exception{

        //arrange
        EmployeeReport er = new EmployeeReport();
        String expectedReport = "There are no employees to print.";

        //act
        ArrayList<Employee> employees = CsvParser.readFile("src/ex42csvParser/empty.csv");
        String actualReport = er.getEmployeeReport(employees);

        //assert
        assertEquals(expectedReport, actualReport);
    }

    @Test
    public void test_that_employees_from_a_csv_file_that_has_an_empty_line_are_read_and_printed_correctly() throws Exception{
        //arrange
        EmployeeReport er = new EmployeeReport();
        String expectedReport =
                        "Ling          Mai      $ 55,900.00" + System.lineSeparator() +
                        "Johnson       Jim      $ 56,500.00" + System.lineSeparator() +
                        "Jones         Aaron    $ 46,000.00" + System.lineSeparator() +
                        "Jones         Chris    $ 34,500.00" + System.lineSeparator() +
                        "Swift         Geoffrey $ 14,200.00" + System.lineSeparator() +
                        "Xiong         Fong     $ 65,000.00" + System.lineSeparator() +
                        "Zarnecki      Sabrina  $ 51,500.00" + System.lineSeparator() +
                        "Rodriguez     Yasmin   $100,000.00" + System.lineSeparator() +
                        "Fenstermacher Van      $ 75,000.00" + System.lineSeparator();

        //act
        ArrayList<Employee> employees = CsvParser.readFile("src/ex42csvParser/employees-empty-line-in-the-middle.csv");
        String actualReport = er.getEmployeeReport(employees);

        //assert
        assertEquals(expectedReport, actualReport);
    }

}