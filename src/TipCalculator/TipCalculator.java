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
    private Scanner s;

    public TipCalculator() {
        testMode = false;
        tipPercentTest = "";
        billAmountTest = "";
        initialize();
    }

    public TipCalculator(String tipRateTest, String billTest){
        testMode = true;
        tipPercentTest = tipRateTest;
        billAmountTest = billTest;
        initialize();
    }

    public void initialize(){
        tipPercent = 0;
        billAmount = 0;
        tipAmount = 0;
        total= 0;
        currency = NumberFormat.getCurrencyInstance(Locale.US);
        warning = "";
        s = new Scanner (System.in);
    }

    public void getInput(){
        if (! testMode) {
            print("What is the bill amount: ");
        }
        else {
           setMockInput(billAmountTest);
                   }
        billAmount = validate();
        if (!testMode){
            print ("What is the tip percent: ");
        }
        else {
            setMockInput(tipPercentTest);
        }
        tipPercent = validate()/100;
    }


    public void print(String message) {

        System.out.println(message);
    }

    public void setMockInput(String testInput){

        InputStream mockInput = new ByteArrayInputStream(testInput.getBytes());
        System.setIn (mockInput);
        s = new Scanner (System.in);
          }

    public double validate() {
        boolean done = false;
        double value = 0;
        while (!done) {
            if (s.hasNextDouble()){
                value = Double.parseDouble(s.nextLine());
                if (value >=0){
                    done = true;
                }
                else {
                    warning = "You must enter a positive number. Please try again.";
                    print(warning);
                    if (testMode){
                        break;
                    }
                }
            }else {
                warning = "You must enter a number. Please try again.";
                print(warning);
                if (!testMode) {
                    s.nextLine();
                } else {
                    break;
                }
            }
        }
        return value;
    }

    public void calculate () {
        tipAmount = billAmount * tipPercent;
        System.out.printf("Total tip: %s %n", getTipAmount());
        total = billAmount + tipAmount;
        System.out.printf("Total amount: %s %n", getTotal());
    }

    public static void execute () {
        TipCalculator calc = new TipCalculator();
        calc.getInput();
        calc.calculate();
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
}
