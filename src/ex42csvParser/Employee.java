package ex42csvParser;

/**
 * Employee for the CSV parser.
 * Created by Yasmin on 8/21/2017
 */

public class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(String lastName, String firstName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String toString(){
        return lastName + " " + firstName + " " + salary;
    }
}
