package ex36statisticsCalculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Unit tests for Statistics Calculator.
 * Created by Yasmin on 8/13/17
 */

public class StatisticsCalculatorTest {
    @Test
    public void Test_Average_Calculation_Is_Correct() throws Exception {
        //arrange
        StatisticsCalculator sc = new StatisticsCalculator();
        ArrayList<Double> rt = new ArrayList<>();
        Collections.addAll(rt, 100D,200D,1000D,300D);
        double expectedAverage = 400;

        //act
        double calculatedAverage = sc.calculateAverage(rt);

        //assert
        assertEquals(expectedAverage, calculatedAverage, 0);
    }

    @Test
    public void Test_Maximum_Calculation_Is_Correct() throws Exception {
        //arrange
        StatisticsCalculator sc = new StatisticsCalculator();
        ArrayList<Double> rt = new ArrayList<>();
        Collections.addAll(rt, 100D,200D,1000D,300D);
        double expectedMaximum = 1000;

        //act
        double calculatedMaximum = sc.calculateMaximum(rt);

        //assert
        assertEquals(expectedMaximum, calculatedMaximum, 0);
    }

    @Test
    public void Test_Minimum_Calculation_Is_Correct() throws Exception {
        //arrange
        StatisticsCalculator sc = new StatisticsCalculator();
        ArrayList<Double> rt = new ArrayList<>();
        Collections.addAll(rt, 100D,200D,1000D,300D);
        double expectedMinimum = 100;

        //act
        double calculatedMinimum = sc.calculateMinimum(rt);

        //assert
        assertEquals(expectedMinimum, calculatedMinimum, 0);

    }

    @Test
    public void Test_Sample_Standard_Deviation_Is_Correct() throws Exception {
        //arrange
        StatisticsCalculator sc = new StatisticsCalculator();
        ArrayList<Double> rt = new ArrayList<>();
        Collections.addAll(rt, 100D,200D,1000D,300D);
        double expectedStandardDeviation = 408.25;

        //act
        double calculatedStandardDeviation = sc.calculateSampleStandardDeviation(rt);

        //assert
        assertEquals(expectedStandardDeviation, calculatedStandardDeviation, 0);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void Test_Sample_Standard_Deviation_Is_Not_Calculated_When_There_Is_Only_One_Value() throws Exception {
        //arrange
        StatisticsCalculator sc = new StatisticsCalculator();
        ArrayList<Double> rt = new ArrayList<>();
        Collections.addAll(rt, 100D);

        //assert
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("You need to enter two or more values.");

        //act
        double calculatedStandardDeviation = sc.calculateSampleStandardDeviation(rt);
    }

    @Test
    public void Test_Empty_List_Returns_An_Error_When_Calculating_Standard_Deviation() throws Exception {
        //arrange
        StatisticsCalculator sc = new StatisticsCalculator();
        ArrayList<Double> rt = new ArrayList<>();

        //assert
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("You need to enter two or more values.");

        //act
        sc.calculateSampleStandardDeviation(rt);
    }

    @Test
    public void Test_Empty_List_Returns_An_Error_When_Calculating_Average() throws Exception {
        //arrange
        StatisticsCalculator sc = new StatisticsCalculator();
        ArrayList<Double> rt = new ArrayList<>();

        //assert
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("You need to enter two or more values.");

        //act
        sc.calculateAverage(rt);
    }

    @Test
    public void Test_Empty_List_Returns_An_Error_When_Calculating_Max() throws Exception {
        //arrange
        StatisticsCalculator sc = new StatisticsCalculator();
        ArrayList<Double> rt = new ArrayList<>();

        //assert
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("You need to enter two or more values.");

        //act
        sc.calculateMaximum(rt);
    }

    @Test
    public void Test_Empty_List_Returns_An_Error_When_Calculating_Min() throws Exception {
        //arrange
        StatisticsCalculator sc = new StatisticsCalculator();
        ArrayList<Double> rt = new ArrayList<>();

        //assert
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("You need to enter two or more values.");

        //act
        sc.calculateMinimum(rt);
    }

}