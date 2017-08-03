package ex26creditCardPayOffCalculator;

/**
 * Determine how many months it will take to pay off a credit card. Take in the credit card balance, APR of the card,
 * and monthly payment.
 * Constraints:
 * Prompt for the APR as a percentage (not a decimal).
 * Use a function calculateMonthsUntilPaidOff that returns the number of months.
 * Round fractions of a cent up to the next cent.
 * Note: I used formula #3 on this website https://brownmath.com/bsci/loan.htm
 * Created by Yasmin on 8/3/2017
 */

public class CreditCardPayOffCalculator {
    private double creditCardBalance;
    private double monthlyApr;
    private double monthlyPayment;

    public CreditCardPayOffCalculator(double creditCardBalance, double  apr, double monthlyPayment){
        this.creditCardBalance = creditCardBalance;
        this.monthlyApr = apr / 12 / 100;
        this.monthlyPayment = monthlyPayment;
    }

    public double calculateMonthsUntilPaidOff(){
        return -Math.log10( (1  - monthlyApr * creditCardBalance / monthlyPayment)) / Math.log10(1 + monthlyApr);

       //Original formula:
        // -(Math.log( 1  - (monthlyApr * creditCardBalance / monthlyPayment))) / (Math.log(1 + monthlyApr));
    }
}
