package CompoundInterestCalculator;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Compute the value of an investment compounded over time. Prompt for amount, years to invest, interest rate,
 * and periods per year to compound.
 * Created by Yasmin on 6/30/2017.
 */
public class CompoundInterestCalculator
{
    private double amount;
    private double rate;
    private int years;
    private int numberOfCompoundingsPerYear;
    private BigDecimal totalAmount;

    public CompoundInterestCalculator()
    {
        amount = 0;
        rate = 0;
        years = 0;
        numberOfCompoundingsPerYear = 0;
        initialize();
    }

    public CompoundInterestCalculator(double amount, double rate, int years, int numberOfCompoundingsPerYear)
    {
        this.amount = amount;
        this.rate = rate/100;
        this.years = years;
        this.numberOfCompoundingsPerYear = numberOfCompoundingsPerYear;
        initialize();
    }

    private void initialize()
    {
        totalAmount = new BigDecimal(0);
    }

    private void prompt()
    {
        Scanner s = new Scanner(System.in);
        print("Enter principal amount:");
        amount = s.nextDouble();
        print("Enter interest rate:");
        rate = s.nextDouble()/100;
        print("Enter number of years:");
        years = s.nextInt();
        print("Enter number of times the interest is compounded per year:");
        numberOfCompoundingsPerYear = s.nextInt();
    }

    private void calculate()
    {
        totalAmount = BigDecimal.valueOf(amount *
                Math.pow((1 + rate / numberOfCompoundingsPerYear),numberOfCompoundingsPerYear*years)).setScale(2,BigDecimal.ROUND_CEILING);
    }

    private void printResults()
    {
        print(totalAmount.toString());

    }

    private void print(String message)

    {
        System.out.println(message);
    }

    public static void execute()
    {
        CompoundInterestCalculator calc = new CompoundInterestCalculator();
        calc.prompt();
        calc.calculate();
        calc.printResults();
    }
}
