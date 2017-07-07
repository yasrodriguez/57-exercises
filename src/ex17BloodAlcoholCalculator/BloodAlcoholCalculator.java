package ex17BloodAlcoholCalculator;
import java.util.Scanner;

/**
 * Calculate the Blood Alcohol Content (BAC).  Prompt for weight, gender, number of drinks, amount of alcohol by volume
 * of drinks consumed, and amount of time since the last drink.
 * Reference: http://www.teamdui.com/bac-widmarks-formula/
 * Created by Yasmin on 7/6/2017.
 */
public class BloodAlcoholCalculator
{
    private Scanner s;
    private double weight;
    private String gender;
    private double ouncesOfAlcoholicBeveragesConsumed;
    private double alcoholPercentageByVolume;
    private double hoursSinceDrinkingStarted;
    private double bac;
    private final static double ALCOHOL_DISTRIBUTION_RATIO_MEN = .73;
    private final static double ALCOHOL_DISTRIBUTION_RATIO_WOMEN = .66;

    private BloodAlcoholCalculator()
    {
        s = new Scanner(System.in);
        weight = 0;
        gender = "";
        ouncesOfAlcoholicBeveragesConsumed = 0;
        alcoholPercentageByVolume = 0;
        hoursSinceDrinkingStarted = 0;
        bac = 0;
    }
    private void prompt()
    {
        print("Enter weight: ");
        weight = isNumber();

        print("Enter gender: ");
        gender = s.next();

        print("Enter total ounces of alcoholic beverages consumed: ");
        ouncesOfAlcoholicBeveragesConsumed = isNumber();

        print("Enter alcohol % by volume: ");
        alcoholPercentageByVolume = isNumber() /100;

        print("Enter number of hours since last drink: ");
        hoursSinceDrinkingStarted = isNumber();
    }

    private double isNumber()
    {
        while (!s.hasNextDouble())
        {
            print("You must enter a number. Please try again.");
            s.next();
        }
        return s.nextDouble();
    }

    private void calculate()
    {
        double alcoholConsumed = ouncesOfAlcoholicBeveragesConsumed * alcoholPercentageByVolume;
        bac = alcoholConsumed * 5.14 / weight * getDistributionRatio() - .015 * hoursSinceDrinkingStarted;
    }

    private void printResults()
    {
        print("Your BAC is " + bac);
    }

    private double getDistributionRatio()
    {
        if (gender.equals("M"))
        {
            return ALCOHOL_DISTRIBUTION_RATIO_MEN;
        }
        else if (gender.equals("F"))
        {
            return ALCOHOL_DISTRIBUTION_RATIO_WOMEN;
        }
        else
        {
            return 0;
        }
    }

    private void print(String message)
    {
        System.out.println(message);
    }

    public static void execute()
    {
        BloodAlcoholCalculator bac = new BloodAlcoholCalculator();
        bac.prompt();
        bac.calculate();
        bac.printResults();
    }

}
