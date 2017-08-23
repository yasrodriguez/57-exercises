package ex42csvParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Parse a csv file and display the results formatted in a table.
 * Constraints:
 * Write your own code to parse the data; don't use a CSV parser.
 * Use spaces to align the columns.
 * Make each column one space longer than the longest value in the column.
 * Created by Yasmin on 8/21/2017
 */

public class CsvParser {

    public static ArrayList<Employee> readFile(String filename) throws IOException {
        ArrayList<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

           String line = br.readLine();

            while (line != null) {
                if(line.isEmpty()){
                    line = br.readLine();  //Handles empty lines in the middle of the file
                }
                else {
                    String[] parsedLine = line.split(",");

                    String lastName = parsedLine[0];
                    String name = parsedLine[1];
                    double salary = Double.valueOf(parsedLine[2]);

                    Employee emp = new Employee(lastName, name, salary);
                    employees.add(emp);

                    line = br.readLine();
                }
            }
        }
        return employees;
    }
}



