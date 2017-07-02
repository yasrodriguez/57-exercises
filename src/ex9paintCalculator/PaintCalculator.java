package ex9paintCalculator;
import java.util.Scanner;

/**
 * Prompt for the length and width of the room. Calculate gallons of paint needed to paint the ceiling of the room
 * (assuming one gallon covers 350 square feet). Display the number of gallons needed as a whole number.
 * Created by Yasmin on 6/20/2017.
 */
public class PaintCalculator
{
    private double length;
    private double width;
    private double gallons;
    private int gallonsRounded;
    private double area;
    private static final int GALLON_COVERAGE_IN_FEET = 350;


    private PaintCalculator()
    {
        length = 0;
        width = 0;
        initialize();
    }
    public PaintCalculator(double length, double width)
    {
        this.length = length;
        this.width = width;
        initialize();
    }

    private void initialize()
    {
        gallons = 0;
        gallonsRounded = 0;
        area = 0;
    }

    private void askRoomSize()
    {
        Scanner s = new Scanner (System.in);
        print("What is the length of your room (in square feet): ");
        length = s.nextDouble();
        print("What is the width of your room (in square feet): ");
        width = s.nextDouble();
        initialize();
    }

    private void calculateGallons()
    {   area = length * width;
        gallons = area / GALLON_COVERAGE_IN_FEET;
        gallonsRounded = (int) Math.ceil(gallons);
    }

    private void printGallons()
    {
        print("You will need to purchase " +  gallonsRounded + " gallons of paint to cover " +
                area + " square feet" );
    }

    public int getGallons()
    {
        return gallonsRounded;
    }

    private void print(String message)
    {
        System.out.println(message);
    }

    public static void execute()
    {
        PaintCalculator calc = new PaintCalculator();
        calc.askRoomSize();
        calc.calculateGallons();
        calc.printGallons();
    }

    public void executeTest()
    {
        calculateGallons();
    }
}
