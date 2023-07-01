//Lab 6 Project 9.5
//Asa Barton & Dillon Welsh
//Files: AppointmentTester.java, Date2.java, Appointment.java, OneTimeAppointment.java,
//       WeeklyAppointment.java, MonthlyAppointment.java
package Appt;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Tests the Appointment class and its subclasses, as well as the Date class.
 */
public class AppointmentTester
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();

        char symbol = 'Y';
        String description, temp;

        int[] startDates = new int[3];
        int[] tempDates = new int[3];
        int choice;

        while (symbol == 'y' || symbol == 'Y')
        {
            System.out.println("Welcome! Enter the type of appointment you would like to add.");
            System.out.println("1 - A one-time appointment");
            System.out.println("2 - A weekly appointment");
            System.out.println("3 - A monthly appointment");
            choice = in.nextInt();

            //Validation
            while (choice < 1 || choice > 3)
            {
                System.out.println("Error - Please enter a valid number from 1-3");
                choice = in.nextInt();
            }

            if (choice == 1)//One-time appointment
            {
                System.out.println("Enter the start date for your one-time appointment.");

                System.out.print("Month number (1-12): ");
                startDates[0] = in.nextInt();

                System.out.print("Day of month: ");
                startDates[1] = in.nextInt();

                System.out.print("Year: ");
                startDates[2] = in.nextInt();

                System.out.println("Enter the description of your appointment");
                temp = in.nextLine();
                description = in.nextLine();

                appointments.add(new OneTimeAppointment(startDates[0], startDates[1], startDates[2], description));
            }
            else if (choice == 2)
            {
                System.out.println("Enter the start date for your weekly appointment.");

                System.out.print("Month number (1-12): ");
                startDates[0] = in.nextInt();

                System.out.print("Day of month: ");
                startDates[1] = in.nextInt();

                System.out.print("Year: ");
                startDates[2] = in.nextInt();

                System.out.println("Enter the description of your appointment");
                temp = in.nextLine();
                description = in.nextLine();

                appointments.add(new WeeklyAppointment(startDates[0], startDates[1], startDates[2], description));
            }
            else
            {
                System.out.println("Enter the start date for your monthly appointment.");

                System.out.print("Month number (1-12): ");
                startDates[0] = in.nextInt();

                System.out.print("Day of month: ");
                startDates[1] = in.nextInt();

                System.out.print("Year: ");
                startDates[2] = in.nextInt();

                System.out.println("Enter the description of your appointment");
                temp = in.nextLine();
                description = in.nextLine();

                appointments.add(new MonthlyAppointment(startDates[0], startDates[1], startDates[2], description));
            }

            System.out.println("Your appointment has been entered into the system!");
            System.out.println("\nWould you like to enter in another appointment?");
            symbol = in.next().charAt(0);
        }

        for(int i = 0; i<appointments.size(); i++)
        {
        	appointments.get(i).save();
        }

        //********************************************

        symbol = 'Y';
        while (symbol == 'y' || symbol == 'Y')
        {
            System.out.println("Enter the number corresponding to the appointment you would like to access.");

            for (int i = 0; i < appointments.size(); i++)
            {
                System.out.print((i+1) + " - ");
                System.out.println(appointments.get(i).getDescription());
            }

            choice = in.nextInt();

            while (choice < 1 || choice > appointments.size())
            {
                System.out.println("Error - Please enter a number from 1 to " + appointments.size());
            }
            choice--;

            System.out.println("Enter any date to see if your appointment will occur on that date.");

            System.out.print("Month number (1-12): ");
            tempDates[0] = in.nextInt();

            System.out.print("Day of month: ");
            tempDates[1] = in.nextInt();

            System.out.print("Year: ");
            tempDates[2] = in.nextInt();

            if (appointments.get(choice).occursOn(tempDates[0], tempDates[1], tempDates[2]))
            {
                System.out.println("Yes, you have an appointment on that day!");
                System.out.println(appointments.get(choice).load());
            }
            else
            {
                System.out.println("No, you do not have an appointment on that day. Your next appointment from that date\n" +
                        "would be on " + Arrays.toString(appointments.get(choice).getDateForNextAppointment()));
            }

            System.out.println("\nWould you like to access another appointment?");
            symbol = in.next().charAt(0);
        }
    }
}

/*
Sample Run:

Welcome! Enter the type of appointment you would like to add.
1 - A one-time appointment
2 - A weekly appointment
3 - A monthly appointment
2
Enter the start date for your weekly appointment.
Month number (1-12): 3
Day of month: 20
Year: 2021
Enter the description of your appointment
Go to the grocery store
Your appointment has been entered into the system!

Would you like to enter in another appointment?
yes
Welcome! Enter the type of appointment you would like to add.
1 - A one-time appointment
2 - A weekly appointment
3 - A monthly appointment
1
Enter the start date for your one-time appointment.
Month number (1-12): 4
Day of month: 20
Year: 2021
Enter the description of your appointment
Go to the dentist
Your appointment has been entered into the system!

Would you like to enter in another appointment?
yes
Welcome! Enter the type of appointment you would like to add.
1 - A one-time appointment
2 - A weekly appointment
3 - A monthly appointment
3
Enter the start date for your monthly appointment.
Month number (1-12): 5
Day of month: 1
Year: 2021
Enter the description of your appointment
Perform automobile maintenance
Your appointment has been entered into the system!

Would you like to enter in another appointment?
no
Enter the number corresponding to the appointment you would like to access.
1 - Go to the grocery store
2 - Go to the dentist
3 - Perform automobile maintenance
2
Enter any date to see if your appointment will occur on that date.
Month number (1-12): 4
Day of month: 7
Year: 2021
No, you do not have an appointment on that day. Your next appointment from that date
would be on [4, 20, 2021]

Would you like to access another appointment?
yes
Enter the number corresponding to the appointment you would like to access.
1 - Go to the grocery store
2 - Go to the dentist
3 - Perform automobile maintenance
1
Enter any date to see if your appointment will occur on that date.
Month number (1-12): 5
Day of month: 21
Year: 2001
No, you do not have an appointment on that day. Your next appointment from that date
would be on [3, 20, 2021]

Would you like to access another appointment?
yes
Enter the number corresponding to the appointment you would like to access.
1 - Go to the grocery store
2 - Go to the dentist
3 - Perform automobile maintenance
3
Enter any date to see if your appointment will occur on that date.
Month number (1-12): 7
Day of month: 1
Year: 2021
Yes, you have an appointment on that day!

Would you like to access another appointment?
no

*/


