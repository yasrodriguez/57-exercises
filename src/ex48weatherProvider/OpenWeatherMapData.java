package ex48weatherProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class OpenWeatherMapData implements WeatherData {
    String apiKey;

     public OpenWeatherMapData(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Call API.
     * Example call that returns data for London using imperial units:
     * http://api.openweathermap.org/data/2.5/weather?q=London&units=imperial&APPID={yourAPPIDHere}
     * APPID must be replaced with an API key obtained from OpenWeatherMap
     */
    @Override
    public String getWeatherData(String city) throws IOException {
        String apiCall = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&units=imperial&APPID=%s",
                city, apiKey);
        URL url = new URL(apiCall);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.readLine();
        }
    }
}