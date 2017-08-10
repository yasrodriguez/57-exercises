package ex34employeeList;

import java.util.Arrays;

/**
 * Create a list of employee names. Print out the list, each employee in its own line. Then, ask for an employee
 * name to remove. Print the remaining employee list.  This version of the Employee List is going to use an array.
 * Constraints: Use an array or list to hold the employee names.
 * Created by Yasmin on 8/10/2017
 */

public class EmployeeList {
    private String[] employees;
    private int numberOfEmployees;

    public EmployeeList() {
        employees = new String[8];
        employees[0] ="Janet Jackson";
        employees[1] = "Angelina Jolie";
        employees[2] = "Brad Pitt";
        employees[3] = "Tom Cruise";
        employees[4] = "Halle Berrie";
        employees[5] = "Samuel Jackson";
        employees[6] = "John Travolta";
        employees[7] = "Uma Thurman";
        numberOfEmployees = employees.length;
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
        boolean found = false;

        for(int i = 0; i < numberOfEmployees && ! found; i++){
            if(employees[i].equals(employeeName)) {
                found = true;
                shiftEmployeesBack(i);
            }
        }
    }

    private void shiftEmployeesBack(int startIndex){
        if(startIndex != numberOfEmployees - 1){
            for(int i = startIndex; i < numberOfEmployees - 1; i++){
                employees[i] = employees [i + 1];
            }
        }
        numberOfEmployees--;
        employees = Arrays.copyOf(employees, numberOfEmployees);
    }
}
