package ex39recordSorter;


import org.junit.Test;
import java.util.ArrayList;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


/**
 * Unit tests for Record Sorter.
 * Created by Yasmin on 8/16/17
 */
public class RecordSorterTest {

    @Test
    public void verify_that_sorting_works_correctly(){
        //arrange
        ArrayList<Employee> employees = initializeEmployees();
        ArrayList<Employee> expectedEmployeesAfterSort = initializeExpectedEmployees();

        //act
        ArrayList<Employee> employeesAfterSort = RecordSorter.sort(employees);

        //assert
        assertEquals(expectedEmployeesAfterSort.toString(),employeesAfterSort.toString());
    }

    @Test
    public void verify_that_report_prints_to_screen_correctly(){
        //arrange
        ArrayList<Employee> employees = initializeEmployees();
        ArrayList<Employee> expectedEmployeesAfterSort = initializeExpectedEmployees();
        String expectedReport =
                "Name                     | Position                      | Separation Date\n" +
                "-----------------------------------------------------------------------------\n" +
                "Jacquelyn Jackson        | DBA                           | \n" +
                "Jake Jacobson            | Programmer                    | \n" +
                "John Johnson             | Manager                       | 2016-12-31\n" +
                "Michaela Michaelson      | District Manager              | 2015-12-19\n" +
                "Sally Weber              | Web Developer                 | 2015-12-18\n" +
                "Tou Xiong                | Software Engineer             | 2016-10-05\n"
        ;

        //act
        ArrayList<Employee> employeesAfterSort = RecordSorter.sort(employees);
        StringBuilder report = RecordSorter.getReadyForPrinting(employeesAfterSort);

        //assert
        assertEquals(expectedReport, report.toString());

    }

    private ArrayList<Employee> initializeEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Tou", "Xiong", "Software Engineer", LocalDate.of(2016, 10, 05)));
        employees.add(new Employee("John", "Johnson", "Manager", LocalDate.of(2016, 12, 31)));
        employees.add(new Employee("Jacquelyn", "Jackson", "DBA", null));
        employees.add(new Employee("Michaela", "Michaelson", "District Manager", LocalDate.of(2015, 12, 19)));
        employees.add(new Employee("Jake", "Jacobson", "Programmer", null));
        employees.add(new Employee("Sally", "Weber", "Web Developer", LocalDate.of(2015, 12, 18)));

        return employees;
    }

    private ArrayList<Employee> initializeExpectedEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jacquelyn", "Jackson", "DBA", null));
        employees.add(new Employee("Jake", "Jacobson", "Programmer", null));
        employees.add(new Employee("John", "Johnson", "Manager", LocalDate.of(2016, 12, 31)));
        employees.add(new Employee("Michaela", "Michaelson", "District Manager", LocalDate.of(2015, 12, 19)));
        employees.add(new Employee("Sally", "Weber", "Web Developer", LocalDate.of(2015, 12, 18)));
        employees.add(new Employee("Tou", "Xiong", "Software Engineer", LocalDate.of(2016, 10, 05)));

        return employees;
    }
}