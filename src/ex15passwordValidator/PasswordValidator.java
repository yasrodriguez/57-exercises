package ex15passwordValidator;
import java.util.Scanner;

/**Prompt the user for a username and password. Verify if the password matches one of the stored
 * passwords. If it does, display a welcome message; if it doesn't, display a message that you don't know them.
 * Created by Yasmin on 7/4/2017.
 */
public class PasswordValidator
{
    private String [] passwords;
    private String passwordEntered;

    private PasswordValidator()
    {
        passwords = new String[5];
        passwords [0] = "welcome";
        passwords [1] = "12345";
        passwords [2] = "pie";
        passwords [3] = "hello";
        passwords [4] = "washington";
        passwordEntered = "";
    }

    public void prompt()
    {
        Scanner s = new Scanner(System.in);

        print ("Username: ");
        s.next();
        print("Password: ");
        passwordEntered = s.next();
    }

    private void validateLogin()
    {
        boolean found = false;
        for (int i = 0; i < passwords.length && ! found; i++ )
        {
            if(passwordEntered.equals(passwords[i]))
            {
                found = true;
                welcomeUser();
            }
        }
        if (! found)
        {
            rejectUser();
        }
    }

    private void welcomeUser()
    {
        print ("Welcome!");
    }

    private void rejectUser()
    {
        print("Sorry, I don't know you.");
    }

    private void print(String message)
    {
        System.out.println(message);
    }

    public static void execute()
    {
        PasswordValidator pv = new PasswordValidator();
        pv.prompt();
        pv.validateLogin();
    }
}
