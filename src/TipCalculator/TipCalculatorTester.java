package TipCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for tip calculator
 */
public class TipCalculatorTester {
        @Test
        public void test1 () {
            TipCalculator calc = new TipCalculator(10, 100);
            calc.calculateAndPrintTotals();
            assertEquals("$10.00", calc.getTipAmount());
            assertEquals("$110.00", calc.getTotal());
        }

        @Test
        public void test2 () {
            TipCalculator calc2 = new TipCalculator(9.99, 33);
            calc2.calculateAndPrintTotals();
            assertEquals("$3.30", calc2.getTipAmount());
            assertEquals("$36.30", calc2.getTotal());
        }

        @Test
        public void test3 () {
            TipCalculator calc3 = new TipCalculator(20, 58.51);
            calc3.calculateAndPrintTotals();
            assertEquals("$11.70", calc3.getTipAmount());
            assertEquals("$70.21", calc3.getTotal());
        }

        @Test
        public void test4 () {
            TipCalculator calc4 = new TipCalculator(20.5, 25.25);
            calc4.calculateAndPrintTotals();
            assertEquals("$5.18", calc4.getTipAmount());
            assertEquals("$30.43", calc4.getTotal());
        }
    }
