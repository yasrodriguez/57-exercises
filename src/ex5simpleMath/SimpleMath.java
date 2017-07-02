package ex5simpleMath;
import java.util.Scanner;

/**
 * Prompt for two numbers. Print the sum, difference, product,and quotient of
 * the two numbers. Constraint: Print using one output statement.
 * Created by Yasmin on 6/12/2017.
 */
public class SimpleMath {
    private double number1;
    private double number2;

    private SimpleMath(){
        number1 = 0;
        number2 = 0;
    }

    private void convert(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        number1 = Double.parseDouble(s.next());
        System.out.print("Enter the second number: ");
        number2 = Double.parseDouble(s.next());
    }

    private void calculate(){
        double sum = number1 + number2;
        double subtr = number1 - number2;
        double mult = number1 * number2;
        double div = number1 / number2;
        print(sum,subtr,mult,div);
    }

    private void print(double sum, double subtr, double mult, double div){
        String template = number1 + " %s " + number2 + " = " + "%.2f";
        System.out.print(String.format(template,"+", sum ) + "\n" + String.format(template, "-", subtr) +
            "\n" + String.format(template, "*", mult) + "\n" + String.format(template, "/", div));
    }

    public static void execute(){
        SimpleMath calc = new SimpleMath();
        calc.convert();
        calc.calculate();
    }
}
