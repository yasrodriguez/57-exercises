package ex23carTroubleshooter;

/**
 * Ask a series of questions to help the user troubleshoot car problems.
 * Constraints: Don't ask for all input at once.
 * Created by Yasmin on 7/28/2017
 */

public class CarTroubleshooter
{
   private boolean silent;
   private boolean corrodedBattery;
   private boolean clickingNoise;
   private boolean failToStart;
   private boolean deadEngine;
   private boolean fuelInjection;

   public CarTroubleshooter(boolean silent, boolean corrodedBattery, boolean clickingNoise,
                            boolean failToStart, boolean deadEngine, boolean fuelInjection)
   {
       this.silent = silent;
       this.corrodedBattery = corrodedBattery;
       this.clickingNoise = clickingNoise;
       this.failToStart = failToStart;
       this.deadEngine = deadEngine;
       this.fuelInjection = fuelInjection;
   }

   public String troubleshoot()
   {
       if (silent)
       {
           if (corrodedBattery)
           {
               return "Clean terminals and try starting again.";
           } else
           {
               return "Replace cables and try again.";
           }
       } else
       {
           if (clickingNoise)
           {
               return "Replace the battery.";
           } else
           {
               if (failToStart)
               {
                   return "Check spark plug connections.";
               } else
               {
                   if (deadEngine)
                   {
                       if (fuelInjection)
                       {
                           return "Get it in for service.";
                       } else
                       {
                           return "Check to ensure the choke is opening and closing.";
                       }
                   }
               }
           }
       }
    return "Sorry, we have no suggestions for your problem.";
   }
}
