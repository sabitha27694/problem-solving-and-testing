class Solution {
    private static final String[] DAYS_OF_WEEK = {
        "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"
    };
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String dayOfTheWeek(int day, int month, int year) {
        int totalDays = 0;

        // Add days for years from 1971 up to year - 1
        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        // Add days for months in the current year
        for (int m = 1; m < month; m++) {
            totalDays += DAYS_IN_MONTH[m];
            if (m == 2 && isLeapYear(year)) {
                totalDays += 1;
            }
        }

        // Add days in the current month
        totalDays += (day - 1);

        return DAYS_OF_WEEK[totalDays % 7];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}