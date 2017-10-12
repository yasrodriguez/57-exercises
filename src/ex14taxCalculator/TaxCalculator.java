package ex14taxCalculator;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Compute tax on an order. For Wisconsin (WI) residents, compute 5.5% tax and display subtotal, tax, and total.
 * For residents of other states, just display the total.
 * Created by Yasmin on 7/2/2017.
 */
public class TaxCalculator
{
    private double orderAmount;
    private String state;
    private final static double WI_TAX_RATE = .055;
    private double orderTotal;
    private double tax;

    private TaxCalculator()
    {
        orderAmount = 0;
        state = "";
        initialize();
    }

    public TaxCalculator(double orderAmount, String state, boolean testMode)
    {
        this.orderAmount = orderAmount;
        this.state = state;
        initialize();
    }

    private void initialize()
    {
        orderTotal = 0;
        tax = 0;
    }

    private void prompt()
    {
        Scanner s = new Scanner(System.in);
        print("What is the order amount? ");
        orderAmount = s.nextDouble();
        print("What is the state? ");
        state = s.next();
    }

    void calculate()
    {
        orderTotal = orderAmount;

        if (state.equals("WI"))
        {
            tax = orderAmount * WI_TAX_RATE;
            orderTotal = orderAmount + tax;
        }
    }

    void printResults()
    {
        if (state.equals("WI"))
        {
            System.out.printf("The subtotal is $%.2f.%nThe tax is $%.2f.%n", orderAmount, tax);
        }

         System.out.printf("The total is $%.2f.%n", orderTotal);
    }

    private void print(String message)
    {
        System.out.println(message);
    }

    public static void execute()
    {
        TaxCalculator calc = new TaxCalculator();
        calc.prompt();
        calc.calculate();
        calc.printResults();
    }
}
