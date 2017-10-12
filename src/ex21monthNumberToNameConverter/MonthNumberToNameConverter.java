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
                return Month.JANUARY.toString();
            case 2:
                return Month.FEBRUARY.toString();
            case 3:
                return Month.MARCH.toString();
            case 4:
                return Month.APRIL.toString();
            case 5:
                return Month.MAY.toString();
            case 6:
                return Month.JUNE.toString();
            case 7:
                return Month.JULY.toString();
            case 8:
                return Month.AUGUST.toString();
            case 9:
                return Month.SEPTEMBER.toString();
            case 10:
                return Month.OCTOBER.toString();
            case 11:
                return Month.NOVEMBER.toString();
            case 12:
                return Month.DECEMBER.toString();
            default:
                return "You must enter a number from 1 to 12. Try again.";
        }
   }
}
