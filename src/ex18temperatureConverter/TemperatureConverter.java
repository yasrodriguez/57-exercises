package ex18temperatureConverter;


/**
 * Convert temperatures from Fahrenheit to Celsius and vice versa after getting temperature and type of conversion.
 * Created by Yasmin on 7/10/2017.
 */

public class TemperatureConverter
{
    private double temperature;
    private double convertedTemperature;

    public enum TemperatureScale
    {
        Farenheit("F"), Celsius("C");

        private String abbreviation;

        TemperatureScale(String abbreviation)
        {
            this.abbreviation = abbreviation;
        }
    }

    private TemperatureScale conversionType;

    public TemperatureConverter(TemperatureScale conversionType, double temperature)
    {
        this.conversionType = conversionType;
        this.temperature = temperature;
        convertedTemperature = 0;
    }

    double convert()
    {
        if(conversionType == TemperatureScale.Celsius)
        {
            convertedTemperature = Math.round((temperature - 32) * 5 / 9);
        }
        else if (conversionType == TemperatureScale.Farenheit)
        {
            convertedTemperature = Math.round((temperature * 9/5) + 32);
        }
        return convertedTemperature;
    }
}
