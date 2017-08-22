package ex42csvParser;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for CSV parser.
 * Created by Yasmin on 8/21/17
 */


public class CsvParserTest {
//TODO: Complete unit tests

    @Test
    public void test() throws Exception{
        //arrange
        CsvParser cp = new CsvParser();

        //act
        cp.readFile("src/ex42csvParser/employees.csv");

        //assert
        String report = cp.getEmployeeReport();
        System.out.print(report);

    }

}