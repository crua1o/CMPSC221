package MusicSelection;

public class MusicSelection {
    private String genre, artist, title, album, release_date;
    // A five-argument constructor that initializes the five instance variables.
    public MusicSelection(String genre, String artist, String title, String album, String release_date){
        this.genre = genre;
        this.artist = artist;
        this.title = title;
        this.album = album;
        this.release_date = release_date;
    }
    // set and get methods for each of the five instance variables.
    public String getGenre()
    {
        return genre;
    }
    public String getArtist()
    {
        return artist;
    }
    public String getTitle()
    {
        return title;
    }
    public String getAlbum()
    {
        return album;
    }
    public String getRelease_date()
    {
        return release_date;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setAlbum(String album){
        this.album = album;
    }
    public void setReleaseDate(String release_date){
        this.release_date = release_date;
    }

    public String toString(){
        return String.format("""
                        
                        Genre:          %-40s
                        Artist:         %-40s
                        Title:          %-40s
                        Album:          %-40s
                        Release Date:   %-40s
                        """,
                getGenre(), getArtist(), getTitle(), getAlbum(), getRelease_date());
    }

}
