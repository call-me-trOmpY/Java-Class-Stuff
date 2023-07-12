package labx;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;

import java.util.Date;
import java.util.Calendar;

/**
 * MiscUtil is class with miscellaneous methods that are useful to use
 * throughout java programming II
 *
 * @author Mister Programmer
 *
 */
public class MiscUtil
{

    public static void main(String[] args)
    {
        String test1 = "123";
        String test2 = "12X";
        System.out.println(test1 + " IsNumeric ? " + isNumeric(test1));
        System.out.println(test2 + " IsNumeric ? " + isNumeric(test2));

        try
        {
            Calendar cal1 = stringToCal("12/25/2020");
            LocalDate ld = calToLocalDate(cal1);
            Calendar cal2 = localdateToCal(ld);
            System.out.println("And now we are back to " + calToPrettyString(cal2));

            cal1 = flexibleStringToCal("1776/07/04 22:20:00");
            System.out.println("Both Date and time " + calTimeToPrettyString(cal1));
            System.out.println("Are the date equal? " + safeEquals(cal1, cal2));
            cal2 = flexibleStringToCal("1776/07/04 22:20:00");
            System.out.println("Are the date equal now? " + safeEquals(cal1, cal2));

            String s1 = "bob";
            String s2 = null;

            System.out.println("Is the first string empty " + isEmpty(s1));
            System.out.println("Is the second string empty " + isEmpty(s2));

            System.out.println("Are the strings equal? " + safeEquals(s1, s2));
            s2 = "b" + "ob";
            System.out.println("Are the strings equal now? " + safeEquals(s1, s2));

        }
        catch (Exception e)
        {
            e.printStackTrace(); // lazy way to see exception
        }

    }

    /*
     * This method will check to see if a String representation of a number
     * @param str May or not be a string representation of an integer value
     * @return true if it matches a numeric value, false otherwise
     */
    private static boolean isNumeric(String str)
    {
        if (str == null)
        {
            str = "";
        }
        return str.matches("[0-9]*");
    }

    /* This method will check to see if a String is all spaces or null.
     * @param rb this is the string to be checked for spaces.
     * @return returns a boolean value of true if the String is empty.
     *                 False if the
     *         string has a nonspace in it.
     */
    public static boolean isEmpty(String s)
    {
        boolean isIt = false;
        if (s == null)
        {
            isIt = true;
        }
        else if (s.trim().length() == 0)
        {
            isIt = true;
        }
        return isIt;
    }

    
    /**
     * Converts a Calendar to MM/dd/yyyy 
     *
     *
     * @param cal
     * @return String
     */    
    public static String calToPrettyString(Calendar cal)
    {
        String s = "";
        if (cal != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            s = sdf.format(cal.getTime());
        }
        return s;

    }
    
    /**
     * Converts a Calendar to MM/dd/yyyy hh:mm:ss aa string
     *
     *
     * @param cal
     * @return String
     */
    public static String calTimeToPrettyString(Calendar cal)
    {
        String s = "";
        if (cal != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
            s = sdf.format(cal.getTime());
        }
        return s;

    }

    /**
     * Converts a MM/dd/yyyy string to a Calendar object
     *
     *
     * @param strDate
     * @return Calendar
     * @throws java.lang.Exception
     */
    public static Calendar stringToCal(String strDate)
            throws Exception
    {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        Date date;
        Calendar cal = null;
        try
        {
            date = formatter.parse(strDate);
            cal = Calendar.getInstance();
            cal.setTime(date);
        }
        catch (ParseException e)
        {

            // System.out.println("Invalid date format ["+strDate+"]" + e);
            throw new Exception("Invalid date format [" + strDate + "]", e);
            //log.warn("Invalid date format ["+strDate+"]" + e);
        }
        return cal;
    }

    /**
     * Method localdateToCal
     *
     * Useful because in DatePicker returns a localDate
     *
     * @param localDate
     * @return
     */
    public static Calendar localdateToCal(LocalDate localDate)
    {
        Calendar cal = Calendar.getInstance();
        //Method 1
        Date date = java.sql.Date.valueOf(localDate);
        cal.setTime(date);
        // Method 2
        // localdate uses "real" month (e.g. 1-12 insted of 0-11)
        cal.set(Calendar.MONTH, localDate.getMonthValue() - 1);
        cal.set(Calendar.DATE, localDate.getDayOfMonth());
        cal.set(Calendar.YEAR, localDate.getYear());
        return cal;
    }

