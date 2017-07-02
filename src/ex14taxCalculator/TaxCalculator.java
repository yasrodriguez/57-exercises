package ex14taxCalculator;

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

    private TaxCalculator()
    {
        orderAmount = 0;
        state = "";
        initialize();
    }

    public TaxCalculator(double orderAmount, String state)
    {
        this.orderAmount = orderAmount;
        this.state = state;
        initialize();
    }

    private void initialize()
    {
        orderTotal = 0;
    }

    private void prompt()
    {
        Scanner s = new Scanner(System.in);
        print("What is the order amount? ");
        orderAmount = s.nextDouble();
        print("What is the state? ");
        state = s.next();
    }

    private void calculate()
    {
        if (state.equals("WI"))
        {
            double tax = orderAmount * WI_TAX_RATE;
            orderTotal = orderAmount + tax;
            printDetail(tax);
        }
        else
        {
            orderTotal = orderAmount;
            printTotal();
        }

    }

    private void printDetail(double tax)
    {
        System.out.printf("The subtotal is $%.2f. %n", orderAmount);
        System.out.printf("The tax is $%.2f. %n", tax);
        printTotal();
    }

    private void printTotal()
    {
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
    }

}
