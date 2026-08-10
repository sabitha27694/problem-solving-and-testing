import java.time.LocalDate;
import java.util.Calendar;

class Result {

    public static String findDay(int month, int day, int year) {
        Calendar cal = Calendar.getInstance();
        // Calendar months are 0-indexed (0 = January, 7 = August)
        cal.set(year, month - 1, day);
        
        String[] days = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        return days[cal.get(Calendar.DAY_OF_WEEK) - 1];
    }

}