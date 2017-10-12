package ex20multiStateSalesTaxCalculator;

import java.math.BigDecimal;

/**
 * Get the order amount and state where order will be shipped. Calculate tax as follows:
 * Wisconsin - 5.5%. For Eau Claire and Dunn counties, add .5% and .4%, respectively.
 * Illinois - 8%
 * All other states - No tax.
 * Return tax and total.
 * Created by Yasmin on 7/19/2017.
 */
public class SalesTaxCalculator
{
    private BigDecimal orderAmount;
    private BigDecimal totalTax;
    private String state;
    private String county;
    private static final BigDecimal WI_EAU_CLAIRE_TAX = new BigDecimal(.005);
    private static final BigDecimal WI_DUNN_TAX = new BigDecimal(.004);
    private static final BigDecimal WI_TAX = new BigDecimal(.055);
    private static final BigDecimal IL_TAX = new BigDecimal(.08);

    public SalesTaxCalculator (BigDecimal orderAmount,String state, String county)
    {
        this.orderAmount = orderAmount;
        this.state = state;
        this.county = county;
        totalTax = new BigDecimal(0);
    }

    public BigDecimal calculateTax()
    {
        if (state.equals("WI"))
        {
            totalTax = orderAmount.multiply(WI_TAX);

            if (county.equals("Eau Claire"))
            {
                totalTax = totalTax.add(orderAmount.multiply(WI_EAU_CLAIRE_TAX));
            } else if (county.equals("Dunn"))
            {
                totalTax = totalTax.add(orderAmount.multiply(WI_DUNN_TAX));
            }
        }
        else if (state.equals("IL"))
            {
                totalTax = orderAmount.multiply(IL_TAX);
            }
        return totalTax.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }


    public BigDecimal calculateTotal()
    {
        return orderAmount.add(totalTax).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
}
