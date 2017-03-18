package TipCalculator;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for tip calculator
 */
public class TipCalculatorTester {
    @Test
    public void wholeTipAndWholeBillAmount() {
        TipCalculator calc = new TipCalculator("10", "100");
        calc.getBillAmountAndTipRate();
        calc.calculateAndPrintTotals();
        assertEquals("$10.00", calc.getTipAmount());
        assertEquals("$110.00", calc.getTotal());
    }

    @Test
    public void decimalTipAndWholeBillAmount() {
        TipCalculator calc2 = new TipCalculator("9.99", "33");
        calc2.getBillAmountAndTipRate();
        calc2.calculateAndPrintTotals();
        assertEquals("$3.30", calc2.getTipAmount());
        assertEquals("$36.30", calc2.getTotal());
    }

    @Test
    public void wholeTipAndDecimalBillAmount() {
        TipCalculator calc3 = new TipCalculator("20", "58.51");
        calc3.getBillAmountAndTipRate();
        calc3.calculateAndPrintTotals();
        assertEquals("$11.70", calc3.getTipAmount());
        assertEquals("$70.21", calc3.getTotal());
    }

    @Test
    public void decimalTipAndDecimalBillAmount() {
        TipCalculator calc4 = new TipCalculator("20.5", "25.25");
        calc4.getBillAmountAndTipRate();
        calc4.calculateAndPrintTotals();
        assertEquals("$5.18", calc4.getTipAmount());
        assertEquals("$30.43", calc4.getTotal());
    }

    @Test
    public void validationWhenBillAmountIsString() {
    TipCalculator calc5 = new TipCalculator("10","b");
    calc5.getBillAmountAndTipRate();
    assertEquals ("You must enter a number. Please try again.", calc5.getWarning() );
    }

    @Test
    public void validationWhenTipIsString() {
        TipCalculator calc6 = new TipCalculator("a", "100");
        calc6.getBillAmountAndTipRate();
        assertEquals("You must enter a number. Please try again.", calc6.getWarning());
    }

    @Test
    public void validationWhenTipAndBillAreString() {
        TipCalculator calc7 = new TipCalculator("abc", "*de");
        calc7.getBillAmountAndTipRate();
        assertEquals("You must enter a number. Please try again.", calc7.getWarning());
    }


}
