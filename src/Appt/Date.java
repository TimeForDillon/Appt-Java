package Appt;
/**
 * Creates a date that can do certain date-type tasks.
 */
public class Date
{
    public static final int[] DAYS_OF_EACH_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int[] date = new int[3];//Holds original month, day, & year
    int[] newDate = new int[3];//Current (increased) date in order of month, day, & year

    /**
     * Constructs a date.
     * @param month the month for the date
     * @param day the day for the date
     * @param year the year for the date
     */
    Date(int month, int day, int year)
    {
        if (! checkForValidDate(month, day, year))
        {
            System.out.println("Error - Invalid date");
            System.exit(1);
        }

        date[0] = month;
        date[1] = day;
        date[2] = year;

        newDate[0] = month;
        newDate[1] = day;
        newDate[2] = year;
    }

    /**
     * Checks to see if the date is a leap year.
     * @param year the year that's being checked
     * @return whether or not that year is a leap year
     */
    public static boolean isLeapYear(int year)
    {
        if (year % 4 == 0)
        {
            return year % 100 != 0 || year % 400 == 0;
        }

        return false;
    }

    /**
     * Checks whether or not a specific date is valid
     * @param theMonth the month of the date being checked
     * @param theDay the day of the date being checked
     * @param theYear the year of the date being checked
     * @return whether or not the date is a valid date
     */
    public static boolean checkForValidDate(int theMonth, int theDay, int theYear)
    {
        if (theMonth < 1 || theMonth > 12 || theYear < 0 || theYear > 10000)
            return false;

        if (theMonth == 2 && theDay == 29 && isLeapYear(theYear))
            return true;

        return theDay >= 1 && theDay <= DAYS_OF_EACH_MONTH[theMonth - 1];
    }

    /**
     * Gets the original date that was passed into this class from the constructor.
     * @return the original (start) date
     */
    public int[] getOldDate()
    {
        return date;
    }

    /**
     * Gets the current date that is contained in the object of this class.
     * @return returns the current date that the object of this class is currently at
     */
    public int[] getCurrentDate()
    {
        return newDate;
    }

    /**
     * Increases the date by a specific number of days and months.
     * @param daysAfter Used to calculate a date that's 'daysAfter' days after the previous
     * @param monthsAfter Used to calculate a date that's 'monthsAfter' days after the previous
     */
    public void increaseDate(int daysAfter, int monthsAfter)
    {
        if (daysAfter < 0 || monthsAfter < 0)
        {
            System.out.println("Error - Invalid parameter(s)");
            System.exit(1);
        }

        for (int i = 0; i < monthsAfter/12; i++)
            newDate[2]++;

        newDate[0] += monthsAfter;
        newDate[0] = newDate[0] % 12;

        if (newDate[0] == 0)
            newDate[0] = 12;

        if (newDate[0] == 1 && monthsAfter < 12)
            newDate[2]++;

        int num;
        if (newDate[0] - 1 == 2 && isLeapYear(newDate[2]))
            num = 29;
        else
            num = DAYS_OF_EACH_MONTH[newDate[0] - 1];

        if (newDate[1] + daysAfter > num)
        {
            daysAfter = newDate[1] + daysAfter - num;
            newDate[0] += 1;
            newDate[0] = newDate[0] % 12;

            if (newDate[0] == 0)
                newDate[0] = 12;

            if (newDate[0] == 1)
                newDate[2]++;

            if (daysAfter > num)
            {
                System.out.println("Error - The value for daysAfter is too long!");
                System.exit(1);
            }

            newDate[1] = daysAfter;
        }
        else
        {
            newDate[1] += daysAfter;
        }
    }

    /**
     * Checks whether or not the implicit parameter Date is greater than or equal to the explicit parameter of the same class.
     * @param date2 the object of this class that's being compared to
     * @return true if the implicit parameter Date is higher than or the same as the explicit parameter Date and false otherwise
     */
    public boolean greaterThanOrEquals(Date date2)
    {
        if (newDate[2] < date2.getCurrentDate()[2])
            return false;
        else if (newDate[2] > date2.getCurrentDate()[2])
            return true;

        if (newDate[0] < date2.getCurrentDate()[0])
            return false;
        else if (newDate[0] > date2.getCurrentDate()[0])
            return true;

        return newDate[1] >= date2.getCurrentDate()[1];
    }

    /**
     * Checks whether or not two dates are completely the same.
     * @param date2 the second date being compared to (the first one is 'this.' one)
     * @return whether or not the two dates are the same
     */
    public boolean equals(Date date2)
    {
        return (newDate[2] == date2.getCurrentDate()[2] && newDate[1] == date2.getCurrentDate()[1]
                && newDate[0] == date2.getCurrentDate()[0]);
    }

    /**
     * Returns the data of the object in a string.
     * @return The data of the object in a string.
     */
    public String toString()
    {
    	return (this.date[0] + "/" + this.date[1] + "/" + this.date[2]);
    }
}
