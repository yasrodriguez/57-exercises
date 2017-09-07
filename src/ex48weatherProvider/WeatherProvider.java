package ex48weatherProvider;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Prompt for a city name and return the current temperature using the
 * OpenWeatherMap API http://openweathermap.org/current
 * Created by Yasmin on 9/7/2017
 */

public class WeatherProvider {
    private String apiKey;

    public WeatherProvider(String apiKey){
        this.apiKey = apiKey;
    }

    /**
     * Parse API response (JSON by default) to obtain temperature
     * The temperature can be found within main then temp, it's 55.62 in this example:
     * "main":{"temp":55.62,"pressure":1019,"humidity":83,"temp_min":289.82,"temp_max":295.37},
     */
    public String getTemperature(String city) throws ParseException, IOException{
        String weatherData = getWeatherData(city);

        JSONParser parser = new JSONParser();
        JSONObject weatherResults = (JSONObject)parser.parse(weatherData);
        JSONObject main = (JSONObject) weatherResults.get("main");
        double temp = (double) main.get("temp");
        return "The temperature in " + city + " is " + temp + " Fahrenheit.";
    }

    /**
     * Call API.
     * Example call that returns data for London using imperial units:
     * http://api.openweathermap.org/data/2.5/weather?q=London&units=imperial&APPID={yourAPPIDHere}
     * APPID must be replaced with an API key obtained from OpenWeatherMap*/
    private String getWeatherData(String city) throws IOException {
        String apiCall = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&units=imperial&APPID=%s",
                city, apiKey);
        URL url = new URL(apiCall);
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))){
            return reader.readLine();
        }
    }
}
