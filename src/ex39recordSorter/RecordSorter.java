package ex39recordSorter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given the data set provided, create a program that sorts all records by last name and prints them to the screen in
 * tabular format.
 * Constraints:
 * Implement the data using a list of maps
 * Created by Yasmin on 8/16/2017
 */

public class RecordSorter {

    public static ArrayList<Employee> sort(ArrayList<Employee> list){
        Collections.sort(list);
        return list;
    }

    public static StringBuilder getReadyForPrinting(ArrayList<Employee> list){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-25s| %-30s| %s", "Name", "Position", "Separation Date\n"));
        sb.append("-----------------------------------------------------------------------------\n");

        for(Employee employee : list){
            sb.append(String.format("%-25s| %-30s| %s", employee.getFirstName() + " " + employee.getLastName(),
                    employee.getPosition(), (employee.getSeparationDate()== null ? "" : employee.getSeparationDate()) + "\n"));
        }

        return sb;
    }
}
