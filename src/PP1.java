/* Author: Colin Rualo
        E-mail: cvr5614@psu.edu
Course: CMPSC 221
        Assignment: Programming Assignment 1
        Due date: 1/28/2022
        File: PP1.java
        Purpose: Java application that implements a simple Vehicle
        Identification Number (VIN) decoder
        Compiler/IDE:  IntelliJ IDEA
        Operating system: Mac OS
        Reference(s):  Java 15 API - Oracle Documentation
        https://www.w3schools.com/java/java_switch.asp

        https://en.wikipedia.org/wiki/Vehicle_identification_number#Model_year_encoding

        https://www.homeandlearn.co.uk/java/java_formatted_strings.html

        https://docs.oracle.com/javase/7/docs/api/java/lang/String.html

        https://www.geeksforgeeks.org/gfact-51-java-scanner-nextchar/

        https://www.tutorialspoint.com/Java-String-substring-Method-example

        https://www.tutorialspoint.com/check-if-the-string-contains-only-unicode-letters-or-digits-in-java#:~:text=To%20check%20whether%20a%20String,a%20letter%20or%20a%20digit.

        https://www.tutorialspoint.com/check-if-the-string-contains-only-unicode-letters-digits-or-space-in-java

        https://www.w3schools.com/java/ref_string_charat.asp

        https://www.geeksforgeeks.org/character-isletterordigit-in-java-with-examples/


 */
import java.util.Scanner;

public class PP1 {
    public static void main(String[] args) {
        boolean stop = false;
        while(!stop) {
            Scanner myObj = new Scanner(System.in); // for VIN string
            Scanner scan = new Scanner(System.in); // for when they answer Y or N

            System.out.println("Please enter a string representing a Vehicle Identification Number (VIN): ");
            String vin = myObj.nextLine();
            if (checkVinLength(vin) && checkValidChar(vin)) {
                System.out.println("VIN is valid. Decoding in progress...");
                vinValues(vin); // call functions to display VIN details
                vehicleAttributes(vin);

                System.out.println("Enter another VIN? (Y/N)");
                String s = scan.next();
                s = s.toUpperCase();

                if(!s.equals("Y")){ stop = true; // if their input is not Y, the loop stops
                System.out.println("Thanks for using my VIN decoder!");
                }
            }
            else{ // even if the VIn string is invalid, ask if they want to enter another
                System.out.println("Enter another VIN? (Y/N)");
                String s = scan.next();
                s = s.toUpperCase();
                if(!s.equals("Y")){ stop = true; // if their input is not Y
                    System.out.println("Thanks for using my VIN decoder!");}
            }
        }
    }



    /** This method checks a VIN string for valid length.
     *
     * @param vin   The vin to check
     * @return      True if the length is valid, false otherwise
     */
    public static boolean checkVinLength(String vin)
    {
        int vin_length = vin.replace(" ","").length();
        if(vin_length != 17) {
            System.out.println("** VIN must contain 17 characters. ** ");
            return false;
        }else return true;
    }

    /** This method checks a VIN string for valid characters (numbers or letters).
     *
     * @param vin   The vin to check
     * @return      True if all characters are valid, false otherwise
     */
    public static boolean checkValidChar(String vin){
        int vin_length = vin.length();

        for(int i = 0; i < vin_length; i++) {
            // checks whether the character is neither a letter nor a digit and not even a space
            // if it is neither a letter nor a digit and not even a space then it will return false
            if ((!Character.isLetterOrDigit(vin.charAt(i))) && vin.charAt(i) != ' ') {
                System.out.println("** VIN can only contain letters and digits. ** ");
                return false;
            }
        }
        return true;
    }

    /** This method reads certain substrings of the VIN string to identify WMI, VDS, and VIS.
     *
     * @param vin   The vin to check
     */

    public static void vinValues(String vin){
        int vin_length = vin.replace(" ","").length(); // deletes whitespaces
        String wmi = vin.substring(0,3);
        String vds = vin.substring(3,9); // reads from string value 3 to 9, including 3 but not 9
        String vis = vin.substring(9,17);
        System.out.println("Values by group:");
        System.out.printf("%-40s%-15s%n", "   World Manufacturer Identifier (WMI): ", wmi.toUpperCase());
        System.out.printf("%-40s%-15s%n", "   Vehicle Descriptor Section (VDS): ", vds.toUpperCase());
        System.out.printf("%-40s%-15s%n", "   Vehicle Identifier Section (VIS): ", vis.toUpperCase());

    }

    /** This method reads certain substrings or characters of the VIN string to identify vehicle attributes.
     *
     * @param vin   The vin to check
     */
    public static void vehicleAttributes(String vin){
        int vin_length = vin.replace(" ","").length();
        String country_of_manufacture = "United States";
        String manufacturer = "Chrysler";
        char check_digit = vin.charAt(8);
        int model_year = 2000;
        String serial_number = vin.substring(11,17);
        switch (vin.charAt(0)) {
            case '1', '4', '5' -> country_of_manufacture = "United States";
            case '2' -> country_of_manufacture = "Canada";
            case '3' -> country_of_manufacture = "Mexico";
            case 'J', 'j' -> country_of_manufacture = "Japan";
            case 'S' , 's' -> country_of_manufacture = "United Kingdom";
            case 'W', 'w' -> country_of_manufacture = "Germany";
        }
        switch (vin.charAt(1)) {
            case 'C', 'c' -> manufacturer = "Chrysler";
            case 'F','f' -> manufacturer = "Ford";
            case 'G','g' -> manufacturer = "General Motors";
            case 'H','h' -> manufacturer = "Honda";
            case 'T','t' -> manufacturer = "Toyota";
            case 'B','b' -> manufacturer = "BMW";
            case 'A','a' -> manufacturer = "Jaguar";
            case 'D','d' -> manufacturer = "Mercedes";
        }
        switch (vin.charAt(9)){
            case 'Y','y' -> model_year = 2000;
            case '1' -> model_year = 2001;
            case '2' -> model_year = 2002;
            case '3' -> model_year = 2003;
            case '4' -> model_year = 2004;
            case '5' -> model_year = 2005;
            case '6' -> model_year = 2006;
            case '7' -> model_year = 2007;
            case '8' -> model_year = 2008;
            case '9' -> model_year = 2009;
            case 'A','a' -> model_year = 2010;
            case 'B','b' -> model_year = 2011;
            case 'C','c' -> model_year = 2012;
            case 'D','d' -> model_year = 2013;
            case 'E','e' -> model_year = 2014;
            case 'F','f' -> model_year = 2015;
            case 'G','g' -> model_year = 2016;
            case 'H','h' -> model_year = 2017;
            case 'J','j' -> model_year = 2018;
            case 'K','k' -> model_year = 2019;
            case 'L','l' -> model_year = 2020;
            case 'M','m' -> model_year = 2021;
            case 'N','n' -> model_year = 2022;


        }
        System.out.println("Vehicle Attributes:");
        System.out.printf("   %-30s%-15s%n", "Country of manufacture: ", country_of_manufacture);
        System.out.printf("   %-30s%-15s%n", "Manufacturer: ", manufacturer);
        System.out.printf("   %-30s%-15s%n", "Check digit: ", check_digit);
        System.out.printf("   %-30s%-15s%n", "Model year: ", model_year);
        System.out.printf("   %-30s%-15s%n", "Serial number: ", serial_number);

    }
}
