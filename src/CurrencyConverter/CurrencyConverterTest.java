package CurrencyConverter;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Unit tests for Currency Converter.
 * Created by Yasmin on 6/26/2017.
 */
public class CurrencyConverterTest
{
    private CurrencyConverter cc;

    @Test
    public void book_example()
    {
        cc = new CurrencyConverter(81,1.3751);
        cc.convertToUSD();
        assertEquals(BigDecimal.valueOf(111.39), cc.getConvertedAmount());
    }
    @Test
    public void current_rate_on_June_26_2017()
    {
        cc = new CurrencyConverter(25, 1.117925);
        cc.convertToUSD();
        assertEquals(BigDecimal.valueOf(27.95), cc.getConvertedAmount());
    }
    @Test
    public void exchange_rate_of_1()
    {
        cc = new CurrencyConverter(10, 1);
        cc.convertToUSD();
        assertEquals(BigDecimal.valueOf(10.00).setScale(2),cc.getConvertedAmount() );
    }
}