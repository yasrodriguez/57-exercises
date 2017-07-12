package ex18temperatureConverter;
import java.util.Scanner;

/**
 * Convert temperatures from Fahrenheit to Celsius and vice versa.
 * Prompt for starting temperature and type of conversion.
 * Created by Yasmin on 7/10/2017.
 */
public class TemperatureConverter
{
    private String conversionType;
    private double temperature;
    private double convertedTemperature;

    private TemperatureConverter()
    {
        conversionType = "";
        temperature = 0;
        convertedTemperature = 0;
    }

    TemperatureConverter(String conversionType, double temperature)
    {
        this.conversionType = conversionType;
        this.temperature = temperature;
        convertedTemperature = 0;
    }

    private void prompt()
    {
        Scanner s = new Scanner (System.in);

        String message_template = "Enter %s to convert from %s to %s. %n";
        System.out.printf(message_template, "C", "Fahrenheit", "Celsius");
        System.out.printf(message_template, "F", "Celsius", "Fahrenheit");

        conversionType = s.next();

        message_template = "Your choice: %s %nPlease enter the temperature in %s: ";
        if(conversionType.equalsIgnoreCase("C"))
        {
            System.out.printf(message_template, conversionType, "Fahrenheit");
        }
        else if (conversionType.equalsIgnoreCase("F"))
        {
            System.out.printf(message_template, conversionType, "Celsius");
        }

        temperature = s.nextDouble();
    }

    double convert()
    {
        if(conversionType.equalsIgnoreCase("C"))
        {
            convertedTemperature = Math.round((temperature - 32) * 5 / 9);
        }
        else if (conversionType.equalsIgnoreCase("F"))
        {
            convertedTemperature = Math.round((temperature * 9/5) + 32);
        }
        return convertedTemperature;
    }

    private void result()
    {
        String message_template = "The temperature in %s is %.0f.";

        if(conversionType.equalsIgnoreCase("C"))
        {
            System.out.printf(message_template, "Celsius", convertedTemperature);
        }
        else if (conversionType.equalsIgnoreCase("F"))
        {
            System.out.printf(message_template, "Fahrenheit", convertedTemperature);
        }
    }

    private void print(String message)
    {
        System.out.print(message);
    }

    public static void execute()
    {
        TemperatureConverter tc = new TemperatureConverter();
        tc.prompt();
        tc.convert();
        tc.result();
    }
}
