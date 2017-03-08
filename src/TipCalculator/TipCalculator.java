package TipCalculator;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Program prompts for  bill amount and tip percentage and returns calculated tip and total bill.
 */
public class TipCalculator {

    private double tipPercent;
    private double billAmount;
    private double tipAmount;
    private double total;
    private NumberFormat currency;

    public TipCalculator() {
        tipPercent = 0;
        billAmount = 0;
        tipAmount = 0;
        total= 0;
        currency = NumberFormat.getCurrencyInstance(Locale.US);
    }

    public TipCalculator(double tipRate, double bill){
        tipPercent = tipRate/100;
        billAmount = bill;
        tipAmount = 0;
        total = 0;
        currency = NumberFormat.getCurrencyInstance(Locale.US);
    }

    private void getBillAmountAndTipRate() {
        Scanner s = new Scanner(System.in);
        System.out.print("What is the bill amount: ");
        billAmount = Double.parseDouble(s.nextLine());
        System.out.print("What is the tip rate: ");
        tipPercent = Double.parseDouble(s.nextLine()) / 100;
    }

    public void calculateAndPrintTotals () {
        tipAmount = billAmount * tipPercent;
        total = billAmount + tipAmount;
        System.out.printf("Total tip: %s %n", getTipAmount());
        System.out.printf("Total amount: %s %n", getTotal());
    }

    public String getTipAmount(){
        return currency.format((tipAmount));
    }

    public String getTotal(){
        return currency.format((total));
    }

    public static void execute () {
        TipCalculator calc = new TipCalculator();
        calc.getBillAmountAndTipRate();
        calc.calculateAndPrintTotals();
    }
}
