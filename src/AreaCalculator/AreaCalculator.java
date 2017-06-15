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

    private AreaCalculator(double length, double width){
        this.length = length;
        this.width = width;
    }

    private void prompt() {
        Scanner s = new Scanner(System.in);

        print("Enter length of the room in feet: ");
        length = s.nextDouble();

        print("Enter width of the room in feet: ");
        width = s.nextDouble();

        print ("You entered dimensions of " + length + " feet by " + width + " feet.");
    }

    private void convert(){
        double area = length * width;
        double areaInMeters = area * FEET_TO_METERS;
        print("The area is:");
        System.out.printf ("%.3f square feet \n", area);
        System.out.printf ("%.3f square meters \n",areaInMeters);
    }

    private void print(String message){
        System.out.println(message);
    }

    public static void execute() {
        AreaCalculator calc = new AreaCalculator();
        calc.convert();
    }

    public static void executeTest(double length, double width) {
        AreaCalculator calc = new AreaCalculator(length, width);
        calc.convert();
    }

}
