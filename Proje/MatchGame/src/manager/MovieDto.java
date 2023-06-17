package manager;

import model.Movie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MovieDto {

    ArrayList<Movie>  movies = new ArrayList<>() ;

    public MovieDto() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("imdb_top_250.csv"));
        String line = reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");

            int no = Integer.parseInt(data[0]);
            String title = data[1];
            int year = Integer.parseInt(data[2]);
            String genre = data[3];
            String origin = data[4];
            String director = data[5];
            String star = data[6];
            String imdbLink = data[7];

            Movie movie = new Movie(no, title, year, genre, origin, director, star, imdbLink);
            movies.add(movie);
        }

    }
    public Movie selectAMovie(){
        Random random = new Random();
        int randomNumber = random.nextInt(movies.size())+1;
        Movie selectedMovie =movies.get(randomNumber);
        return selectedMovie;
    }
    public  ArrayList<Movie> getAllFilms(){
        return movies;
    }


   public boolean guessTrue(Movie movie,int randomSelectedFilmId,ArrayList<Movie> movieList){
        int filmId=returnFilm(movie.getTitle(),movies);
        if(filmId!=-1&&randomSelectedFilmId==filmId){
         return false;
        }

       return true;}




    public int returnFilm(String movieName,ArrayList<Movie> movieList){

        for (int i = 0; i < movieList.size(); i++) {
            String title = movieList.get(i).getTitle();
            if (title.equalsIgnoreCase(movieName)) {
                return i;
            }
        }
        return -1; // Film ismi bulu
    }

    public void CompareToPrint(Movie movie_1, Movie movie_2) {

        if (movie_1.getYear() == movie_2.getYear()) {
            System.out.print("SUCCESS");
        } else {
            System.out.print("FAIL");
        }
        System.out.print(" --> Year: " + movie_1.getYear() + "  // ");

        //*********************************************************

        if (movie_1.getGenre().equalsIgnoreCase(movie_2.getGenre())) {
            System.out.print("SUCCESS");
        } else {
            System.out.print("FAIL");
        }
        System.out.print(" --> Genre: " + movie_1.getGenre() + "  // ");

        //*********************************************************

        if (movie_1.getOrigin().equalsIgnoreCase(movie_2.getOrigin())) {
            System.out.print("SUCCESS");
        } else {
            System.out.print("FAIL");
        }
        System.out.print(" --> Origin: " + movie_1.getOrigin() + "  // ");

        //*********************************************************

        if (movie_1.getDirector().equalsIgnoreCase(movie_2.getDirector())) {
            System.out.print("SUCCESS");
        } else {
            System.out.print("FAIL");
        }
        System.out.println(" --> Director: " + movie_1.getDirector() + "  // ");
    }



}
