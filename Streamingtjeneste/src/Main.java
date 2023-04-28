import java.util.List;
import java.util.Scanner;


public class Main {

    public static MovieHandler csv=new MovieHandler();

    public static void main(String[] args) {

        //// Login Part
        UserHandler userHandler = new UserHandler("users.txt");
        TextUI textUI = new TextUI(userHandler);
        MovieHandler movieHandler = new MovieHandler();


        userHandler.loadUsers();

        String userInput = textUI.getUserInput();
        switch (userInput) {
            case "1":
                textUI.loginMenu();
                break;
            case "2":
                textUI.createUserMenu();
                break;
            default:
                System.out.println("Goodbye");
        }
        userHandler.saveUsers();

        ////Dashboard

        //// Movie Searcher Part
        //CSVReaderInJava csv = new CSVReaderInJava();



        String userChoice = textUI.startMenu();

        switch (userChoice) {
            case "1":
                movieHandler.searchmovie();

            case "2":
                movieHandler.searchmoviecategory();
            //    MediaHandler.movieList();
                break;
            case "3":
                MovieHandler.movieList("WatchedMovies.txt");
                break;
            case "4":
                MovieHandler.movieList("Favorite.txt");
                break;
            case "5":
                movieHandler.showAllMovies();
                break;
        }

    }
}