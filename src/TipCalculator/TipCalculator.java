package TipCalculator;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Program prompts for the bill amount and tip percentage and returns the calculated tip and total bill.
 */
public class TipCalculator {

    private double tipRate;
    private double billAmount;
    private double tip;
    private double total;

    public TipCalculator() {
        tipRate = 0;
        billAmount = 0;
        tip = 0;
        total= 0;
    }

    public TipCalculator(double tip, double bill){
        tipRate = tip/100;
        billAmount = bill;
    }

    private void getBillAmount() {
        Scanner s = new Scanner(System.in);
        System.out.print("What is the bill amount: ");
        billAmount = Double.parseDouble(s.nextLine());
    }

    private void getTipRate() {
        Scanner s = new Scanner(System.in);
        System.out.print("What is the tip percentage: ");
        tipRate = Double.parseDouble(s.nextLine()) / 100;
    }

    private void calculateTotals(){
        tip = billAmount * tipRate;
        total = billAmount + tip;
    }

    private void printTotals () {
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("Total tip: %s %n", currency.format(tip));
        System.out.printf("Total amount: %s %n", currency.format(total));
    }

    public void calculateTip(){
        calculateTotals();
        printTotals();
    }

    public static void execute () {

        TipCalculator calc = new TipCalculator();
        calc.getBillAmount();
        calc.getTipRate();
        calc.calculateTip();
    }
}
