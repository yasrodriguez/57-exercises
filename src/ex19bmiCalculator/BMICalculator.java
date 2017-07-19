package ex19bmiCalculator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Calculate the body mass index (BMI) for a person using the person’s height in inches and weight in pounds.
 * Created by Yasmin on 7/14/2017.
 */
public class BMICalculator
{
    private Scanner s;
    private double weight;
    private double height;
    private double bmi;


    public BMICalculator()
    {
        s = new Scanner (System.in);
        weight = 0;
        height = 0;
        bmi = 0;
    }

    public BMICalculator(String weight, String height)
    {
        InputStream is = new ByteArrayInputStream(weight.getBytes());
        s = new Scanner (is);
        this.weight = ifNumber();
        is = new ByteArrayInputStream(height.getBytes());
        s = new Scanner(is);
        this.height = ifNumber();
        bmi = 0;
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
            throw new NumberFormatException("There is something wrong with your input. You must enter a number.");
        }

        void calculateBmi()
        {
            //round to one decimal place
            bmi = (double) Math.round((weight / (height * height ))* 703 * 10) / 10;

        }

        String evaluateBmi()
        {
            if (bmi < 18.5)
            {
                return String.format("Your BMI is %.1f.%nYou are underweight.", bmi);
            }
            else if (bmi >= 18.5 && bmi <=25)
            {
                return String.format("Your BMI is %.1f.%nYou are within the ideal weight range.", bmi);
            }
            else
            {
                return String.format("Your BMI is %.1f.%nYou are overweight.", bmi);
            }
        }

    private static void print (String message)
    {
        System.out.println(message);
    }

    public static void execute()
    {
        BMICalculator bmiCalc = new BMICalculator();
        bmiCalc.prompt();
        bmiCalc.calculateBmi();
        print(bmiCalc.evaluateBmi());
    }

}
