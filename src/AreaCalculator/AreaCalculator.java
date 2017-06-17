package AreaCalculator;
import java.util.Scanner;

/**
 * Prompt for the length and width of a rectangular room in feet and
 * calculate the area in square feet and square meters. Use a constant for the conversion factor.
 * Note: Printed results are rounded to 3 decimal places.
 * Created by Yasmin on 6/14/2017.
 */
public class AreaCalculator {
    private double length;
    private double width;
    private double area;
    private double areaInMeters;
    private boolean testMode;
    private static final double FEET_TO_METERS = .09290304;

    private AreaCalculator(){
        area = 0;
        areaInMeters = 0;
        prompt();
    }

    public AreaCalculator(double length, double width){
        testMode = true;
        this.length = length;
        this.width = width;
        area = 0;
        areaInMeters = 0;
    }

    private void prompt() {
        testMode = false;

        Scanner s = new Scanner(System.in);

        print("Enter length of the room in feet: ");
        length = s.nextDouble();

        print("Enter width of the room in feet: ");
        width = s.nextDouble();

        print ("You entered dimensions of " + length + " feet by " + width + " feet.");
    }

    private void convert() {
        area = length * width;
        areaInMeters = area * FEET_TO_METERS;
        if (!testMode) {
        print("The area is:");
        System.out.printf("%.3f square feet %n", area);
        System.out.printf("%.3f square meters %n", areaInMeters);
    }
        }

    private void print(String message){
        System.out.println(message);
    }

    public String getArea(){
        return String.format("%.3f square feet", area);
    }

    public String getAreaInMeters(){
        return String.format("%.3f square meters",areaInMeters);
    }

    public static void execute() {
        AreaCalculator calc = new AreaCalculator();
        calc.convert();
    }

    public void executeTest() {
        convert();
    }

}
