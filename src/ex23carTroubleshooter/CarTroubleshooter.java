package ex23carTroubleshooter;

/**
 * Ask a series of questions to help the user troubleshoot car problems.
 * Constraints: Don't ask for all input at once.
 * Created by Yasmin on 7/28/2017
 */
class CarProblems
{
    public boolean silent = false;
    public boolean corrodedBattery = false;
    public boolean clickingNoise = false;
    public boolean failToStart = false;
    public boolean deadEngine = false;
    public boolean fuelInjection = false;
}

public class CarTroubleshooter
{
    public static String troubleshoot(CarProblems cp)
    {
        if (cp.silent && cp.corrodedBattery)
        {
            return "Clean terminals and try starting again.";

        } else if (cp.silent)
        {
            return "Replace cables and try again.";

        } else if (cp.clickingNoise)
        {
            return "Replace the battery.";

        } else if (cp.failToStart)
        {
            return "Check spark plug connections.";

        } else if (cp.deadEngine && cp.fuelInjection)
        {
            return "Get it in for service.";

        } else if (cp.deadEngine)
        {
            return "Check to ensure the choke is opening and closing.";

        } else
        {
            return "Sorry, we have no suggestions for your problem.";
        }
    }
}


