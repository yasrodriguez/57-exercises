package ex0tipCalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for tip calculator.
 */
public class TipCalculatorTest {
    @Test
        public void wholeTipAndWholeBillAmount() {
            TipCalculator calc = new TipCalculator("10", "100");
            calc.getInput();
            calc.calculate();
            assertEquals("$10.00", calc.getTipAmount());
            assertEquals("$110.00", calc.getTotal());
        }

    @Test
    public void decimalTipAndWholeBillAmount() {
        TipCalculator calc = new TipCalculator("9.99", "33");
        calc.getInput();
        calc.calculate();
        assertEquals("$3.30", calc.getTipAmount());
        assertEquals("$36.30", calc.getTotal());
    }

    @Test
    public void wholeTipAndDecimalBillAmount() {
        TipCalculator calc = new TipCalculator("20", "58.51");
        calc.getInput();
        calc.calculate();
        assertEquals("$11.70", calc.getTipAmount());
        assertEquals("$70.21", calc.getTotal());
    }

    @Test
    public void decimalTipAndDecimalBillAmount() {
        TipCalculator calc = new TipCalculator("20.5", "25.25");
        calc.getInput();
        calc.calculate();
        assertEquals("$5.18", calc.getTipAmount());
        assertEquals("$30.43", calc.getTotal());
    }

    @Test
    public void validationWhenBillAmountIsString() {
        TipCalculator calc = new TipCalculator("10","b");
        calc.getInput();
        assertEquals ("You must enter a number. Please try again.", calc.getWarning() );
    }

    @Test
    public void validationWhenTipIsString() {
        TipCalculator calc = new TipCalculator("a", "100");
        calc.getInput();
        assertEquals("You must enter a number. Please try again.", calc.getWarning());
    }

    @Test
    public void validationWhenTipAndBillAreString() {
        TipCalculator calc = new TipCalculator("abc", "*de");
        calc.getInput();
        assertEquals("You must enter a number. Please try again.", calc.getWarning());
    }

    @Test
    public void validationWhenBillAmountIsNegative(){
        TipCalculator calc = new TipCalculator("10", "-100");
        calc.getInput();
        assertEquals("You must enter a positive number. Please try again.", calc.getWarning());
    }

    @Test
    public void validationWhenTipIsNegative(){
        TipCalculator calc = new TipCalculator("-15", "100");
        calc.getInput();
        assertEquals("You must enter a positive number. Please try again.", calc.getWarning());
    }

    @Test
    public void validationWhenBillAmountAndTipAreNegative(){
        TipCalculator calc = new TipCalculator("-15", "-100");
        calc.getInput();
        assertEquals("You must enter a positive number. Please try again.", calc.getWarning());
    }

}