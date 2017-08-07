package ex31heartRateCalculator;
import java.util.HashMap;

/**
 * Take in a person's age and resting heart rate and use the Karvonen formula to return the target heart rate based
 * on intensities ranging from 55% to 95% (in 5% increments).
 * Note: I'm using integers, so all the numbers will be rounded down to nearest whole number.
 * Constraints: Don't hardcode the percentages, instead use a loop.
 * Ensure heart rate and age are numeric.
 * Created by Yasmin on 8/7/2017
 */

public class HeartRateCalculator {

    public static HashMap<Integer,Integer> calculate(int age, int restingHeartRate){

        if(restingHeartRate == 0){
            throw new IllegalArgumentException("If your heart rate is 0, you're dead!");
        }

        HashMap<Integer,Integer> targetHeartRates = new HashMap<>();

        for(int intensity = 55; intensity <= 95; intensity = intensity + 5){
            int target = (((220-age)-restingHeartRate) * intensity/100)  + restingHeartRate;
            targetHeartRates.put(intensity, target);
        }

        return targetHeartRates;
    }
}
