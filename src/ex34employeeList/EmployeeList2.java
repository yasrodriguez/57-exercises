package ex34employeeList;

import java.util.ArrayList;

/**
 * Create a list of employee names. Print out the list, each employee in its own line. Then, ask for an employee
 * name to remove. Print the remaining employee list.  This version of the Employee List is going to use an Array List.
 * Constraints: Use an array or list to hold the employee names.
 * Created by Yasmin on 8/10/2017
 */

public class EmployeeList2 {
    private ArrayList<String> employees;

    public EmployeeList2(){
        employees = new ArrayList<>();
        employees.add("Janet Jackson");
        employees.add("Angelina Jolie");
        employees.add("Brad Pitt");
        employees.add("Tom Cruise");
        employees.add("Halle Berrie");
        employees.add("Samuel Jackson");
        employees.add("John Travolta");
        employees.add("Uma Thurman");
    }

    public String getEmployeeList(){
        String list = "";

        for(String employee: employees){
            list += employee + '\n';
        }
        System.out.println(list);
        return list;
    }

    public void removeEmployee(String employeeName){
        employees.remove(employeeName);
    }

}
