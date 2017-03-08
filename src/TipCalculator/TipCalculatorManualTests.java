package TipCalculator;

/**
 * Manual tests for the Tip Calculator program
 */
public class TipCalculatorManualTests {
    public static void execute () {
        double tip;
        double bill;

        //Test #1
        tip = 10;
        bill= 100;
        TipCalculator calc = new TipCalculator(tip, bill);
        System.out.println ("Test #1");
        System.out.println ("Inputs:");
        System.out.println ("   Bill Amount: " + bill);
        System.out.println ("   Tip %: " + tip);
        System.out.println ("");
        System.out.println ("Actual Results:");
        calc.calculateAndPrintTotals();
        System.out.println ("");
        System.out.println ("Expected Results:");
        System.out.println ("   Tip: $10.00");
        System.out.println ("   Total: $110.00");
        System.out.println ("");

        //Test #2 - tip with decimals, round up
        tip = 9.99;
        bill= 33;
        TipCalculator calc2 = new TipCalculator(tip, bill);
        System.out.println ("Test #2");
        System.out.println ("Inputs:");
        System.out.println ("   Bill Amount: " + bill);
        System.out.println ("   Tip %: " + tip);
        System.out.println ("");
        System.out.println ("Actual Results:");
        calc2.calculateAndPrintTotals();
        System.out.println ("");
        System.out.println ("Expected Results:");
        System.out.println ("   Tip: $3.30");
        System.out.println ("   Total: $36.30");
        System.out.println ("");

        //Test #3 - bill with decimals, round down
        tip = 20;
        bill= 58.51;
        TipCalculator calc3 = new TipCalculator(tip, bill);
        System.out.println ("Test #3");
        System.out.println ("Inputs:");
        System.out.println ("   Bill Amount: " + bill);
        System.out.println ("   Tip %: " + tip);
        System.out.println ("");
        System.out.println ("Actual Results:");
        calc3.calculateAndPrintTotals();
        System.out.println ("");
        System.out.println ("Expected Results:");
        System.out.println ("   Tip: $11.70");
        System.out.println ("   Total: $70.21");
        System.out.println ("");

        //Test #4 - bill & tip with decimals
        tip = 20.5;
        bill= 25.25;
        TipCalculator calc4 = new TipCalculator(tip, bill);
        System.out.println ("Test #4");
        System.out.println ("Inputs:");
        System.out.println ("   Bill Amount: " + bill);
        System.out.println ("   Tip %: " + tip);
        System.out.println ("");
        System.out.println ("Actual Results:");
        calc4.calculateAndPrintTotals();
        System.out.println ("");
        System.out.println ("Expected Results:");
        System.out.println ("   Tip: $5.18");
        System.out.println ("   Total: $30.43");
        System.out.println ("");
    }
}
