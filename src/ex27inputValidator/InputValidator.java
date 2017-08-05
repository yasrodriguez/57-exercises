package ex27inputValidator;

import java.util.IllegalFormatException;

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

    private String firstName;
    private String lastName;
    private String employeeId;
    private String zipCode;
    private String errorMessage;

    public InputValidator(String firstName, String lastName, String employeeId, String zipCode){

        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.zipCode = zipCode;
        errorMessage = "";
    }


    public String validateInput(){
            if (isNotNullOrEmpty(firstName)) {
                isValidLength(firstName);
            }
            if(isNotNullOrEmpty(lastName)) {
                isValidLength(lastName);
            }
            return errorMessage;
    }

    private void isValidLength(String name) {
        if (name.length() < 2) {
            errorMessage += "First name nor last name can't be shorter than 2 characters.\n";
        }
    }

        private boolean isNotNullOrEmpty(String value){
            if(value == null || value.isEmpty()) {
                errorMessage += "Blank or null values are not allowed.\n";
                return false;
             }
             return true;
        }
    }

