package Movie;

public class Movie {
    // Five private instance variables that represent title (type String), rating (type String), genre
    //(type String), director (type String), and star (type String).
    private String title, rating, genre, director, star;
    // A five-argument constructor that initializes the five instance variables.
    public Movie(String title, String rating, String genre, String director, String star){
        this.title = title;
        this.rating = rating;
        this.genre = genre;
        this.director = director;
        this.star = star;
    }
    // set and get methods for each of the five instance variables.
    public String getTitle()
    {
        return title;
    }
    public String getRating()
    {
        return rating;
    }
    public String getGenre()
    {
        return genre;
    }
    public String getDirector()
    {
        return director;
    }
    public String getStar()
    {
        return star;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setRating(String rating){
        this.rating = rating;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public void setStar(String star){
        this.star = star;
    }
    // A toString method that generates nicely formatted output of the Movie attributes. (Note: Your
    //toString method must override the toString method of class Object.)  //
    @Override
    public String toString(){
        return String.format("Title: %-15s\tRating: " +
                " %-12s\tGenre:%-7s\tDirector: %-7s\tStar: %-7s", title, rating, genre, director, star);
    }

}
