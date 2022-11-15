package AP;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.Calendar;
import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
public class AP2 {
    public static Scanner scan1 = new Scanner(System.in);
    public static LocalDate now = LocalDate.now();
    public static LocalDate firstDay = now.with(firstDayOfYear());
    public static Calendar cal = Calendar.getInstance();

    public static void main(String[] args) {
        int choice;
        int year;

        do{
            display();
            choice = scan1.nextInt();

            switch(choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("\nPlease input a year");
                    year = scan1.nextInt();
                    if(isLeapYear(year)) {
                        System.out.println("\n" + year + " is a leap year \n");
                    }
                    else {
                        System.out.println("\n" + year + " is not a leap year\n");
                    }
                    break;
                case 2:
                    System.out.println("\nPlease input two years (lower then higher)");
                    int year1 = scan1.nextInt();
                    int year2 = scan1.nextInt();
                    System.out.println("\nThere are " + numberOfLeapYears(year1, year2) + " between " + year1 + " and " + year2 + "\n");
                    break;
                case 3:
                    System.out.println("\nPlease input a year");
                    year = scan1.nextInt();
                    switch(FirstDayOfYear(year)) {
                        case 0:
                            System.out.println("\nSunday is the first day of the year of " + year + "\n");
                            break;
                        case 1:
                            System.out.println("\nMonday is the first day of the year of " + year + "\n");
                            break;
                        case 2:
                            System.out.println("\nTuesday is the first day of the year of " + year + "\n");
                            break;
                        case 3:
                            System.out.println("\nWednesday is the first day of the year of " + year + "\n");
                            break;
                        case 4:
                            System.out.println("\nThursday is the first day of the year of " + year + "\n");
                            break;
                        case 5:
                            System.out.println("\nFriday is the first day of the year of " + year + "\n");
                            break;
                        case 6:
                            System.out.println("\nSaturday is the first day of the year of " + year + "\n");
                            break;
                    }
            }
        }
        while (choice != 0);
    }

    public static void display() {
        System.out.println("Select an option: \n"
        + "0: Exit \n"
        + "1: See if a year is a leap year \n"
        + "2: See how many leap years are between two years (including) \n"
        + "3: Find the weekday of the first day of a year");
    }
    
    private static boolean isLeapYear(int year) {
       // Returns true if year is a leap year and false otherwise.
       if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
       }
       else {
        return false;
       }
    }

    public static int numberOfLeapYears(int year1, int year2) {
        /** Returns the number of leap years between year1 and year2, inclusive.
        * Precondition: 0 <= year1 <= year2
        */ 
        int count = 0;
        for(int x = year1; x <= year2; x++) {
            if(x % 4 == 0 && x % 100 != 0 || x % 400 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int FirstDayOfYear(int year) {
        /** Returns the value representing the day of the week for the first day of year,
        * where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
        */
        return 0;
    }

    private static int dayOfYear(int month, int day, int year) {
        /** Returns n, where month, day, and year specify the nth day of the year.
        * Returns 1 for January 1 (month = 1, day = 1) of any year.
        * Precondition: The date represented by month, day, year is a valid date.
        */
        return 0;
    }

    public static int dayOfWeek(int month, int day, int year) {
        /** Returns the value representing the day of the week for the given date
        * (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
        * and 6 denotes Saturday.
        * Precondition: The date represented by month, day, year is a valid date.
        */
        return 0;
    }

}