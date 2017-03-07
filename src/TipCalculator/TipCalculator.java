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

    public TipCalculator() {
        tipPercent = 0;
        billAmount = 0;
        tipAmount = 0;
        total= 0;
    }

    public TipCalculator(double tipRate, double bill){
        tipPercent = tipRate/100;
        billAmount = bill;
        tipAmount = 0;
        total = 0;
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
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("Total tip: %s %n", currency.format(tipAmount));
        System.out.printf("Total amount: %s %n", currency.format(total));
    }

    public static void execute () {

        TipCalculator calc = new TipCalculator();
        calc.getBillAmountAndTipRate();
        calc.calculateAndPrintTotals();
    }
}
