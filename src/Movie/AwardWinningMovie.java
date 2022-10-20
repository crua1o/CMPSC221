package Movie;

public class AwardWinningMovie extends Movie{
    private String awardTitle;
    private int awardYear;
    public AwardWinningMovie(String title, String rating, String genre, String director, String star,
                             String awardTitle, int awardYear) {
        super(title, rating, genre, director, star);
        this.awardTitle = awardTitle;
        this.awardYear = awardYear;
    }
    // set and get methods for each of the five instance variables.
    public String getAwardTitle()
    {
        return awardTitle;
    }
    public int getAwardYear()
    {
        return awardYear;
    }
    public void setAwardTitle(String awardTitle){
        this.awardTitle = awardTitle;
    }
    public void setAwardYear(int awardYear){
        this.awardYear = awardYear;
    }

    // A toString method that generates nicely formatted output of the Movie attributes.

    public String toString(){
        return String.format("""
                        --------------------------------------------------------
                        Title:          %-40s
                        Rating:         %-40s
                        Genre:          %-40s
                        Director:       %-40s
                        Star:           %-40s
                        Award title:    %-60s
                        Award year:     %-40s
                        --------------------------------------------------------""",
                getTitle(), getRating(), getGenre(), getDirector(), getStar(), awardTitle, awardYear);
    }

}
