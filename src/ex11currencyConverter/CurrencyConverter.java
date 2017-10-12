package ex11currencyConverter;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Prompt for amount in euros and current exchange rate to US dollars.  * Print the converted amount in US dollars.
 * Round fractions of a cent to the next penny.
 * Created by Yasmin on 6/25/2017.
 */

public class CurrencyConverter
{
    private double euroAmount;
    private double exchangeRate;
    private BigDecimal convertedAmount;

    private CurrencyConverter()
    {
        euroAmount = 0;
        exchangeRate = 0;
        initialize();
    }

    public CurrencyConverter(double euroAmount, double exchangeRate)
    {
        this.euroAmount = euroAmount;
        this.exchangeRate = exchangeRate;
        initialize();
    }

    private void initialize()
    {
        convertedAmount = new BigDecimal(0);
    }

    private void prompt()
    {
        Scanner s = new Scanner(System.in);

        print("How many euros do you want to exchange?");
        euroAmount = s.nextDouble();

        print("What is the exchange rate to USD?");
        exchangeRate = s.nextDouble();

    }

    void convertToUSD()
    {
        convertedAmount = BigDecimal.valueOf(euroAmount * exchangeRate).setScale(2,BigDecimal.ROUND_CEILING);
    }

    private void printResult()
    {
        print(euroAmount + " at an exchange rate of " + exchangeRate + " is " + convertedAmount.toString() +
                " U.S. dollars.");
    }

    private void print(String message)
    {
        System.out.println(message);
    }

    public BigDecimal getConvertedAmount()
    {
        return convertedAmount;
    }

    public static void execute()
    {
        CurrencyConverter cc = new CurrencyConverter();
        cc.prompt();
        cc.convertToUSD();
        cc.printResult();
    }
}
