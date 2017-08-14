package ex37passwordGenerator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for Password Generator.
 * Created by Yasmin on 8/14/17
 */
public class PasswordGeneratorTest {

    @Test
    public void test_happy_path() throws Exception {
        //arrange
        int passwordLength = 8;
        int numberOfSpecialCharacters = 3;
        int numberOfNumbers = 2;
        int numberOfLetters;
        if(passwordLength - numberOfSpecialCharacters - numberOfNumbers > 0) {
            numberOfLetters = passwordLength - numberOfSpecialCharacters - numberOfNumbers;
        }
        else{
            numberOfLetters = 0;
        }

        PasswordGenerator pg = new PasswordGenerator(passwordLength, numberOfSpecialCharacters, numberOfNumbers);

        //act
        String generatedPassword = pg.buildPassword();

        //assert
        assertTrue(passwordMeetsCriteria(generatedPassword, passwordLength, numberOfSpecialCharacters, numberOfNumbers,
                numberOfLetters));
    }

    @Test
    public void test_all_0s_returns_a_blank_password() throws Exception {
        //arrange
        int passwordLength = 0;
        int numberOfSpecialCharacters = 0;
        int numberOfNumbers = 0;
        int numberOfLetters;
        if(passwordLength - numberOfSpecialCharacters - numberOfNumbers > 0) {
            numberOfLetters = passwordLength - numberOfSpecialCharacters - numberOfNumbers;
        }
        else{
            numberOfLetters = 0;
        }

        PasswordGenerator pg = new PasswordGenerator(passwordLength, numberOfSpecialCharacters, numberOfNumbers);

        //act
        String generatedPassword = pg.buildPassword();

        //assert
        assertTrue(passwordMeetsCriteria(generatedPassword, passwordLength, numberOfSpecialCharacters, numberOfNumbers,
                numberOfLetters));
    }

    @Test
    public void test_incorrect_length_returns_only_numbers() throws Exception {
        //arrange
        int passwordLength = 5;
        int numberOfSpecialCharacters = 8;
        int numberOfNumbers = 5;
        int numberOfLetters;
        if(passwordLength - numberOfSpecialCharacters - numberOfNumbers > 0) {
            numberOfLetters = passwordLength - numberOfSpecialCharacters - numberOfNumbers;
        }
        else{
            numberOfLetters = 0;
        }

        PasswordGenerator pg = new PasswordGenerator(passwordLength, numberOfSpecialCharacters, numberOfNumbers);

        //act
        String generatedPassword = pg.buildPassword();

        //assert
        assertTrue(passwordMeetsCriteria(generatedPassword, passwordLength, numberOfSpecialCharacters, numberOfNumbers,
                numberOfLetters));
    }

    @Test
    public void test_incorrect_length_returns_only_numbers_and_specialChars() throws Exception {
        //arrange
        int passwordLength = 8;
        int numberOfSpecialCharacters = 8;
        int numberOfNumbers = 5;
        int numberOfLetters;
        if(passwordLength - numberOfSpecialCharacters - numberOfNumbers > 0) {
            numberOfLetters = passwordLength - numberOfSpecialCharacters - numberOfNumbers;
        }
        else{
            numberOfLetters = 0;
        }

        PasswordGenerator pg = new PasswordGenerator(passwordLength, numberOfSpecialCharacters, numberOfNumbers);

        //act
        String generatedPassword = pg.buildPassword();

        //assert
        assertTrue(passwordMeetsCriteria(generatedPassword, passwordLength, numberOfSpecialCharacters, numberOfNumbers,
        numberOfLetters));
    }

    /* I extracted this method from exercise #25 (and made a couple of changes) to validate that the randomly
    generated password meets the criteria provided to the password generator */

    private boolean passwordMeetsCriteria(String password, int passwordLength, int numberOfSpecialCharacters,
                                   int numberOfNumbers, int numberOfLetters) {

        //To adjust the number of desired characters per type to the actual allowable, per the password length
       int actualNumbers = numberOfNumbers < passwordLength ? numberOfNumbers: passwordLength;
       int actualSpecialChars = numberOfSpecialCharacters < (passwordLength - actualNumbers) ?
               numberOfSpecialCharacters : (passwordLength - actualNumbers);
       int actualLetters = numberOfLetters < (passwordLength - actualNumbers - actualSpecialChars) ?
               numberOfLetters : (passwordLength - actualNumbers - actualSpecialChars);

        int digits = 0 ;
        int specialCharacters = 0;
        int letters = 0;


        for (int i = 0; i < password.length(); i++) {

            int unicode = (int) (password.charAt(i));

            if (unicode >= 48 && unicode <= 57) {
                digits++;
            } else if (unicode >= 65 && unicode <= 90 || unicode >= 97 && unicode <= 122) {
                letters++;
            } else if (unicode >= 32 && unicode <= 47 || unicode >= 58 && unicode <= 64 ||
                    unicode >= 91 && unicode <= 96 || unicode >= 91 && unicode <= 126) {
                specialCharacters++;
            }
        }

        int calculatedPasswordLength = password.length();

        return specialCharacters == actualSpecialChars && digits == actualNumbers && letters ==  actualLetters
                && passwordLength == calculatedPasswordLength;
    }
}