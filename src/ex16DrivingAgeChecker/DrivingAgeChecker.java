package ex16DrivingAgeChecker;
import java.util.Scanner;

/**
 * Ask for a person's age and compare to the legal driving age (16 in the US). If the user is the legal driving age
 * or older display a message that they can drive. If the user is under the legal driving age display a message that
 * they can't drive.
 * Created by Yasmin on 7/5/2017.
 */
public class DrivingAgeChecker
{
    private int age;
    private boolean canDrive;
    private final static int LEGAL_DRIVING_AGE = 16;

    private DrivingAgeChecker()
    {
        age = 0;
        initialize();
    }

    DrivingAgeChecker(int age)
    {
        this.age = age;
        initialize();
    }

    private void initialize()
    {
        canDrive = false;
    }

    private void prompt()
    {
        Scanner s = new Scanner(System.in);
        print("What is your age?");
        age = s.nextInt();
    }

    void checkAge()
    {
        canDrive = age >= LEGAL_DRIVING_AGE;
        printResult();
    }

    private void printResult()
    {
        String message = canDrive ? "Congratulations, you are old enough to legally drive." : "Sorry, you are not old enough " +
                "to legally drive.";
        print(message);
    }

    private void print(String message)
    {
        System.out.println(message);
    }

    public static void execute()
    {
        DrivingAgeChecker ageChecker = new DrivingAgeChecker();
        ageChecker.prompt();
        ageChecker.checkAge();
    }

}
