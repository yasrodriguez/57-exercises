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

    private ArrayList<Employee> employees = new ArrayList<>();

    public void readFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            if (! br.ready()) {
                throw new IllegalArgumentException("The file can't be empty.");
            }

            String line;

            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] parsedLine = line.split(",");

                String lastName = parsedLine[0];
                String name = parsedLine[1];
                double salary = Double.valueOf(parsedLine[2]);

                Employee emp = new Employee(lastName, name, salary);
                employees.add(emp);
            }
        }
    }

    public String getEmployeeReport(){
        StringBuilder sb = new StringBuilder();

        //TODO: Make each field one space longer than the longest string
        //TODO: Add commas to the salary
        for (Employee e : employees) {
            sb.append(String.format("%-15s %-15s $%7.2f\n", e.getLastName(), e.getFirstName(), e.getSalary()));
        }

        return sb.toString();
    }
}

