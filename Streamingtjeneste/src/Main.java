import java.util.List;
import java.util.Scanner;


public class Main {

    public static MediaHandler csv=new MediaHandler();

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
        //CSVReaderInJava csv = new CSVReaderInJava();


        //Movies movie = new Movies();
        // Scanner scan = new Scanner(System.in);
        String userChoice = textUI.startMenu();
        // String movieUserInput = Movies.getUserInput();

        switch (userChoice) {
            case "1":
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a movie name to search: ");
                String movieName = scanner.nextLine();
                List<Movie> searchResult = csv.searchMovieByName(movieName);
                if (searchResult.equals(movieName)) {
                    System.out.println("Search results:");
                    for (Movie movie : searchResult) {
                        System.out.println(movie.getName());
                    }

                } else {
                    System.out.println("Search results:");
                    System.out.println("Sorry, no movies found with that name.");
                }
                break;
            case "2":

            //    MediaHandler.movieList();
                break;
            case "3":

            case "4":

            case "5":
                // go through the movies.txt and print out all the names
                // then user enters the name of the movie, user wants to watch
               // Movies.playMovie();
                List<Movie> liste = csv.getMovies();
                for (Movie movie : liste) {
                    System.out.println(movie.getName());
                }
                textUI.startMenu();
                break;

        }

    }
}