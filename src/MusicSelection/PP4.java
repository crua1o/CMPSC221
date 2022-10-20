/*
Author: Colin Rualo
E-mail: cvr5614@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 4
Due Date: 3/28/2022
File: MusicLibrary.java
Purpose: Java application that enables a user to create a playlist from
 an online music library
Compiler/IDE:  Java 17.0.1/intelliJ IDEA 2021.3.1
Operating system: MacOS
Reference(s):  Savitch, 6th Edition: Chapters 1 – 3 (basics), 4 – 5 (classes), 10 (file I/O), 14 (class ArrayList)
https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/242-valid-anagram-easy.html
https://stackoverflow.com/questions/14767697/dynamically-creating-arraylist-inside-a-loop

*/

package MusicSelection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PP4 {
    static int created = 0;

    public static void main(String[] args) {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream("music_library.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Problem opening files.");
            System.exit(0);
        }

        ArrayList<MusicSelection> MusicLibrary = new ArrayList<>();
        ArrayList<MusicSelection> playlist = null;
        ArrayList<String> artist_library = new ArrayList<>();
        HashMap<String, Integer> artistSongs = new HashMap<>();


        int count = 0, artist_count = 0;
        while (inputStream.hasNextLine()) {
            String genre = inputStream.nextLine();
            String artist = inputStream.nextLine();
            String title = inputStream.nextLine();
            String album = inputStream.nextLine();
            String release_date = inputStream.nextLine();
            MusicSelection song = new MusicSelection(genre, artist, title, album, release_date);
            MusicLibrary.add(song);
            count++;
        }
        for (MusicSelection songs : MusicLibrary) {
            if(!artist_library.contains(songs.getArtist())){ // arraylist of strings containing all artist names
                artist_library.add(songs.getArtist()); // if arraylist doesn't contain that artist, add it
                artist_count++;

            }

            if (!artistSongs.containsKey(songs.getArtist())) {// to figure out this hashmap loop, I used a leetcode problem.
                // if the artistSongs hashmap does not have the next artist in the loop, add the artist to the hashmap
                artistSongs.put(songs.getArtist(), 0);

            } // if a song by the certain artist comes up in the loop, increase that artist's # of songs by 1
            artistSongs.put(songs.getArtist(), artistSongs.get(songs.getArtist()) + 1);
        }

        // create a library for each artist with all of their songs (as objects)
        ArrayList<ArrayList<MusicSelection>> artist_libraries = new ArrayList<>(artist_count);
        for(int i = 0; i < artist_count;){
            // create a list
            ArrayList<MusicSelection> list = new ArrayList<>();
            artist_libraries.add(list); // add that list to big list
            for(MusicSelection songs : MusicLibrary){
                if(songs.getArtist().equals(artist_library.get(i))){
                    // if object's artist(string) == the artist(string) @ artist_library[i]
                    list.add(songs);
                }
            }
            i++;
        }

        inputStream.close();
        System.out.println("Welcome to Colin's personal music library!");

        boolean done = false;
        while (!done) {
            music_menu();
            int menu1 = 10, menu2 = 1, menu11 = 1, menu12 = 0;
            String are_you_sure;
            Scanner scanner = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);
            Scanner scanner11 = new Scanner(System.in);
            Scanner scanner12 = new Scanner(System.in);
            Scanner scanner13 = new Scanner(System.in);
            boolean done2 = false;
            boolean done3, done7;
            do {
                try {
                    System.out.println("Your choice (1-5)?");
                    menu1 = scanner.nextInt();
                } catch (InputMismatchException exception) {
                    System.out.println("Exception: java.util.InputMismatchException \n" +
                            "Menu choice must be an integer. Please try again. ");
                    done2 = true;
                    scanner.nextLine();
                }
                while (menu1 <= 0 || menu1 > 5) {
                    System.out.println("** Entry outside of range. ** ");
                    music_menu();
                    menu1 = scanner.nextInt();
                }
                if (menu1 == 5) {
                    done = true;
                    break;
                }
                if (menu1 == 1) { // create playlist
                    // if the playlist has not been created, create playlist
                    if(created == 0){
                        System.out.println("Playlist created!");
                        created = 1;
                        playlist = new ArrayList<>();
                    }
                    else { // this isn't working
                        System.out.println("Playlist already created.");
                    }
                }


                if(menu1 == 2){// delete playlist
                    // if no playlist exists, error.
                    // otherwise delete playlist.
                    try{
                        if(created == 0){
                            System.out.println("Playlist has not been created yet.");
                        }
                        else{
                            assert playlist != null;
                            if(!playlist.isEmpty()){
                                System.out.println("Playlist contains entries. Are you sure you want to delete it (Y/N)?");
                                are_you_sure = scanner12.nextLine();
                                while(!(are_you_sure.toUpperCase().equals("Y") || are_you_sure.toUpperCase().equals("N"))){
                                    System.out.println("Invalid input. Enter Y or N.");
                                    scanner12.nextLine();
                                }
                                if(are_you_sure.toUpperCase().equals("Y")){
                                    playlist.clear(); System.out.println("Playlist deleted!");
                                }}
                            else {
                                System.out.println("Playlist is empty.");
                                break;
                            }
                        }



                    } catch (NullPointerException e) {
                        System.out.println("Exception: java.util.NullPointerException \n" +
                                "Error. Please create a playlist! ");
                    }

                }
                if(menu1 == 3){ // Adding a selection to the playlist entails searching the music
                    // library first by artist then by title to locate the selection to add.

                    try{
                        assert playlist != null;
                        System.out.println("Choose an artist.");
                        for(int i = 0; i < artist_library.size(); i++){
                            System.out.println(i+1 + ") " + artist_library.get(i));
                        }


                        do {
                            done3 = false;
                            try {
                                menu2 = scanner2.nextInt();
                            } catch (InputMismatchException exception) {
                                System.out.println("Exception: java.util.InputMismatchException \n" +
                                        "Artist choice must be an integer. Please try again. ");
                                done3 = true;
                                scanner2.nextLine();
                            }
                        } while (done3);
                        while (menu2 <= 0 || menu2 > artist_count) {
                            System.out.println("** You must enter a number from 1 through " + artist_count+ "! ** ");
                            System.out.println("Your choice (1-" + artist_count + ")?");
                            menu2 = scanner2.nextInt();
                        }
                        System.out.println("Choose a title.");

                        String index = artist_library.get(menu2 - 1);
                        int count2 = 0;
                        for(MusicSelection certain_songs : MusicLibrary){
                            // for every object that has getArtist = index, print object.getTitle
                            if(index.equals(certain_songs.getArtist())){
                                count2++;
                                System.out.println(count2 + ") " + certain_songs.getTitle());
                            }
                        }
                        boolean done8;
                        do {
                            done8 = false;
                            try {
                                menu12 = scanner13.nextInt();
                                while (menu12 <= 0 || menu12 > count2) {
                                    System.out.println("** Entry outside of range. ** ");
                                    menu12 = scanner13.nextInt();
                                }
                            } catch (InputMismatchException exception) {
                                System.out.println("Exception: java.util.InputMismatchException \n" +
                                        "Song choice must be an integer. Please try again. ");
                                done8 = true;
                                scanner13.nextLine();
                            }
                        } while (done8);
                        int index2 = menu2, index3 = menu12;
                        System.out.println(artist_libraries.get(index2-1).get(index3-1));
                        playlist.add(artist_libraries.get(index2-1).get(index3-1));
                        System.out.println("Your choice \"" + artist_libraries.get(index2-1).get(index3-1).getTitle()
                                    + "\" by " + artist_library.get(index2-1) + " has been added to the playlist.");
                        System.out.println("Current playlist: \s");
                        for(int i = 0; i < playlist.size(); i++){
                            System.out.println("Selection #" + (i+1) + ":");
                            System.out.println(playlist.get(i));
                        }


                    } catch (NullPointerException e) {
                        System.out.println("Exception: java.util.NullPointerException \n" +
                                "Error. Please create a playlist! ");
                    }
                    }
                if(menu1 == 4){
                    // Removing a selection from the playlist entails displaying the playlist selections,
                    // numbered, then prompting the user to enter the number of the selection to remove.
                    try{
                        assert playlist != null;
                        // remove song from playlist

                        System.out.println("Current playlist: \s");
                        for(int i = 0; i < playlist.size(); i++){
                            System.out.println("Selection #" + (i+1) + ":");
                            System.out.println(playlist.get(i));
                        }
                        System.out.println("Please enter the number of selection you wish to remove.");
                        do {
                            done7 = false;
                            try {
                                menu11 = scanner11.nextInt();
                            } catch (InputMismatchException exception) {
                                System.out.println("Exception: java.util.InputMismatchException \n" +
                                        "Artist choice must be an integer. Please try again. ");
                                done7 = true;
                                scanner11.nextLine();
                            }
                        } while (done7);
                        while (menu11 <= 0 || menu11 > playlist.size()) {
                            System.out.println("** You must enter a number within the range of the playlist length! ** ");
                            System.out.println("Your choice?");
                            menu11 = scanner11.nextInt();
                        }
                        playlist.remove(menu11-1);
                        System.out.println("Selection #" + menu11 + " has been removed from the playlist.");
                        System.out.println("Current playlist: \s");
                        for(int i = 0; i < playlist.size(); i++){
                            System.out.println("Selection #" + (i+1) + ":");
                            System.out.println(playlist.get(i));
                        }

                    } catch (NullPointerException e) {
                        System.out.println("Exception: java.util.NullPointerException \n" +
                                "Error. Please create a playlist! ");
                    }
                }

            } while (done2);
            System.out.println(playlist);
        }

        System.out.println("Thanks for using Colin's personal music library! ");
    }


    public static void music_menu(){
        System.out.println("""
                    \s
                    Choose an option.\s
                    1) Create Playlist\s
                    2) Delete Playlist\s
                    3) Add Selection to Playlist\s
                    4) Remove Selection from Playlist\s
                    5) Quit\s""");
    }
}