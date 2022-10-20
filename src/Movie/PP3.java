/*
Author: Colin Rualo
E-mail: cvr5614@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 3
Due date: Monday, 2/28/2022 (11:59 p.m. ET)
File: PP3.java
Purpose: Java application that implements a driver to demonstrate the
 functionality of a base class (Movie) and its derived class (AwardWinningMovie)
Compiler/IDE:  Java 17.0.1/intelliJ IDEA 2021.3.1
Operating system: MacOS
Reference(s):  Savitch, 6th Edition: Chapter 9 (exception handling)
https://www.w3schools.com/java/java_inheritance.asp
https://www.w3schools.com/java/ref_string_contains.asp
https://www.youtube.com/watch?v=GlTvLWJxBWM
https://www.w3schools.com/java/ref_string_contentequals.asp
https://java-programming.mooc.fi/part-4/2-objects-in-a-list
https://www.w3schools.com/java/java_try_catch.asp

*/
package Movie;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PP3 {
    public static void main(String[] args) {
        ArrayList<AwardWinningMovie> movie_database = new ArrayList<>();
        AwardWinningMovie a = new AwardWinningMovie("Forrest Gump", "PG-13", "Drama",
                "Robert Zemeckis", "Tom Hanks",
                "Oscar for Best Picture", 1995);
        AwardWinningMovie b = new AwardWinningMovie("The Godfather", "R", "Crime",
                "Francis Ford Cappola", "Marlon Brando",
                "Oscar for Best Picture", 1973);
        AwardWinningMovie c = new AwardWinningMovie("Inception", "PG-13", "Action",
                "Christopher Nolan", "Christian Bale",
                "Oscar for Best Achievement in Cinematography", 2011);
        AwardWinningMovie d = new AwardWinningMovie("Cars", "G", "Animation",
                "John Lasseter", "Owen Wilson",
                "Saturn Award for Best Animated Film", 2006);
        AwardWinningMovie e = new AwardWinningMovie("Scream", "R", "Horror",
                "Wes Craven", "Neve Campbell",
                "Saturn Award for Best Horror Film", 1996);
        AwardWinningMovie f = new AwardWinningMovie("The Hangover", "R", "Comedy",
                "Todd Phillips", "Zach Galifianakis",
                "AFI Award for Movie of the Year", 2010);
        AwardWinningMovie g = new AwardWinningMovie("Avengers: Infinity War", "PG-13", "Action",
                "Anthony Russo", "Robert Downey Jr.",
                "Saturn Award for Best Supporting Actor: Josh Brolin", 2019);
        AwardWinningMovie h = new AwardWinningMovie("Hamilton", "PG-13", "Biography",
                "Thomas Kail", "Lin-Manuel Miranda",
                "Primetime Emmy for Outstanding Variety Special", 2021);
        AwardWinningMovie i = new AwardWinningMovie("Titanic", "PG-13", "Romanca",
                "James Cameron", "Leonardo DiCaprio",
                "Oscar for Best Picture", 1998);
        AwardWinningMovie j = new AwardWinningMovie("Harry Potter and the Goblet of Fire", "PG-13",
                "Adventure", "Mike Newell", "Daniel Radcliffe",
                "BAFTA Film Award for Best Production Design", 2006);
        AwardWinningMovie k = new AwardWinningMovie("X-Men: Days of Future Past", "PG-13",
                "Action", "Bryan Singer", "Patrick Stewart",
                "Empire Award for Best Sci-fi/Fantasy", 2015);
        movie_database.add(a);
        movie_database.add(b);
        movie_database.add(c);
        movie_database.add(d);
        movie_database.add(e);
        movie_database.add(f);
        movie_database.add(g);
        movie_database.add(h);
        movie_database.add(i);
        movie_database.add(j);
        movie_database.add(k);
        System.out.println("""
                    EXPERIMENTAL AWARD-WINNING MOVIE DATABASE*\s
                    ------------------------------------------\s
                          (*Funded in part by IMDb.com)\s
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\s
                    Please note that movie titles are displayed alphabetically by default.\s
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\s
                    \s""");
        boolean done4 = false;
        while(!done4) {

            System.out.println("""
                    Select an option from the menu below.\s
                          1) Display a list of popular movies\s
                          2) Search the database\s
                          3) Quit\s""");

            int menu1 = 10, menu2 = 1;
            String yes_or_no1, search_input1, search_input2, search_input3;
            Scanner scanner = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);
            Scanner scanner4 = new Scanner(System.in);
            Scanner scanner5 = new Scanner(System.in);
            Scanner scanner6 = new Scanner(System.in);
            boolean done = false;
            boolean done2 = false;
            boolean done5 = false;
            boolean done6 = false;
            do {
                try {
                    System.out.println("Your choice (1-3)?");
                    menu1 = scanner.nextInt();
                } catch (InputMismatchException exception) {

                    System.out.println("Exception: java.util.InputMismatchException \n" +
                            "Menu choice must be an integer. Please try again. ");
                    done = true;
                    scanner.nextLine();
                }
                if (menu1 == 3) {
                    done4 = true;
                    break;
                }
                if (menu1 == 1) {
                    boolean done3 = false;
                    while (!done3) {
                        System.out.println("""
                                Selected award-winning movies:\s
                                 1) Avengers: Infinity War\s
                                 2) Cars\s
                                 3) Forrest Gump\s
                                 4) Hamilton\s
                                 5) Inception\s
                                 6) The Godfather\s
                                 7) The Hangover\s
                                 8) X-Men: Days of Future Past\s
                                 """);
                        do {
                            done2 = false;
                            try {
                                System.out.println("Please enter the number of the movie" +
                                        " you would like to know more about: ");
                                menu2 = scanner2.nextInt();
                            } catch (InputMismatchException exception) {
                                System.out.println("Exception: java.util.InputMismatchException \n" +
                                        "Movie choice must be an integer. Please try again. ");
                                done2 = true;
                                scanner2.nextLine();
                            }
                        } while (done2);

                        while (menu2 <= 0 || menu2 > 8) {
                            System.out.println("** You must enter a number from 1 through 8! ** ");
                            System.out.println("Your choice (1-8)?");
                            menu2 = scanner2.nextInt();
                        }
                        switch (menu2) {
                            case 1 -> System.out.println(g);
                            case 2 -> System.out.println(d);
                            case 3 -> System.out.println(a);
                            case 4 -> System.out.println(h);
                            case 5 -> System.out.println(c);
                            case 6 -> System.out.println(b);
                            case 7 -> System.out.println(f);
                            case 8 -> System.out.println(k);
                        }
                        System.out.print("Inquire about another movie (Y/N)? ");

                        Scanner scanner3 = new Scanner(System.in);
                        yes_or_no1 = scanner3.nextLine().toUpperCase();
                        while (!(yes_or_no1.equals("Y") || yes_or_no1.equals("N"))) {
                            System.out.println("** Invalid choice! Please enter Y or N. ** ");
                            yes_or_no1 = scanner3.nextLine().toUpperCase();
                        }
                        if (yes_or_no1.equalsIgnoreCase("N")){
                            done3 = true;
                        }
                    }
                }
                //If the user chooses 2, the program asks the user if s/he wants to search by title or star, then
                //prompts the user to enter an appropriate search term. If the search term is found, the program
                //displays the requested information; otherwise, an appropriate message is displayed. The
                //program then returns to the main menu.
                else if(menu1 == 2){
                    System.out.print("Type T to search by title or S to search by star: ");
                    search_input1 = scanner4.nextLine().toUpperCase();
                    while(!(search_input1.equals("T") || search_input1.equals("S"))){
                        System.out.println("** Invalid choice! Please enter T or S. ** ");
                        System.out.print("Type T to search by title or S to search by star: ");
                        search_input1 = scanner4.nextLine().toUpperCase();
                    }
                    if(search_input1.equals("T")){
                        while(!done5){
                        System.out.print("Please enter a movie title: ");
                        search_input2 = scanner5.nextLine().toUpperCase();
                        for (AwardWinningMovie awardWinningMovie : movie_database) {
                            if (awardWinningMovie.getTitle().toUpperCase().contentEquals(search_input2)) {
                                System.out.println(awardWinningMovie);
                                done5 = true;
                            } else if (awardWinningMovie.getTitle().toUpperCase().contains(search_input2)) {
                                System.out.println(awardWinningMovie);
                                done5 = true;
                            }
                        }
                        }
                    }
                    else {
                        while (!done6) {
                            System.out.print("Please enter a movie star: ");
                            search_input3 = scanner6.nextLine().toUpperCase();
                            for (AwardWinningMovie awardWinningMovie : movie_database) {
                                if (awardWinningMovie.getStar().toUpperCase().contentEquals(search_input3)) {
                                    System.out.println(awardWinningMovie);
                                    done6 = true;
                                } else if (awardWinningMovie.getStar().toUpperCase().contains(search_input3)) {
                                    System.out.println(awardWinningMovie);
                                    done6 = true;
                                }
                            }
                        }
                    }
                }
            } while (done);
        }
        System.out.println("Thanks for using our experimental database! ");
    }
}
