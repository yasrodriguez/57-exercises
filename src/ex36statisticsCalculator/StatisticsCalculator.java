package ex36statisticsCalculator;

import java.util.Collections;
import java.util.ArrayList;

/**
 * Take in response times from a website in milliseconds. Print the average time, minimum time, maximum time,
 * and sample standard deviation.
 * Constraints: Use loops and arrays to perform input and mathematical operations.
 * Created by Yasmin on 8/13/2017
 */

public class StatisticsCalculator {

    public double calculateAverage(ArrayList<Double> list) {
        checkNumberOfElements(list);

        double sum = getSum(list);
        return sum / list.size();
    }

    public double calculateMaximum(ArrayList<Double> list) {
        checkNumberOfElements(list);
        return Collections.max(list);
    }

    public double calculateMinimum(ArrayList<Double> list) {
        checkNumberOfElements(list);
        return Collections.min(list);
    }

    public double calculateSampleStandardDeviation(ArrayList<Double> list) {
        double average = calculateAverage(list);

        ArrayList<Double> squaredDiffs = new ArrayList<>();
        for (double number : list) {
            double diff = Math.pow(number - average, 2);
            squaredDiffs.add(diff);
        }

        double averageOfSquaredDiffs = getSum(squaredDiffs) / (squaredDiffs.size() - 1);
        return Math.ceil(Math.sqrt(averageOfSquaredDiffs) * 100) / 100 ;
    }

    private void checkNumberOfElements(ArrayList<Double> list) {
        if (list.isEmpty() || list.size() < 2) {
            throw new IllegalArgumentException("You need to enter two or more values.");
        }
    }

    private double getSum(ArrayList<Double> list) {
        double sum = 0;
        for (double number : list) {
            sum += number;
        }
        return sum;
    }
}
