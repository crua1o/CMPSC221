package MusicSelection;

import org.w3c.dom.ls.LSOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class PP4_revised {
    static ArrayList<MusicSelection> MusicLibrary = new ArrayList<>();
    //static ArrayList<String> artist_library = new ArrayList<>();
    // maps key artist to an arraylist of their songs
    //static HashMap<String, Integer> artist_library = new HashMap<>();
    static ArrayList<String> artist_library = new ArrayList<>();
    static ArrayList<String> list_of_artists = new ArrayList<>();
    static HashMap<String, ArrayList<MusicSelection>> artistSongs = new HashMap<>();
    static ArrayList<MusicSelection> playlist;

    static int created = 0;

    public static void main(String[] args) {
        int music_menu_choice = -1;
        boolean user_continue;
        boolean valid;
        String search;

        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream("music_library.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Problem opening files.");
            System.exit(0);
        }

        /* match text from file to object variables */
        while (inputStream.hasNextLine()) {
            String genre = inputStream.nextLine();
            String artist = inputStream.nextLine();
            String title = inputStream.nextLine();
            String album = inputStream.nextLine();
            String release_date = inputStream.nextLine();
            MusicSelection song = new MusicSelection(genre, artist, title, album, release_date);
            MusicLibrary.add(song);
        }


        // unique list of artists
        for (MusicSelection song : MusicLibrary){
            if(!list_of_artists.contains(song.getArtist())){
                list_of_artists.add(song.getArtist());
            }
        }


        // for every artist in the library:
        //     add to the hashmap in the form: <artist name, arraylist of songs>
        //     iterate through all songs and add to the arraylist songs that have the getArtist == artist name
        for (String artist : list_of_artists) {
            artistSongs.put(artist, new ArrayList<>());
            ArrayList<MusicSelection> list = artistSongs.get(artist);
            for (MusicSelection song : MusicLibrary) {
                if (song.getArtist().equals(artist)) {
                    list.add(song);
                }
            }
        }

        System.out.println(artistSongs);
        music_menu();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        do {
            user_continue = true;
            try {
                System.out.println("Your choice (1-5)?");
                scanner = new Scanner(System.in);
                music_menu_choice = scanner.nextInt();

                while (music_menu_choice <= 0 || music_menu_choice > 5) {
                    System.out.println("** Entry outside of range. ** ");
                    music_menu();
                    music_menu_choice = scanner.nextInt();
                }


            } catch (InputMismatchException exception) {
                System.out.println("Exception: java.util.InputMismatchException \n" +
                        "Menu choice must be an integer. Please try again. ");
            }

            switch (music_menu_choice){

                /* create playlist */
                case 1 -> {
                    if(created == 1){
                        System.out.println("A playlist has already been created.");
                    }
                    else {
                        System.out.println("Playlist created!");
                        created = 1;
                    }
                    music_menu();
                }
                /* delete playlist */
                case 2 -> {
                    if(created == 0){
                        System.out.println("Playlist has not been created yet.");
                    }
                    else{
                        created = 0;
                        delete(playlist);

                        if(!playlist.isEmpty()){
                            System.out.println("Playlist contains entries. Are you sure you want to delete it (Y/N)?");
                            String are_you_sure = scanner.nextLine();
                            while(!(are_you_sure.toUpperCase().equals("Y") || are_you_sure.toUpperCase().equals("N"))){
                                System.out.println("Invalid input. Enter Y or N.");
                                scanner.nextLine();
                            }
                            if(are_you_sure.toUpperCase().equals("Y")){
                                delete(playlist);
                                System.out.println("Playlist deleted!");
                            }
                        }
                    }
                    music_menu();
                }
                /* add song */
                case 3 -> {
                    if(created == 0){
                        System.out.println("Playlist has not been created yet.");
                    }
                    else {
                        System.out.println(list_of_artists);
                        System.out.println("Search for an artist: ");
                        search = scanner2.nextLine();
                        for (String artist : list_of_artists) {
                            if (artist.toLowerCase().contentEquals(search) ||
                                    artist.toLowerCase().contains(search.trim())
                                    || artist.equalsIgnoreCase(search)) {
                                System.out.println("Songs by " + artist + ": \n");
                                System.out.println(artistSongs.get(artist));
                            }
                        }
                    }
                }

                /* quit program */
                case 5 -> user_continue = false;
            }
        } while(user_continue);
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

    /*
    public static ArrayList<MusicSelection> create_playlist(){
        System.out.println("Playlist created!");
        return new ArrayList<MusicSelection>();
    }

     */

    public static void delete(ArrayList<MusicSelection> playlist){
        System.out.println("Playlist deleted!");
        playlist = null;
    }

    public static ArrayList<MusicSelection> add(ArrayList<MusicSelection> playlist, MusicSelection song){
        // Adding a selection to the playlist entails searching the music
        // library first by artist then by title to locate the selection to add
        System.out.println(playlist);
        return playlist;
    }

    public static ArrayList<MusicSelection> remove(ArrayList<MusicSelection> playlist, MusicSelection song){
        /*
        removing a selection from the playlist entails displaying the playlist selections, numbered,
        then prompting the user to enter the number of the selection to remove
         */
        System.out.println(playlist);
        return playlist;
    }
}