    /**
     * Method calToLocalDate
     *
     * demonstrates how to convert calendar to LocalDate
     *
     * @param cal
     * @return
     */
    public static LocalDate calToLocalDate(Calendar cal)
    {
        // Method 1
        //Date dt = cal.getTime();
        //LocalDate ld = new java.sql.Date(dt.getTime()).toLocalDate();
        // Method 2
        // localDate wants "real" month
        LocalDate ld = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
        return ld;

    }

    
    /**
     * A flexible method for converting multiple date format strings
     * into a Calendar object
     *
     * @param strDate
     * @return Calendar
     */    
    public static Calendar flexibleStringToCal(String strDate)
            throws Exception
    {
        String dateFormat = "";
        String[] DATE_FORMAT =
        {
            "yyyy-MM-dd HH:mm:ss.S",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy/MM/dd HH:mm:ss.S",
            "yyyy/MM/dd HH:mm:ss",
            "MM/dd/yyyy HH:mm:ss.S",
            "MM/dd/yyyy HH:mm:ss",
            "MM/dd/yyyy",
            "yyyy/MM/dd"
        };

        String[] DATE_REG_EXPR =
        {
            "[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9].[0-9]",
            "[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9]",
            "[0-9][0-9][0-9][0-9]/[0-9][0-9]/[0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9].[0-9]",
            "[0-9][0-9][0-9][0-9]/[0-9][0-9]/[0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9]",
            "[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9].[0-9]",
            "[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9]",
            "[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]",
            "[0-9][0-9][0-9][0-9]/[0-9][0-9]/[0-9][0-9]"
        };

        for (int i = 0; i < DATE_FORMAT.length; i++)
        {
            if (strDate.matches(DATE_REG_EXPR[i]))
            {
                //System.out.println(strDate + " matches format: "+DATE_FORMAT[i]);
                dateFormat = DATE_FORMAT[i];
                break;
            }
        }

        DateFormat formatter = new SimpleDateFormat(dateFormat);

        Date date;
        Calendar cal = null;
        try
        {
            date = formatter.parse(strDate);
            cal = Calendar.getInstance();
            cal.setTime(date);
        }
        catch (ParseException e)
        {

            // System.out.println("Invalid date format ["+strDate+"]" + e);
            throw new Exception("Invalid date format [" + strDate + "]", e);
            //log.warn("Invalid date format ["+strDate+"]" + e);
        }
        return cal;
    }

    /**
     * This method will convert Calendar to Timestamp
     *
     * @param cal
     * @return java.sql.Timestamp
     */
    protected static java.sql.Timestamp calToSqlTimestamp(Calendar cal)
    {
        java.sql.Timestamp timestamp = null;
        if (cal != null)
        {
            timestamp = new java.sql.Timestamp(cal.getTime().getTime());
        }
        return timestamp;
    }

    /**
     * A null safe equal comparison
     * <p>
     * Performs the same function as string.equals(string s1), except that it
     * will perform proper null checks and avoid a null pointer exception
     *
     * @param s1
     * @param s2
     * @return true if equal (including both null)
     */
    public static boolean safeEquals(Object s1, Object s2)
    {
        boolean areEqual = false;
        if ((s1 == null) && (s2 == null))
        {
            areEqual = true;
        }
        else if ((s1 != null) && (s2 != null))
        {
            areEqual = s1.equals(s2);
        }
        //else  // only one of two is null
        //{
        //    areEqual = false;
        // }

        return areEqual;

    }

    /**
     * A null safe equal comparison
     * <p>
     * Performs the same function as string.equals(string s1), except that it
     * will perform proper null checks and avoid a null pointer exception
     *
     * @param c1
     * @param c2
     * @return true if equal (including both null)
     */
    public static boolean safeEquals(Calendar c1, Calendar c2)
    {
        boolean areEqual = false;
        if ((c1 == null) && (c2 == null))
        {
            areEqual = true;
        }
        else if ((c1 != null) && (c2 != null))
        {
            areEqual = c1.equals(c2);
        }
        //else  // only one of two is null
        //{
        //    areEqual = false;
        //}

        return areEqual;

    }

}
