package model;

public class Movie {

    private int no;
    private String title;
    private int year;
    private String genre;
    private String origin;
    private String director;
    private String star;
    private String imdbLink;

    public Movie() {
    }

    public Movie(int no, String title, int year, String genre, String origin, String director, String star, String imdbLink) {
        this.no = no;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.origin = origin;
        this.director = director;
        this.star = star;
        this.imdbLink = imdbLink;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getImdbLink() {
        return imdbLink;
    }

    public void setImdbLink(String imdbLink) {
        this.imdbLink = imdbLink;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", origin='" + origin + '\'' +
                ", director='" + director + '\'' +
                ", star='" + star + '\'' +
                ", imdbLink='" + imdbLink + '\'' +
                '}';
    }
}