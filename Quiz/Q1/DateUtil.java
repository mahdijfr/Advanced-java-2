import java.util.regex.*;

public class DateUtil
{
    public static String getJalaliMonthName(int number)
    {
        String[] monthNames = {
            "Farvardin",
            "Ordibehesht",
            "Khordad",
            "Tir",
            "Mordad",
            "Shahrivar",
            "Mehr",
            "Aban",
            "Azar",
            "Dey",
            "Bahman",
            "Esfand"
        };
        
        while(number > 0 && number < 13) {
            return monthNames[number - 1];
        }
        return "Invalid month number";
    }

    /**
     * Check if string is a valid date in YYYY/mm/dd format
     * It is assumed that all months have 30 days
     * @param date date in string format
     * @return true if the string is a valid date in YYYY/mm/dd format
     */
    public static boolean isValidDate(String date) {
        return  Pattern.matches("^(\\d{4})/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|30)$", date);
        
    }
}