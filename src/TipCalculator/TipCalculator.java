package TipCalculator;
import java.io.*;
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
    public boolean testMode;
    private String tipPercentTest;
    private String billAmountTest;
    private String warning;

    public TipCalculator() {
        tipPercent = 0;
        billAmount = 0;
        tipAmount = 0;
        total= 0;
        currency = NumberFormat.getCurrencyInstance(Locale.US);
        testMode = false;
        warning = "";
    }

    public TipCalculator(String tipRateTest, String billTest){
        tipPercentTest = tipRateTest;
        billAmountTest = billTest;
        tipAmount = 0;
        total = 0;
        currency = NumberFormat.getCurrencyInstance(Locale.US);
        testMode = true;
        warning = "";
    }

    public void getBillAmountAndTipRate() {
        if(testMode){
            InputStream billTest = new ByteArrayInputStream(billAmountTest.getBytes());
            System.setIn (billTest);
            System.out.print (System.in);
        }
        else {

            System.out.print("What is the bill amount: ");
        }
        boolean done = false;
        Scanner s = new Scanner(System.in);
        while (! done) {
            if (s.hasNextDouble()){
                billAmount = Double.parseDouble(s.nextLine());
                done = true;
            }
            else {
                warning = "You must enter a number. Please try again.";
                System.out.println (warning);
                if (testMode) {
                    done = true;
                }
                else {
                    s.nextLine();
                }
                }
            }

        if(testMode){
            InputStream tipTest = new ByteArrayInputStream(tipPercentTest.getBytes());
            System.setIn(tipTest);
        }
        else {
            System.out.print("What is the tip rate: ");
        }
        done = false;
        s = new Scanner (System.in);
        while (! done){
            if (s.hasNextDouble()){
                tipPercent = Double.parseDouble(s.nextLine()) / 100;
                done = true;
            }
            else {
                warning = "You must enter a number. Please try again.";
                System.out.println (warning);
                if (testMode) {
                    done = true;
                }
                else{
                    s.nextLine();
                }
            }
        }
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

    public String getWarning(){

        return warning;
    }

    public static void execute () {
        TipCalculator calc = new TipCalculator();
        calc.getBillAmountAndTipRate();
        calc.calculateAndPrintTotals();
    }
}
