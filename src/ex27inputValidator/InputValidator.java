package ex27inputValidator;

/**
 * Take a first name, last name, employee ID, and zip code. Use the following rules to validate the input and display
 * relevant error messages when input does not meet the rules.
 * 1. First name must be filled in
 * 2. Last name must be filled in
 * 3. First and last name must be at least 2 characters long
 * 4. Employee ID follows the format two letters, hyphen, and four numbers like AA-1234
 * 5. Zip code must be a number
 * Constraints:
 * Create a function for each type of validation.
 * Create a validateInput function that examines all input and calls the necessary functions.
 * Created by Yasmin on 8/4/2017
 */

public class InputValidator {

    public static void validateInput(String firstName, String lastName, String employeeId, String zipCode){
        try {
            validateName(firstName);
            validateName(lastName);
        }
        catch(NullPointerException nullPointer)
        {
            System.err.println(nullPointer);
        }
    }

    private static void validateName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("First name nor last name can't be blank.");
        }
        if(name.length() < 2){
            throw new IllegalArgumentException("First name nor last name can't be shorter than 2 characters.");
        }
    }
}
