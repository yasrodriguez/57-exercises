package ex40recordFilter;

import ex39recordSorter.Employee;
import ex39recordSorter.RecordSorter;
import java.util.ArrayList;

/**
 * Return all employee records whose first or last name match (completely or partially) the string provided.
 * For example, a search for "Jac" should return "Jacquelyn", "Jackie", "Applejack", etc.
 * Constraints:
 * Implement the data using an array of maps.
 * Created by Yasmin on 8/18/2017
 */

public class RecordFilter {

    ArrayList<Employee> employees;

    public RecordFilter(ArrayList<Employee> employees){
        this.employees = employees;
    }

    public StringBuilder find(String whatToSearch){

        StringBuilder sb = new StringBuilder();
        RecordSorter rs = new RecordSorter();

        sb.append(rs.getHeader());

        for(Employee employee : employees){
            if(employee.getFullName().toLowerCase().contains(whatToSearch.toLowerCase())){
                sb.append(rs.getEmployeeData(employee));
            }
        }
        return sb;
    }
}
