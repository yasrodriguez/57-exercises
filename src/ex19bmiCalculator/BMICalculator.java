package ex19bmiCalculator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculate the body mass index (BMI) for a person using the person’s height in inches and weight in pounds.
 * Created by Yasmin on 7/14/2017.
 */
public class BMICalculator
{
    private double weight;
    private double height;
    private double bmi;
    private final static double BMI_UNDERWEIGHT = 18.5;
    private final static double BMI_OVERWEIGHT = 25;


    public BMICalculator(double weight, double height)
    {
        checkNot0(weight);
        checkNot0(height);
        this.weight = weight;
        this. height = height;
        bmi = 0;
    }

    private void checkNot0(double input)
    {
            if(input==0)
            {
                throw new NumberFormatException("Input can't be 0.");
            }
    }

    void calculateBmi()
    {
        bmi = (double) Math.round((weight / (height * height)) * 703 * 10) / 10;
    }

    String evaluateBmi()
    {
        if (bmi < BMI_UNDERWEIGHT)
        {
            return String.format("Your BMI is %.1f.%nYou are underweight.", bmi);
        }
        else if (bmi >= BMI_UNDERWEIGHT && bmi <=BMI_OVERWEIGHT)
        {
            return String.format("Your BMI is %.1f.%nYou are within the ideal weight range.", bmi);
        }
        else
        {
            return String.format("Your BMI is %.1f.%nYou are overweight.", bmi);
        }
    }
}
