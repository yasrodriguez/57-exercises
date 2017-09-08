package ex48weatherProvider;
import java.io.IOException;

public interface WeatherData {
    String getWeatherData(String city) throws IOException;
}
