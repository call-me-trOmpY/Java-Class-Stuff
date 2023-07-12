/*
Date: 09/22/2020
Juan Carlos Alfonso Vina
Class:  CITC 1314    -  Java Programming
Assignment: Lab 2 - 2
*/

import java.util.Scanner;

public class ValidatePassword_ {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Create a new Scanner
        System.out.println(" Enter Your Password:"); // Prompt the user to enter a password
        String str = input.nextLine();

        boolean validPassword = isValidPassword(str);

        if (validPassword != true) {
            System.out.println(str + " is an invalid password:");
        } else {
            System.out.println(str + " is valid password");
        }
    }

    /* Method to check if password is valid or not */

    public static boolean isValidPassword(String str) {

        boolean isValid = true;
        if (str.length() < 8) {
            System.out.println(" Password must be at least 8 characters");
            isValid = false;
        }
        if (str.equals(str.toLowerCase())) {
            System.out.println(" You need at least one upper case character");
            isValid = false;
        }
        if (str.equals(str.toUpperCase())) {
            System.out.println(" You need at least one lower case character");
            isValid = false;
        }

        if ((str.indexOf("0") <= 0)) {
            System.out.println(" You need to enter at least one numeric character");
            isValid = false;
        }else if ((str.indexOf("1") <= 0)) {
            System.out.println("You need to enter at least one numeric character");
            isValid = false;
        }else if ((str.indexOf("2") <= 0)) {
            System.out.println(" You need to enter at least one numeric character");
            isValid = false;
        } else if ((str.indexOf("3") <= 0)) {
            System.out.println(" You need to enter at least one numeric character");
            isValid = false;
        } else if ((str.indexOf("4") <= 0)) {
            System.out.println(" You need to enter at least one numeric character");
            isValid = false;
        } else if ((str.indexOf("5") <= 0)) {
            System.out.println(" You need to enter at least one numeric character");
            isValid = false;
        } else if ((str.indexOf("6") <= 0)) {
            System.out.println(" You need to enter at least one numeric character");
            isValid = false;
        } else if ((str.indexOf("7") <= 0)) {
            System.out.println(" You need to enter at least one numeric character");
            isValid = false;
        } else if ((str.indexOf("8") <= 0)) {
            System.out.println(" You need to enter at least one numeric character");
            isValid = false;
        } else if ((str.indexOf("9") <= 0)) {
            System.out.println(" You need to enter at least one numeric character");
            isValid = false;
        }

        

        return isValid;

    }

}