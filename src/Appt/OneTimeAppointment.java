package Appt;
import java.util.Arrays;

/**
 * A one time appointment class that is a subclass of the Appointment class
 */
public class OneTimeAppointment extends Appointment
{
    /**
     * Constructs an object of type OneTimeAppointment.
     * @param month the month of the date
     * @param day the day of the date
     * @param year the year of the date
     * @param description the description of the appointment
     */
    OneTimeAppointment(int month, int day, int year, String description)
    {
        super(month, day, year, description);
    }

    /**
     * Determines whether or not an appointment lies on a certain date.
     * @param month the months of the date to be checked
     * @param day the day of the date to be checked
     * @param year the year of the date to be checked
     * @return whether or not the appointment lands on that date
     */
    public boolean occursOn(int month, int day, int year)
    {
        int[] checkDate = {month, day, year};

        return Arrays.equals(checkDate, appointmentDate.getCurrentDate());
    }

    /**
     * Gets the date for the next appointment.
     * @return the next appointment date
     */
    public int[] getDateForNextAppointment()
    {
        return appointmentDate.getCurrentDate();
    }
    
    /**
     * Returns the data of the object in a string.
     * @return The data of the object in a string.
     */
    public String toString()
    {
    	return super.toString() + "\rONE TIME APPOINTMENT\r";
    }
}
