package ex40recordFilter;

import ex39recordSorter.Employee;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *  Unit tests for Record Filter
 *  Created by Yasmin on 8/18/17
 */
public class RecordFilterTest {
    private ArrayList<Employee> employees = new ArrayList<>();

    @Test
    public void verify_that_searching_for_the_string_on_returns_all_employees_containing_on_in_their_name_or_last_name(){
        //arrange

        RecordFilter rf = new RecordFilter(employees);
        String expectedResults = "Name                     | Position                      | Separation Date\n" +
                "-----------------------------------------------------------------------------\n" +
                "Tou Xiong                | Software Engineer             | 2016-10-05\n" +
                "John Johnson             | Manager                       | 2016-12-31\n" +
                "Jacquelyn Jackson        | DBA                           | \n" +
                "Michaela Michaelson      | District Manager              | 2015-12-19\n" +
                "Jake Jacobson            | Programmer                    | \n" +
                "Sonnie Smith             | Senior QA                     | 2017-08-17\n" +
                "Martha Son               | Lead Dev                      | 2017-08-18\n";

        //act
        String results = rf.find("on").toString();

        //assert
        assertEquals(expectedResults, results);
    }
    @Before
    public void initializeEmployeeList(){
        employees.add(new Employee("Tou", "Xiong", "Software Engineer", LocalDate.of(2016, 10, 05)));
        employees.add(new Employee("John", "Johnson", "Manager", LocalDate.of(2016, 12, 31)));
        employees.add(new Employee("Jacquelyn", "Jackson", "DBA", null));
        employees.add(new Employee("Michaela", "Michaelson", "District Manager", LocalDate.of(2015, 12, 19)));
        employees.add(new Employee("Jake", "Jacobson", "Programmer", null));
        employees.add(new Employee("Sally", "Weber", "Web Developer", LocalDate.of(2015, 12, 18)));
        employees.add(new Employee("Sonnie", "Smith", "Senior QA", LocalDate.of(2017, 8, 17)));
        employees.add(new Employee("Martha", "Son", "Lead Dev", LocalDate.of(2017, 8, 18)));
        employees.add(new Employee("Tom", "Cruise", "Entry Level Developer", LocalDate.of(2017, 6, 30)));
    }
}