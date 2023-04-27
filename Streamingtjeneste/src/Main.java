import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //// Login Part
        UserHandler userHandler = new UserHandler("users.txt");
        TextUI textUI = new TextUI(userHandler);

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
        //Movies movie = new Movies();
        // Scanner scan = new Scanner(System.in);
        String userChoice = textUI.startMenu();
        // String movieUserInput = Movies.getUserInput();

        switch (userChoice) {
            case "1":
                Movies.searchFile(Movies.getUserInputMovie());
                Movies.playMovie();
                break;
            case "2":
                Movies.searchFile(Movies.getUserInputCategory());
                Movies.playMovie();
                break;
            case "3":

            case "4":

            case "5":
                // go through the movies.txt and print out all the names
                // then user enters the name of the movie, user wants to watch
                Movies.getAllMovies();
                Movies.playMovie();
                textUI.startMenu();
                break;
        }

    }
}