package ex34employeeList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Unit tests for Employee List 2
 * Created by Yasmin on 8/10/17
 */
public class EmployeeList2Test {

   @Test
    public void remove_third_employee() throws Exception{
        EmployeeList2 el = new EmployeeList2();
        String employeeToRemove = "Brad Pitt";
        if(el.getEmployees().contains(employeeToRemove)) {
            el.removeEmployee("Brad Pitt");
            assertTrue(!el.getEmployees().contains(employeeToRemove));
        }
    }

    @Test
    public void remove_first_employee() throws Exception {
        EmployeeList2 el = new EmployeeList2();
        String employeeToRemove = "Janet Jackson";
        if (el.getEmployees().contains(employeeToRemove)) {
            el.removeEmployee("Janet Jackson");
            assertTrue(!el.getEmployees().contains(employeeToRemove));
        }
    }

    @Test
    public void remove_last_employee() throws Exception {
        EmployeeList2 el = new EmployeeList2();
        String employeeToRemove = "Uma Thurman";
        if (el.getEmployees().contains(employeeToRemove)) {
            el.removeEmployee("Uma Thurman");
            assertTrue(!el.getEmployees().contains(employeeToRemove));
        }
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void try_to_remove_an_employee_that_does_not_exist() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("That employee does not exist.");
        EmployeeList2 el = new EmployeeList2();
        el.removeEmployee("Chris Hemsworth");
    }
}