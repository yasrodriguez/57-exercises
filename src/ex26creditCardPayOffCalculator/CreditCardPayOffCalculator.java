package ex26creditCardPayOffCalculator;

/**
 * Determine how many months it will take to pay off a credit card. Take in the credit card balance, APR of the card,
 * and monthly payment.
 * Constraints:
 * Prompt for the APR as a percentage (not a decimal).
 * Use a function calculateMonthsUntilPaidOff that returns the number of months.
 * Round up to the next month.
 * Note: I obtained the formula (#3) from this website https://brownmath.com/bsci/loan.htm
 * Created by Yasmin on 8/3/2017
 */

public class CreditCardPayOffCalculator {
    private double creditCardBalance;
    private double monthlyApr;
    private double monthlyPayment;

    public CreditCardPayOffCalculator(double creditCardBalance, double  apr, double monthlyPayment){
        this.creditCardBalance = creditCardBalance;
        this.monthlyApr = apr / 12 / 100;
        checkPaymentIsNot0(monthlyPayment);
        this.monthlyPayment = monthlyPayment;
    }

    public int calculateMonthsUntilPaidOff() {
        if (monthlyApr == 0) {
            return (int) Math.round(creditCardBalance / monthlyPayment);
        }
        else{
            return (int) Math.round(-Math.log10((1 - monthlyApr * creditCardBalance / monthlyPayment)) /
                    Math.log10(1 + monthlyApr));
        }
    }

    private void checkPaymentIsNot0(double number){
        if (number <=0){
            throw new IllegalArgumentException("This loan will never be paid off.");
        }
    }
}
