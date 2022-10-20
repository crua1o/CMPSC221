/*
Author: Colin Rualo and Esteban Leon
E-mail: cvr5614@psu.edu  ebl5225@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 6
Due date: 4/30/2022
File: PP6.java
Purpose: Java application that queries a database of movies and awards
 they have won and displays the results of the queries
Compiler/IDE:  Java 17.0.1/intelliJ IDEA 2021.3.1
Operating system: MAC OS
Reference(s):  Java 17 API - Oracle Documentation
 ( https://docs.oracle.com/en/java/javase/17/docs/api/);
 https://www.w3schools.com/sql/sql_join_inner.asp //used for inner join
 https://riptutorial.com/sql/example/3080/sorting-by-column-number--instead-of-name-
 (Include ALL additional references (Web page, etc.) here.)
*/

import java.sql.*;

public class PP6 {
    static final String DATABASE_URL = "jdbc:derby:/Users/colin/Desktop/movies;create=true";
    // "jdbc:derby:\\Users\\colin\\Desktop/movies;create=true";
    // "jdbc:derby:/Users/colin/Desktop/movies;create=true";
    // jdbc:derby:/Users/colin/Desktop/movies;create=true
    public static void main(String[] args) {

        // connect to database books and query database
        try {
            // establish connection to database
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            // This creates a statement for querying database,
            // and displays movies in ascending order by title.
            ResultSet resultSet = connection.createStatement().
                    executeQuery("select * from movieTitles ORDER BY 2");
            ResultSetMetaData metaData = resultSet.getMetaData(); // process data

            int numberOfColumns = metaData.getColumnCount();
            System.out.println();
            System.out.println("""
                    "movieTitles" Table of Movies Database (sorted in ascending order by title):\s
                    ----------------------------------------------------------------------------\s
                    (Format: MOVIEID, TITLE, RATING, GENRE, DIRECTOR, STAR)\s""");
            // print column names
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-40s\t", metaData.getColumnName(i));
            }
            System.out.println();
            // print column contents
            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-40s\t", resultSet.getObject(i));
                }
                System.out.println();
            } // end while
        // end try

            //A query to display all information in the movieAwards table sorted in descending order by award
            //year. Uses DESC
            ResultSet resultSet2 = connection.createStatement().
                    executeQuery("select * from movieAwards ORDER BY 3 DESC");
            ResultSetMetaData metaData2 = resultSet2.getMetaData();
            int numberOfColumns2 = metaData2.getColumnCount();
            System.out.println();
            System.out.println("""
                    "movieAwards" Table of Movies Database (sorted in descending order by year):\s
                    ----------------------------------------------------------------------------\s
                    (Format: MOVIEID, AWARD, AWARDYEAR)\s""");
            // print column names
            for (int i = 1; i <= numberOfColumns2; i++) {
                System.out.printf("%-60s\t", metaData2.getColumnName(i));
            }
            System.out.println();
            // print column contents
            while (resultSet2.next()) {
                for (int i = 1; i <= numberOfColumns2; i++) {
                    System.out.printf("%-60s\t", resultSet2.getObject(i));
                }
                System.out.println();
            } // end while

            //A query to display all information except for movie ID, director, award, and award year for those
            //movies whose rating is “PG-13.” uses LIKE
            ResultSet resultSet3 = connection.createStatement().
                    executeQuery("select TITLE, RATING, GENRE, DIRECTOR, STAR " +
                            "from movieTitles WHERE RATING LIKE 'PG-13'");
            ResultSetMetaData metaData3 = resultSet3.getMetaData();
            int numberOfColumns3 = metaData3.getColumnCount();
            System.out.println();
            System.out.println("""
                    Movies Whose Rating Is PG-13:\s
                    -----------------------------\s
                    (Format: TITLE, RATING, GENRE, STAR)\s""");
            // print column names
            for (int i = 1; i <= numberOfColumns3; i++) {
                System.out.printf("%-60s\t", metaData3.getColumnName(i));
            }
            System.out.println();
            // print column contents
            while (resultSet3.next()) {
                for (int i = 1; i <= numberOfColumns3; i++) {
                    System.out.printf("%-60s\t", resultSet3.getObject(i));
                }
                System.out.println();
            } // end while

            //query to display all information except for rating and genre for only those movies that have won
            //awards, uses inner join
            ResultSet resultSet4 = connection.createStatement().executeQuery("SELECT " +
                    "movieTitles.title, movieTitles.director, movieTitles.STAR, movieAwards.award, " +
                    "movieAwards.awardYear " +
                    "FROM movieTitles INNER JOIN movieAwards ON movieTitles.movieID=movieAwards.movieID");


            ResultSetMetaData metaData4 = resultSet4.getMetaData();
            int numberOfColumns4 = metaData4.getColumnCount();
            System.out.println();
            System.out.println("""
                    Movies That Have Received Awards:\s
                    ---------------------------------\s
                    (Format: MOVIEID, TITLE, DIRECTOR, STAR, AWARD, AWARDYEAR)\s""");
            // print column names
            for (int i = 1; i <= numberOfColumns4; i++) {
                System.out.printf("%-60s\t", metaData4.getColumnName(i));
            }
            System.out.println();
            // print column contents
            while (resultSet4.next()) {
                for (int i = 1; i <= numberOfColumns4; i++) {
                    System.out.printf("%-60s\t", resultSet4.getObject(i));
                }
                System.out.println();
            } // end while
        }
        catch(SQLException sqlException){
                    sqlException.printStackTrace();
                } // end catch
            }
        }