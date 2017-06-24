package SelfCheckout;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for Self Checkout.
 * Created by Yasmin on 6/23/2017.
 */
public class SelfCheckoutTest
{
    @Test
    public void item_mix_1()
    {
        SelfCheckout checkout = new SelfCheckout();
        checkout.calculateSubtotalAndItemCount(5.50, 2);
        checkout.calculateSubtotalAndItemCount(20,2);
        checkout.calculateSubtotalAndItemCount(1.99, 1);
        checkout.calculateTaxAndTotal();
        assertEquals("5.0", checkout.getItemCount());
        assertEquals("$52.99", checkout.getSubtotal());
        assertEquals("$2.91", checkout.getTaxAmount());
        assertEquals("$55.90", checkout.getTotal());
    }
    @Test
    public void item_mix_2()
    {
        SelfCheckout checkout = new SelfCheckout();
        checkout.calculateSubtotalAndItemCount(15.30, 5);
        checkout.calculateSubtotalAndItemCount(2.99,15);
        checkout.calculateSubtotalAndItemCount(4.92, 3);
        checkout.calculateTaxAndTotal();
        assertEquals("23.0", checkout.getItemCount());
        assertEquals("$136.11", checkout.getSubtotal());
        assertEquals("$7.49", checkout.getTaxAmount());
        assertEquals("$143.60", checkout.getTotal());
    }
}
