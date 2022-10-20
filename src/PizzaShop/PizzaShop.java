/*
Author: Colin Rualo
E-mail: cvr5614@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 2
Due date: Monday, 2/14/2022 (11:59 p.m. ET)
File: PizzaShop.java
Purpose: Java application that implements an online specialty pizza
 shop
Compiler/IDE:  Java 17.0.1/intelliJ IDEA 2021.3.1
Operating system: MacOS
Reference(s):  Savitch, 6th ed: chapter 4-5
https://www.w3schools.com/java/java_arraylist.asp
https://www.geeksforgeeks.org/constructors-in-java/
https://www.tutorialspoint.com/can-we-store-objects-in-an-array-in-java
https://stackoverflow.com/questions/32072534/using-user-input-to-create-a-new-object-java
https://www.javatpoint.com/understanding-toString()-method
https://www.geeksforgeeks.org/java-util-dictionary-class-java/
https://www.geeksforgeeks.org/java-arraylist-of-arrays/
https://www.baeldung.com/java-printstream-printf
https://stackoverflow.com/questions/32600365/formatting-tostring-method
*/
package PizzaShop;
import java.util.*;


public class PizzaShop {
    public static void main(String[] args) {

        Dictionary<String, Double> prices = new Hashtable<>();
        prices.put("Personal", 10.00);
        prices.put("Medium", 14.50);
        prices.put("Large", 19.00);
        prices.put("Extra Large", 23.50);


        double total = 0.00;
        int num_of_items = 0;
        ArrayList<String> fullOrder = new ArrayList<String>();
        System.out.println("Welcome to Alfredo's Pizza Cafe!");
        System.out.println();
        String type_input;
        String size_input;
        int quantity_input;
        Scanner scanner = new Scanner(System.in);
        do {
            displayPizzaMenu();
            System.out.println("Your choice (1-6)?");
            type_input = scanner.nextLine();
            while(!typeValid(type_input)) {
                System.out.println("Illegal entry.");
                System.out.println("Your choice (1-6)?");
                type_input = scanner.nextLine();
            }
        if(type_input.equals("6")){
            break;
        }
            if (typeValid(type_input)) {
                num_of_items += 1;
                OrderItem item = new OrderItem();
                switch (type_input) {
                    case "1" -> item.setType("Meat Lovers");
                    case "2" -> item.setType("Vegetarian");
                    case "3" -> item.setType("Hawaiian");
                    case "4" -> item.setType("Philly Steak");
                    case "5" -> item.setType("BBQ Chicken");
                }

                displaySizeMenu();
                System.out.println("Your choice (1-4)?");
                Scanner scanner2 = new Scanner(System.in);
                size_input = scanner2.nextLine();
                while(!sizeValid(size_input)) {
                    System.out.println("Illegal entry.");
                    System.out.println("Your choice (1-4)?");
                    size_input = scanner2.nextLine();
                }
                if (sizeValid(size_input)) {
                    switch (size_input) {
                        case "1" -> item.setSize("Personal");
                        case "2" -> item.setSize("Medium");
                        case "3" -> item.setSize("Large");
                        case "4" -> item.setSize("Extra Large");
                    }
                    System.out.println("Enter a quantity.");
                    Scanner scanner3 = new Scanner(System.in);
                    quantity_input = scanner3.nextInt();
                    while(!quantityValid(quantity_input)) {
                        System.out.println("Illegal entry.");
                        System.out.println("Enter a quantity (1-99).");
                        quantity_input = scanner3.nextInt();
                    }
                    if (quantityValid(quantity_input)) {
                        item.setQuantity(quantity_input);
                        item.setPrice(prices.get(item.getSize()) * item.getQuantity());
                        total += item.getPrice();
                        System.out.printf("Order total: $ %.2f\n", total);
                        fullOrder.add(item.toString());

                    }
                }

            }


        } while (/*!type_input.equals("6") &&*/ (type_input.equals("1") || type_input.equals("2")
                || type_input.equals("3") || type_input.equals("4") || type_input.equals("5")));


        System.out.println("""
                Order Summary:

                Type           Size          Quantity   Price
                -----------------------------------------------
                """);

        for (String i : fullOrder) { // loop through ArrayList fullOrder with for-each loop
            System.out.println(i);
        }
        System.out.printf("Order total: $ %.2f\n", total);

        String cash_or_cred, card_name, card_type,card_number;
        int card_month, card_year;
        ArrayList<String> card_list = new ArrayList<String>();
        card_list.add("Visa");
        card_list.add("MasterCard");
        card_list.add("American Express");
        card_list.add("Discover");


        System.out.println("How do you wish to pay for your order?" +
                " (Enter 1 for cash or 2 for credit):");
        Scanner scanner4 = new Scanner(System.in);
        cash_or_cred = scanner4.nextLine();
        while(!cash_or_credValid(cash_or_cred)){
            System.out.println("Illegal entry. Enter 1 for cash or 2 for credit:");
            cash_or_cred = scanner4.nextLine();
        }
        if(cash_or_cred.equals("2")){
            System.out.println("Please enter your payment information. \nCard holder name: ");
            Scanner scanner5 = new Scanner(System.in);
            card_name = scanner5.nextLine();
            System.out.println("Credit card type (Visa, MasterCard, American Express, Discover):");
            Scanner scanner6 = new Scanner(System.in);
            card_type = scanner6.nextLine().toUpperCase();
            while(!(card_type.equals("VISA") || card_type.equals("MASTERCARD") ||
                    card_type.equals("AMERICAN EXPRESS") || card_type.equals("DISCOVER"))){
                System.out.println("Illegal entry.");
                System.out.println("Credit Card type (Visa, MasterCard, American Express, Discover)");
                card_type = scanner6.nextLine().toUpperCase();
            }
            System.out.println("Credit Card number (e.g., 1234567892345678");
            Scanner scanner7 = new Scanner(System.in);
            card_number = scanner7.nextLine();
            while(card_number.length() != 16){ // edge case: card type is not a valid type
                System.out.println("Card number must have 16 digits. Please re-enter.");
                System.out.println("Credit Card type (Visa, MasterCard, American Express, Discover):");
                card_number = scanner7.nextLine();
            }
            System.out.println("Expiration date (e.g., 10/2026):");
            System.out.println("Enter expiration month (01-12)");
            Scanner scanner8 = new Scanner(System.in);
            card_month = scanner8.nextInt();
            while(!(card_month > 0 && card_month <= 12)) { // edge case: exp month is not a valid month
                System.out.println("Illegal entry. Enter month (01-12):");
                card_month = scanner8.nextInt();
            }
            System.out.println("Enter expiration year: ");
            Scanner scanner9 = new Scanner(System.in);
            card_year = scanner9.nextInt();
            while(!(card_year >= 2022 && card_year < 9999)) { // edge case: exp year is not a valid year
                System.out.println("Illegal entry. Enter expiration year: ");
                card_year = scanner9.nextInt();
            }
            System.out.println("Credit payment summary:");
            System.out.println();
            System.out.println("Customer name:  " + card_name);
            System.out.println("Payment amount:  $" + total);
            System.out.println("Card type: " + card_type);
            System.out.println("Card number:  ************" + card_number.substring(12));
            System.out.println("Exp date: " + card_month + "/" + card_year);
            }
        else if(cash_or_cred.equals("1")) {
            System.out.println("Cash payment summary:");
            System.out.printf("Payment amount: $ %.2f\n", total);
        }


        System.out.println("Thank you for visiting Alfredo's Pizza Cafe!");
        System.out.println("Come back soon!");
    }



