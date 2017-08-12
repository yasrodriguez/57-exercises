package ex34employeeList;

/**
 * Create a list of employee names. Print out the list, each employee in its own line. Then, ask for an employee
 * name to remove. Print the remaining employee list.  This version of the Employee List is going to use an array.
 * Constraints: Use an array or list to hold the employee names.
 * Created by Yasmin on 8/10/2017
 */

public class EmployeeList {
    private String[] employees;
    private int totalEmployees;

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
       totalEmployees = employees.length;
    }

    public String getEmployeeList(){
        String list = "";

        for(int i = 0; i < totalEmployees; i++){
            list += employees[i] + '\n';
        }
        return list;
    }

    public void removeEmployee(String employeeName){
        boolean found = false;

        for(int i = 0; i < totalEmployees && ! found; i++){
            if(employees[i].equals(employeeName)) {
                found = true;
                copyArrayWithoutEmployee(i);
            }
        }

        if (! found){
            throw new IllegalArgumentException("That employee does not exist.");
        }
    }

    private void copyArrayWithoutEmployee(int employeeIndexToRemove){
        int numberOfElementsToCopy = totalEmployees - (employeeIndexToRemove + 1);
        System.arraycopy(employees, employeeIndexToRemove + 1, employees, employeeIndexToRemove, numberOfElementsToCopy);
        totalEmployees--;
    }
}
