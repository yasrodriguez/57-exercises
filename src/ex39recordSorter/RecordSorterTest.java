package ex39recordSorter;


import org.junit.Test;
import java.util.ArrayList;
import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Unit tests for Record Sorter.
 * Created by Yasmin on 8/16/17
 */
public class RecordSorterTest {

    @Test
    public void test(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Tou", "Xiong", "Software Engineer", LocalDate.of(2016, 10, 05)));
        employees.add(new Employee("John", "Johnson", "Manager", LocalDate.of(2016, 12, 31)));
        employees.add(new Employee("Jacquelyn", "Jackson", "DBA", null));
        employees = RecordSorter.sort(employees);
        RecordSorter.print(employees);
    }
}