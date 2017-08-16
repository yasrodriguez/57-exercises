package ex39recordSorter;

import java.time.LocalDate;

/**
 * Employee class for the Record Sorter program.
 * Created by Yasmin on 8/16/2017
 */

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private String position;
    private LocalDate separationDate;

    public Employee(String firstName, String lastName, String position, LocalDate separationDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.separationDate = separationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public LocalDate getSeparationDate() {
        return separationDate;
    }

    @Override
   public String toString(){
        return getClass().getSimpleName() + '[' + firstName + ", " + lastName + ", " + position + ", " + separationDate + ']';
   }

   @Override
    public int compareTo(Employee employee){
        return this.lastName.compareTo(employee.lastName);
   }
}
