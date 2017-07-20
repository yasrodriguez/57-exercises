package ex20multiStateSalesTaxCalculator;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Prompt for the order amount and state where order will be shipped. Calculate tax as follows:
 * Wisconsin - 5.5%. For Eau Claire and Dunn counties, add .5% and .4%, respectively.
 * Illinois - 8%
 * All other states - No tax.
 * Display total. Display tax amount only for Illinois and Wisconsin.
 * Created by Yasmin on 7/19/2017.
 */
public class SalesTaxCalculator
{
    private BigDecimal orderAmount;
    private BigDecimal totalTax;
    private String state;
    private String county;
    private static final BigDecimal WI_EAU_CLAIRE_TAX = new BigDecimal(.005);
    private static final BigDecimal WI_DUNN_TAX = new BigDecimal(.004);
    private static final BigDecimal WI_TAX = new BigDecimal(.055);
    private static final BigDecimal IL_TAX = new BigDecimal(.08);

    public SalesTaxCalculator()
    {
        orderAmount = new BigDecimal(0);
        totalTax = new BigDecimal(0);
        state = "";
        county = "";
    }

    public SalesTaxCalculator (BigDecimal orderAmount,String state, String county)
    {
        this.orderAmount = orderAmount;
        this.state = state;
        this.county = county;
        totalTax = new BigDecimal(0);
    }

    private void prompt()
    {
        Scanner s = new Scanner(System.in);

        print("Enter order amount: ");
        if (s.hasNextBigDecimal())
        {
            orderAmount = s.nextBigDecimal();
        }

        print("Enter shipping state: ");
        state = s.next();

        if (state.equals("WI"))
        {
            print("Please enter county: ");
            s = new Scanner(System.in); //to avoid empty string in nextLine
            county = s.nextLine();
        }
    }

    private void calculateTax()
    {
        if (state.equals("WI"))
        {
            totalTax = orderAmount.multiply(WI_TAX);

            if (county.equals("Eau Claire"))
            {
                totalTax = totalTax.add(orderAmount.multiply(WI_EAU_CLAIRE_TAX));
            } else if (county.equals("Dunn"))
            {
                totalTax = totalTax.add(orderAmount.multiply(WI_DUNN_TAX));
            }
        }
        else if (state.equals("IL"))
            {
                totalTax = orderAmount.multiply(IL_TAX);
            }
        }


    private BigDecimal calculateTotal()
    {
        return orderAmount.add(totalTax);
    }

    private void printResults()
    {
        String result = String.format("The total is %.2f.%n", calculateTotal());

        if (state.equals("WI") || state.equals("IL"))
        {
            result = String.format("The tax is %.2f.%n", totalTax) + result;
        }

        print (result);
    }

    private void print(String message)
    {
        System.out.print(message);
    }

    public static void execute()
    {
        SalesTaxCalculator stc = new SalesTaxCalculator();
        stc.prompt();
        stc.calculateTax();
        stc.calculateTotal();
        stc.printResults();
    }


}
