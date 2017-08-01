package ex25passwordValidator;

/**
 * Take in a given password and evaluate its complexity:
 *  Very weak - contains only numbers and has fewer than 8 characters
 *  Weak - contains only letters and has fewer than 8 characters
 *  Strong - contains letters, at least one number, and has at least 8 characters
 *  Very strong - contains letters, numbers, special characters, and is at least 8 characters
 * Constraints:
 *  Create a function that takes the password as an argument and returns a value (instead of a string) that you can
 *  evaluate to determine password strength.
 *  Do not use Regex or built-in functions to identify type of character.
 * Created by Yasmin on 7/31/2017
 */

public class PasswordValidator{

    private String password;
    private int letters;
    private int digits;
    private int specialCharacters;

    public PasswordValidator(String password){
        this.password = password;
        letters = 0;
        digits = 0;
        specialCharacters = 0;
    }

    enum PasswordStrength{

        VeryWeak, Weak, Medium, Strong, VeryStrong
    }

    public PasswordStrength validatePassword(){

        if(password == null || password.isEmpty()){
            throw new IllegalArgumentException("You can't have a blank password.");
        }

        int length = getLength();
        countCharactersByType();

        if (length >= 8 && letters > 0 && digits > 0 && specialCharacters > 0){
            return PasswordStrength.VeryStrong;
        }
        else if (length >= 8 && letters > 0 && digits > 0){
            return PasswordStrength.Strong;
        }
        else if (length < 8 && letters > 0 && digits == 0 && specialCharacters == 0 ){
            return PasswordStrength.Weak;
        }
        else if (length < 8 && digits > 0 && letters == 0 && specialCharacters == 0){
            return PasswordStrength.VeryWeak;
        }
        else{
            return PasswordStrength.Medium;
        }
    }

    private void countCharactersByType()
    {
        for(int i = 0; i < password.length(); i++) {

            int unicode = (int)(password.charAt(i));

            if(unicode >= 48 && unicode <= 57 ){
                digits++;
            }
            else if(unicode >= 65 && unicode <= 90 || unicode >= 97 && unicode <= 122){
                letters++;
            }
            else if(unicode >= 32 && unicode <= 47 || unicode >=58 && unicode <= 64 || unicode >=91 && unicode <= 96 ||
                    unicode >= 91 && unicode <= 126){
                specialCharacters++;
            }
        }
    }

    private int getLength(){
        return password.length();
    }
}
