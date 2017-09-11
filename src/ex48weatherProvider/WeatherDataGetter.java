package ex48weatherProvider;
import java.io.IOException;

public interface WeatherDataGetter {
    String getWeatherData(String city) throws IOException;
}
