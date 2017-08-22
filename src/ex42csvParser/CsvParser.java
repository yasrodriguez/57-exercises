package ex42csvParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.util.Comparator.comparing;

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

        int columnWidthLastName = getMaximumFieldLength("LastName") + 1;
        int columnWidthFirstName = getMaximumFieldLength("FirstName") + 1;
        int columnWidthSalary = getMaximumFieldLength("Salary") + 2;

        for (Employee e : employees) {
            sb.append(String.format("%-"+ columnWidthLastName + "s" + "%-" + columnWidthFirstName + "s" +
                    "$%," + columnWidthSalary + ".2f%n", e.getLastName(), e.getFirstName(), e.getSalary()));
        }
        return sb.toString();
    }

    public int getMaximumFieldLength(String fieldName) {
        switch(fieldName){
            case "LastName":{
                return employees.stream().max(comparing(Employee::getLastNameLength)).get().getLastNameLength();
            }
            case "FirstName":{
                return employees.stream().max(comparing(Employee::getFirstNameLength)).get().getFirstNameLength();
            }
            case "Salary":{
                return employees.stream().max(comparing(Employee::getSalaryLength)).get().getSalaryLength();
            }
            default:{
                return 0;
            }
        }
    }
}


