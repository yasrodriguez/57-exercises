package SelfCheckout;
import java.util.Scanner;

/**
 * Prompt for the price and quantity for 3 items.  Calculate and print the
 * subtotal, tax, and total. Assume a 5.5% tax.
 * Created by Yasmin on 6/22/2017.
 */

public class SelfCheckout
{
    private double subtotal;
    private double taxAmount;
    private double total;
    private double itemCount;
    private final static double TAX_RATE = 5.5;

    private SelfCheckout()
    {
        subtotal = 0;
        taxAmount = 0;
        total = 0;
        itemCount = 0;
    }

    private void prompt()
  {
      Scanner s = new Scanner(System.in);
      double price;
      double qty;
      double extendedPrice;

      for (int i = 1; i <= 3; i++)
      {
          print("Enter the price of item " + i + " :");
          price = s.nextDouble();

          print("Enter the quantity of item " + i + " :");
          qty = s.nextDouble();


          extendedPrice = price * qty;
          subtotal += extendedPrice;

          itemCount += qty;

      }

  }

  private void calculateTaxAndTotal()
  {
    total = subtotal + taxAmount;
  }

  private void printResults()
  {
      print("Number of items: " + itemCount);
      printCurrency("Subtotal: %.2f \n" , subtotal);
      printCurrency("Tax: %.2f \n" , taxAmount);
      printCurrency("Total: %.2f \n" , total);
  }

  private void print(String message)
  {
       System.out.println(message);
  }

  private void printCurrency(String message, double amount)
  {
      System.out.printf(message, amount);
  }

  public static void execute()
  {
      SelfCheckout checkout = new SelfCheckout();
      checkout.prompt();
      checkout.calculateTaxAndTotal();
      checkout.printResults();
  }

}
