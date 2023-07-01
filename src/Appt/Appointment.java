package Appt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * An abstract Appointment class that creates an appointment with a description and a date.
 */
public abstract class Appointment
{
    private String description;
    protected Date appointmentDate;
    private static File myFile = new File("appointments.txt");
    private static int numberOfAppointments=0;

    /**
     * Constructs an object of type Appointment.
     * @param month the month of the date
     * @param day the day of the date
     * @param year the year of the date
     * @param description the description of the appointment
     */
    public Appointment(int month, int day, int year, String description)
    {
        this.description = description;
        appointmentDate = new Date(month, day, year);
    }

    /**
     * Gets the description of the appointment.
     * @return the appointment description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Sets the description of the appointment.
     * @param description the description to be used for the appointment
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Determines whether or not an appointment lies on a certain date.
     * @param month the months of the date to be checked
     * @param day the day of the date to be checked
     * @param year the year of the date to be checked
     * @return whether or not the appointment lands on that date
     */
    public abstract boolean occursOn(int month, int day, int year);

    /**
     * Gets the date for the next appointment.
     * @return the next appointment date
     */
    public abstract int[] getDateForNextAppointment();
    
    /**
     * Saves appointment information to a text file.
     * @throws FileNotFoundException 
     */
    public void save()
    {
    	try
    	{
			FileWriter myWriter = new FileWriter(Appointment.myFile, true);
			myWriter.write(this.toString());
			myWriter.close();
		}
    	catch(IOException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * Loads appointment information from a text file.
     */
    public String load()
    {
    	String myAppt = "";
    	try
    	{
			Scanner in = new Scanner(Appointment.myFile);
			while (in.hasNextLine())
			{
				String line = in.nextLine();
			    if(line.equals(this.appointmentDate.toString()))
			    {
			    	myAppt += line +"\r"+ in.nextLine() +"\r"+ in.nextLine() +"\r";
			    }
			}
		}
    	catch (FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return myAppt;
    }
    
    /**
     * Returns the data of the object in a string.
     * @return The data of the object in a string.
     */
    public String toString()
    {
    	return ("*" + Appointment.numberOfAppointments++ + "\r" + this.appointmentDate.toString() + "\r" + this.getDescription().toUpperCase()); 
    }
}
