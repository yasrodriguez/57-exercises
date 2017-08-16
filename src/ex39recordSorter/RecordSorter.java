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

    public static void print(ArrayList<Employee> list){
        //TODO: Fix printf so columns are aligned properly
        System.out.printf("%-25s|%-15s|%-12s", "Name", "Position", "Separation Date\n");
        for(Employee employee : list){
            System.out.printf("%-25s|%-15s|%-12s", employee.getFirstName() + " " + employee.getLastName(),
                    employee.getPosition(), employee.getSeparationDate() + "\n");
        }
    }
}
