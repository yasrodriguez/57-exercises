package ex42csvParser;

import static java.util.Comparator.comparing;
import java.util.ArrayList;

/**
 * Generate an employee report.
 * Created by Yasmin on 8/23/2017
 */

public class EmployeeReport {

    private ArrayList<Employee> employees = new ArrayList<>();

    public String getEmployeeReport(ArrayList<Employee> employeeList) {
        StringBuilder sb = new StringBuilder();

        if(employeeList.isEmpty()){
            sb.append("There are no employees to print.");
        }
        else {
            employees = employeeList;

            int columnWidthLastName = getMaximumFieldLength("LastName") + 1;
            int columnWidthFirstName = getMaximumFieldLength("FirstName") + 1;
            int columnWidthSalary = getMaximumFieldLength("Salary") + 2;

            String template = "%-" + columnWidthLastName + "s" + "%-" + columnWidthFirstName + "s" +
                    "$%," + columnWidthSalary + ".2f%n";

            for (Employee e : employees) {
                sb.append(String.format(template, e.getLastName(), e.getFirstName(), e.getSalary()));
            }
        }
        return sb.toString();
    }

    private int getMaximumFieldLength(String fieldName) {
        switch (fieldName) {
            case "LastName": {
                return employees.stream().max(comparing(Employee::getLastNameLength)).get().getLastNameLength();
            }
            case "FirstName": {
                return employees.stream().max(comparing(Employee::getFirstNameLength)).get().getFirstNameLength();
            }
            case "Salary": {
                return employees.stream().max(comparing(Employee::getSalaryLength)).get().getSalaryLength();
            }
            default: {
                return 0;
            }
        }
    }
}

