package ex19bmiCalculator;
import java.util.Scanner;

/**
 * Calculate the body mass index (BMI) for a person using the person’s height in inches and weight in pounds.
 * Created by Yasmin on 7/14/2017.
 */
public class BMICalculator
{
    private double weight;
    private double height;
    private Scanner s;

    public BMICalculator()
    {
        weight = 0;
        height = 0;
        s = new Scanner (System.in);
    }

    public BMICalculator(String weight, String height)
    {
       // this.weight = weight;
        //this.height = height;
    }

    private void prompt()
    {
        print("Enter your weight: ");
        this.weight = ifNumber();
        print("Enter your height (in inches): ");
        this.height = ifNumber();
    }

    private double ifNumber()
    {
        if (s.hasNextDouble())
        {
            return Double.parseDouble(s.next());
        }
        throw new NumberFormatException();
    }

    private static void print (String message)
    {
        System.out.println(message);
    }

    public static void execute()
    {
        BMICalculator bmiCalc = new BMICalculator();
        bmiCalc.prompt();
    }

}
