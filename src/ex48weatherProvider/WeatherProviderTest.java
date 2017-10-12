package ex48weatherProvider;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import org.mockito.*;
import org.json.simple.parser.ParseException;

/**
 * Tests for Weather Provider.
 */
public class WeatherProviderTest {
    private String apiKey;
    private WeatherProvider wp;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup(){
        wp = new WeatherProvider();
    }

    public void getApiKey() throws IOException {
        File keys = new File("C:\\Users\\Yasmin\\Documents\\api_keys\\OpenWeatherMap.txt");
        String key = "";
        try(Scanner scan = new Scanner(keys)){
            apiKey = scan.next();
        }
    }

    @Test
    public void IntegrationTest_ApiCall_ReturnsResult() throws Exception{
        getApiKey();
        OpenWeatherMapData owm = new OpenWeatherMapData(apiKey);
        String results = wp.getTemperature(owm, "Ann Arbor");
        System.out.println(results);
    }

    @Test
    public void GetTemperature_ValidWeatherData_ParsesCorrectly()throws Exception{
        //arrange
        WeatherDataGetter mockedWeather = Mockito.mock(WeatherDataGetter.class);
        Mockito.when(mockedWeather.getWeatherData("Paris")).thenReturn("{\"coord\":{\"lon\":2.35,\"lat\":48.85},\"weather\":[{\"id\":502,\"main\":\"Rain\",\"description\":\"heavy intensity rain\",\"icon\":\"10d\"},{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50d\"}],\"base\":\"stations\",\"main\":{\"temp\":61.11,\"pressure\":1004,\"humidity\":93,\"temp_min\":60.8,\"temp_max\":62.6},\"visibility\":3400,\"wind\":{\"speed\":12.75,\"deg\":240},\"clouds\":{\"all\":92},\"dt\":1504890000,\"sys\":{\"type\":1,\"id\":5617,\"message\":0.0049,\"country\":\"FR\",\"sunrise\":1504847903,\"sunset\":1504894595},\"id\":2988507,\"name\":\"Paris\",\"cod\":200}");
        String expectedResult = "The temperature in Paris is 61.11 Fahrenheit.";

        //act
        String results = wp.getTemperature(mockedWeather, "Paris");

        //assert
        assertEquals(expectedResult, results);
    }


    @Test
    public void GetTemperature_BlankCity_ExceptionThrown ()throws Exception{
        //arrange
        WeatherDataGetter mockedWeather = Mockito.mock(WeatherDataGetter.class);

        //assert
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("City can't be blank.");

        //act
        wp.getTemperature(mockedWeather, "");
    }

    @Test
    public void GetTemperature_NullCity_ExceptionThrown ()throws Exception{
        //arrange
        WeatherDataGetter mockedWeather = Mockito.mock(WeatherDataGetter.class);

        //assert
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("City can't be blank.");

        //act
        wp.getTemperature(mockedWeather, null);
    }

    @Test
    public void GetTemperature_NullWeatherData_ExceptionThrown ()throws Exception{
        //assert
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("WeatherDataGetter can't be null.");

        //act
        wp.getTemperature(null, "Paris");
    }

    @Test
    public void GetTemperature_MissingJsonObject_ExceptionThrown()throws Exception{
        //arrange
        WeatherDataGetter mockedWeather = Mockito.mock(WeatherDataGetter.class);
        Mockito.when(mockedWeather.getWeatherData("Paris")).thenReturn("{\"coord\":{\"lon\":2.35,\"lat\":48.85},\"weather\":[{\"id\":502,\"main\":\"Rain\",\"description\":\"heavy intensity rain\",\"icon\":\"10d\"},{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50d\"}],\"base\":\"stations\"," +
                "\"main100\":{\"temp\":61.11,\"pressure\":1004,\"humidity\":93,\"temp_min\":60.8,\"temp_max\":62.6},\"visibility\":3400,\"wind\":{\"speed\":12.75,\"deg\":240},\"clouds\":{\"all\":92},\"dt\":1504890000,\"sys\":{\"type\":1,\"id\":5617,\"message\":0.0049,\"country\":\"FR\",\"sunrise\":1504847903,\"sunset\":1504894595},\"id\":2988507,\"name\":\"Paris\",\"cod\":200}");

        //assert
        exception.expect(ParseException.class);

        //act
        wp.getTemperature(mockedWeather, "Paris");
    }

    @Test
    public void GetTemperature_WeatherDataGetterThrowsException_ExceptionThrown()throws Exception{
        //tests that exceptions are not suppressed
        //arrange
        WeatherDataGetter mockedWeather = Mockito.mock(WeatherDataGetter.class);
        Mockito.when(mockedWeather.getWeatherData("Paris")).thenThrow(IOException.class);
        //assert
        exception.expect(IOException.class);

        //act
        wp.getTemperature(mockedWeather, "Paris");
    }

    @Test
    public void GetTemperature_BlankResponse_ParserError()throws Exception{
        //arrange
        WeatherDataGetter mockedWeather = Mockito.mock(WeatherDataGetter.class);
        Mockito.when(mockedWeather.getWeatherData("Paris")).thenReturn("");
        exception.expect(ParseException.class);

        //act
        wp.getTemperature(mockedWeather, "Paris");
    }
}