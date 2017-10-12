package ex8pizzaParty;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for Pizza Party.
 * Created by Yasmin on 6/18/2017.
 */
public class PizzaPartyTester {
    @Test
    public void onePizzaOddSlices(){
        PizzaParty test = new PizzaParty(3,1,8);
        PizzaParty.PizzaDivision a =  test.executeTest();
        assertEquals(2, a.getSlices());
        assertEquals(2, a.getLeftOvers());
    }

    @Test
    public void onePizzaEvenSlices(){
        PizzaParty test = new PizzaParty(2,1,8);
        PizzaParty.PizzaDivision a =  test.executeTest();
        assertEquals(4, a.getSlices());
        assertEquals(0, a.getLeftOvers());
    }

     @Test
    public void multiplePizzaOddSlices(){
        PizzaParty test = new PizzaParty(7,2,16);
        PizzaParty.PizzaDivision a =  test.executeTest();
        assertEquals(4, a.getSlices());
        assertEquals(4, a.getLeftOvers());
    }

    @Test
    public void multiplePizzaEvenSlices(){
        PizzaParty test = new PizzaParty(5,5,12);
        PizzaParty.PizzaDivision a =  test.executeTest();
        assertEquals(12, a.getSlices());
        assertEquals(0, a.getLeftOvers());
    }
}
