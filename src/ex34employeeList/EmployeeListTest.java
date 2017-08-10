package ex34employeeList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for Employee List (using an array)
 * Created by Yasmin on 8/10/17
 */
public class EmployeeListTest {

    @Test
    public void remove_third_employee() throws Exception{
        EmployeeList el = new EmployeeList();
        el.getEmployeeList();
        el.removeEmployee("Brad Pitt");
        assertEquals("Janet Jackson\nAngelina Jolie\nTom Cruise\nHalle Berrie\nSamuel " +
                "Jackson\nJohn Travolta\nUma Thurman\n", el.getEmployeeList());
    }

    @Test
    public void remove_first_employee() throws Exception{
        EmployeeList el = new EmployeeList();
        el.getEmployeeList();
        el.removeEmployee("Janet Jackson");
        assertEquals("Angelina Jolie\nBrad Pitt\nTom Cruise\nHalle Berrie\nSamuel " +
                "Jackson\nJohn Travolta\nUma Thurman\n", el.getEmployeeList());
    }

    @Test
    public void remove_last_employee() throws Exception{
        EmployeeList el = new EmployeeList();
        el.getEmployeeList();
        el.removeEmployee("Uma Thurman");
        assertEquals("Janet Jackson\nAngelina Jolie\nBrad Pitt\nTom Cruise\nHalle Berrie\nSamuel " +
                "Jackson\nJohn Travolta\n", el.getEmployeeList());
    }
}