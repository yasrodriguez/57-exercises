package SimpleInterestCalculator;

import java.math.*;
import java.util.Scanner;

/**
 * Prompt for the principal, rate, and time. Calculate the simple interest and display the amount accrued.
 * Created by Yasmin on 6/27/2017.
 */
public class SimpleInterestCalculator
{
    private double principal;
    private double rate;
    private int years;
    private BigDecimal totalAccrued;

    public SimpleInterestCalculator()
    {
        principal = 0;
        rate = 0;
        years = 0;
        initialize();
    }

    public SimpleInterestCalculator(double principal, double rate, int years)
    {
        this.principal = principal;
        this.rate = rate;
        this.years = years;
        initialize();
    }

    private void initialize()
    {
        totalAccrued = new BigDecimal(0);
    }

    private void prompt()
    {
        Scanner s = new Scanner(System.in);

        print("Enter the principal: ");
        principal = s.nextDouble();

        print("Enter the rate of interest: ");
        rate = s.nextDouble();

        print("Enter the number of years: ");
        years = s.nextInt();
    }

    void calculate()
    {
        totalAccrued = BigDecimal.valueOf(principal * (1 + rate/100 * years)).setScale(2,BigDecimal.ROUND_CEILING);
    }

    private void printResult()
    {
        print("After " + years + " years at " + rate + "%, the investment will be worth $" + totalAccrued +".");
    }

    public BigDecimal getTotalAccrued()
    {
        return totalAccrued.setScale(2, BigDecimal.ROUND_CEILING);
    }
    private void print(String message)
    {
        System.out.println(message);
    }

    public static void execute()
    {
        SimpleInterestCalculator si = new SimpleInterestCalculator();
        si.prompt();
        si.calculate();
        si.printResult();
    }

}

