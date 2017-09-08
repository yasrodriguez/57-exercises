package ex48weatherProvider;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Tests for Weather Provider.
 */
public class WeatherProviderTest {
    private String apiKey;
    private WeatherProvider wp;

    @Before
    public void setup() throws IOException{
        File keys = new File("C:\\Users\\Yasmin\\Documents\\api_keys\\OpenWeatherMap.txt");
        String key = "";
        try(Scanner scan = new Scanner(keys)){
            apiKey = scan.next();
        }
        wp = new WeatherProvider();
    }

    @Test
    public void integration_test_to_verify_call_to_api_and_parsing_is_working() throws Exception{
        OpenWeatherMapData owm = new OpenWeatherMapData(apiKey);
        String results = wp.getTemperature(owm, "Ann Arbor");
        System.out.println(results);
    }

    @Test
    public void test_that_temperature_is_correctly_parsed()throws Exception{
        //arrange
        WeatherData mockedWeather = mock(WeatherData.class);
        when(mockedWeather.getWeatherData("Paris")).thenReturn("{\"coord\":{\"lon\":2.35,\"lat\":48.85},\"weather\":[{\"id\":502,\"main\":\"Rain\",\"description\":\"heavy intensity rain\",\"icon\":\"10d\"},{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50d\"}],\"base\":\"stations\",\"main\":{\"temp\":61.11,\"pressure\":1004,\"humidity\":93,\"temp_min\":60.8,\"temp_max\":62.6},\"visibility\":3400,\"wind\":{\"speed\":12.75,\"deg\":240},\"clouds\":{\"all\":92},\"dt\":1504890000,\"sys\":{\"type\":1,\"id\":5617,\"message\":0.0049,\"country\":\"FR\",\"sunrise\":1504847903,\"sunset\":1504894595},\"id\":2988507,\"name\":\"Paris\",\"cod\":200}");
        String expectedResult = "The temperature in Paris is 61.11 Fahrenheit.";

        //act
        String results = wp.getTemperature(mockedWeather, "Paris");

        //assert
        assertEquals(expectedResult, results);
    }
}