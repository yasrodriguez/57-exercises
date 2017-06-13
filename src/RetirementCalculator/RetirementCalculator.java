package RetirementCalculator;
import java.util.Scanner;

/**
 * Calculate how many years are left until retirement and the year of
 * retirement. Use time functions to calculate the year of retirement.
 * Created by Yasmin on 6/13/2017.
 */
public class RetirementCalculator {

    private void calculateRetirement() {
        Scanner s = new Scanner(System.in);
        System.out.print("What is your current age? ");
        int age = s.nextInt();
        System.out.print("At what age would you like to retire? ");
        int retirementAge = s.nextInt();
        int yearUntilRetirement = retirementAge - age;
        System.out.print ("You have " + yearUntilRetirement + " years until you can retire.");
    }

    public static void execute(){
        RetirementCalculator calc = new RetirementCalculator();
        calc.calculateRetirement();
    }


}
