public class Film {
    private String filmName;
    private String category;
    private int year;
    private String direction;
    private double imdbRating;

    public Film(String filmName, String category, int year, String direction, double imdbRating) {
        this.filmName = filmName;
        this.category = category;
        this.year = year;
        this.direction = direction;
        this.imdbRating = imdbRating;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}