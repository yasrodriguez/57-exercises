package ex48weatherProvider;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;


/**
 * Prompt for a city name and return the current temperature using the
 * OpenWeatherMap API http://openweathermap.org/current
 * Created by Yasmin on 9/7/2017
 */

public class WeatherProvider {

       /**
     * Parse API response (JSON by default) to obtain temperature
     * The temperature can be found within main then temp, it's 55.62 in this example:
     * "main":{"temp":55.62,"pressure":1019,"humidity":83,"temp_min":289.82,"temp_max":295.37},
     */

    public String getTemperature(WeatherDataGetter dataGetter, String city) throws ParseException, IOException{
        if(city == null || city.isEmpty()){
            throw new IllegalArgumentException("City can't be blank.");
        }
        if(dataGetter == null){
            throw new IllegalArgumentException("WeatherDataGetter can't be null.");
        }

        String weatherData = dataGetter.getWeatherData(city);
        JSONParser parser = new JSONParser();
        JSONObject weatherResults = (JSONObject)parser.parse(weatherData);
        JSONObject main = (JSONObject) weatherResults.get("main");
        if(main == null){
            throw new ParseException(1);
        }

            double temp = (double) main.get("temp");
            return String.format("The temperature in %s is %s Fahrenheit.", city, temp);
        }
    }
