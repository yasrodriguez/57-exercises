package AreaCalculator;
import java.util.Scanner;

/**
 * Prompt for the length and width of a rectangular room in feet and
 * calculate the area in square feet and square meters. Use a constant for
 * the conversion factor.
 * Created by Yasmin on 6/14/2017.
 */
public class AreaCalculator {
    private double length;
    private double width;
    private static final double FEET_TO_METERS = .09290304;

    private AreaCalculator(){
        prompt();
    }

    private void prompt() {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter length of the room in feet: ");
        double len = s.nextDouble();

        System.out.print("Enter width of the room in feet: ");
        double width = s.nextDouble();
    }


    public static void execute() {
        AreaCalculator calc = new AreaCalculator();
    }


}
