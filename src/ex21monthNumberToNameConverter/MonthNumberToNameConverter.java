package ex21monthNumberToNameConverter;

/**
 * This program takes in a month number and returns the month name.  It returns
 * an error message if the number entered does not correspond to a month.
 * Constraints: Use a switch statement.
 * Created by Yasmin on 7/25/2017.
 */

public class MonthNumberToNameConverter
{
   enum Month
   {
       JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER,
       NOVEMBER, DECEMBER
   }

   public static String getMonthName(int number)
   {
        switch (number)
        {
            case 1:
            {
                return Month.JANUARY.toString();
            }
            case 2:
            {
                return Month.FEBRUARY.toString();
            }
        }
        return "You must enter a number from 1 to 12. Try again.";
   }
}
