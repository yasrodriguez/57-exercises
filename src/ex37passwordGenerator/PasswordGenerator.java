package ex37passwordGenerator;
import java.util.Random;

/**
 * Generate a secure password using the length, number of special characters and numbers provided.
 * Constraints:
 * Use lists to store the characters to use to generate passwords
 * Add some randomness to the password generation.
 * Created by Yasmin on 8/14/2017
 */

public class PasswordGenerator {
    private int desiredLength;
    private int numberOfSpecialCharacters;
    private int numberOfNumbers;
    private String password;
    private static final char[] specialCharacters = {'!', '@', '#', '$', '%', '^', '&', '*', '+', '?'};
    private static char[] numbers = new char[10];
    private static final char[] letters = new char[52];

    public PasswordGenerator(int passwordLength, int numberOfSpecialCharacters, int numberOfNumbers) {
        this.desiredLength = passwordLength;
        this.numberOfSpecialCharacters = numberOfSpecialCharacters;
        this.numberOfNumbers = numberOfNumbers;
        password = "";
        initializeNumbers();
        initializeLetters();
    }

    private static void initializeNumbers() {
        int unicode = (int) ('0');

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (char) unicode;
            unicode++;
        }
    }

    private static void initializeLetters() {

        int unicode = (int) ('A');
        int letterCounter;

        for (letterCounter = 0; letterCounter < letters.length && unicode <= (int) ('Z'); letterCounter++) {
            letters[letterCounter] = (char) unicode;
            unicode++;
        }

        unicode = (int) ('a');

        for (; letterCounter < letters.length && unicode <= (int) ('z'); letterCounter++) {
            letters[letterCounter] = (char) unicode;
            unicode++;
        }
    }

    public String buildPassword() {
        addLetters();
        addNumbers();
        addSpecialCharacters();
        return password;
    }

    private void addNumbers() {
        Random random = new Random();

        for (int i = 1; i <= numberOfNumbers && passwordLengthIsValid(); i++) {
            password += numbers[random.nextInt(numbers.length)];
        }
    }

    private void addSpecialCharacters() {
        Random random = new Random();

        for (int i = 1; i <= numberOfSpecialCharacters && passwordLengthIsValid(); i++) {
            password += specialCharacters[random.nextInt(specialCharacters.length)];
        }
    }

    private void addLetters() {
        Random random = new Random();
        int numberOfLetters = desiredLength - numberOfSpecialCharacters - numberOfNumbers;

        for (int i = 1; i <= numberOfLetters && passwordLengthIsValid(); i++) {
            password += letters[random.nextInt(letters.length)];
        }
    }

    private boolean passwordLengthIsValid() {
        return password.length() < desiredLength;
    }
}