    /** This method displays the pizza menu.
     *
     */
    public static void displayPizzaMenu () {
            System.out.println("Specialty Pizza Menu");
            System.out.println();
            System.out.println(""" 
                    1) Meat Lovers\s
                    2) Vegetarian\s
                    3) Hawaiian\s
                    4) Philly Steak\s
                    5) BBQ Chicken\s
                    6) Exit menu\s"""); // I don't know what these triple quotes mean but intelliJ offered it
        }

    /** This method displays the size menu.
     *
     */
        public static void displaySizeMenu () {
            System.out.println("Available Sizes and Prices");
            System.out.println();
            System.out.println("""
                    1) 10" Personal    - $10.00\040
                    2) 14" Medium      - $14.50\040
                    3) 16" Large       - $19.00\040
                    4) 18" Extra Large - $23.50\040
                            """);
        }

    /** This method checks if user input for pizza type is valid.
     *
     * @param type_input      user input for pizza type
     */
    public static boolean typeValid(String type_input) {
        if(type_input.equals("6")) return true;
        else return type_input.equals("1") || type_input.equals("2")
                || type_input.equals("3") || type_input.equals("4") || type_input.equals("5");
    }

    /** This method checks if user input for pizza size is valid.
     *
     * @param size_input      user input for pizza size
     */
    public static boolean sizeValid(String size_input) {
    return(size_input.equals("1") || size_input.equals("2")
            || size_input.equals("3") || size_input.equals("4"));
    }

    /** This method checks if user input for quantity is valid.
     *
     * @param quantity_input      user input for quantity
     */
    public static boolean quantityValid(int quantity_input) {
    return(quantity_input > 0 && quantity_input < 99);
    }

    /** This method checks if user input for cash or credit is valid.
     *
     * @param cash_or_cred      user input for cash or credit (1 or 2)
     */
    public static boolean cash_or_credValid(String cash_or_cred){
        return(cash_or_cred.equals("1") || cash_or_cred.equals("2"));
    }

}

