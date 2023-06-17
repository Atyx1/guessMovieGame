import manager.MovieDto;
import model.Movie;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        MovieDto movieManager = new MovieDto();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Movie> myMovieList = new ArrayList<>();

        //We have all films in myMovieList;
        myMovieList=movieManager.getAllFilms();
        //selected film
        Movie movie_selected=movieManager.selectAMovie();
        //selected film's no
        int randomSelectedFilmId=movie_selected.getNo();

        boolean bittiMi=false;
        int count=5;

        System.out.println("*****WELCOME  TO THE GAME*****");
        System.out.println("Tutoril: "+ "\n 1-You have 5 film guesses in the game"
                + "\n 2-You will see the text \"SUCCES\" in the features of the film randomly selected by the game, which is the same as the film you guessed, and \"FAIL\" in the different one"
                + "\n 3-The system will warn you if you enter a different film from the one in the list or an invalid name"
                + "\n 4-Your right will be reduced each time unless you know the film in the game correctly or you write a film in the list correctly"
        );
        System.out.println("Press the letter 'E'or'e' to start the game : ");
        String input=scanner.nextLine();
        boolean startPress=false;
        if (input.equalsIgnoreCase("e")){
            startPress=true;
            System.out.println("-----------Guess Challenge----------");
        }
        else{
            System.out.println("See you later");
        }


        while(count>0&&!bittiMi&&startPress){

            System.out.println(" ");
            System.out.print("Guess A Movie: ");

            String enteredFilmName=scanner.nextLine();
            if(movieManager.returnFilm(enteredFilmName,myMovieList)!=-1){
                Movie tempMovie=myMovieList.get(movieManager.returnFilm(enteredFilmName,myMovieList));

                if(!movieManager.guessTrue(tempMovie,randomSelectedFilmId,myMovieList)){
                    movieManager.CompareToPrint(tempMovie,myMovieList.get(randomSelectedFilmId));
                    System.out.println("SUCCES-YOUWİN");
                    System.out.println("Movie :"+myMovieList.get(randomSelectedFilmId).getTitle()+" - Movie id:"+randomSelectedFilmId);
                    System.out.println("Movie Details:"+myMovieList.get(randomSelectedFilmId).toString());
                    bittiMi=true;

                }
                else {
                    movieManager.CompareToPrint(tempMovie,myMovieList.get(randomSelectedFilmId));
                    count--;
                    System.out.print("   ******   Current count: "+count);
                    System.out.println("");
                    System.out.println("");
                }

            }
            else{
                System.out.print("the film you're looking for is not listed ---");
                count--;
                System.out.print("Current Counter:"+count);
                System.out.println("");
                System.out.println("");
            }

            if(count==0&&bittiMi==false){
                System.out.println("YOULOST-GAMEOVER");
                System.out.println("Movie :"+myMovieList.get(randomSelectedFilmId).getTitle()+" - Movie id:"+randomSelectedFilmId);
                System.out.println("Movie Details:"+myMovieList.get(randomSelectedFilmId).toString());
            }

        }










    }
}