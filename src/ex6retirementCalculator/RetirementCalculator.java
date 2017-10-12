package ex6retirementCalculator;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * Calculate how many years are left until retirement and the year of
 * retirement. Use a time function to get the current year.
 * Created by Yasmin on 6/13/2017.
 */
public class RetirementCalculator {

    private void calculateRetirement() {
        Scanner s = new Scanner(System.in);
        System.out.print("What is your current age? ");
        int age = s.nextInt();
        System.out.print("At what age would you like to retire? ");
        int retirementAge = s.nextInt();
        int yearsUntilRetirement = retirementAge - age;
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();
        int retirementYear = currentYear + yearsUntilRetirement;
        System.out.println ("You have " + yearsUntilRetirement + " years until you can retire.");
        System.out.println ("It's " + currentYear + " so you can retire in " + retirementYear);
    }

    public static void execute(){
        RetirementCalculator calc = new RetirementCalculator();
        calc.calculateRetirement();
    }
}
