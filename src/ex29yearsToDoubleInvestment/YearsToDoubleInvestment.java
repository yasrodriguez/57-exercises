package ex29yearsToDoubleInvestment;

/**
 * Take a rate of return and return how many years it will take to
 * to double the investment, calculated as: 72/rate.
 * Constraints: Don't allow 0 or non-numeric values for rate.
 * Created by Yasmin on 8/7/2017
 */

public class YearsToDoubleInvestment {
    public static double calculateYears(double rate){
        if(rate == 0){
            throw new ArithmeticException("Rate can't be 0!");
        }
        return 72/rate;
    }
}
