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



        String userChoice = textUI.startMenu();
        Movies movie = new Movies("favoritemovies.txt");

        switch (userChoice) {
            case "1":
                MediaHandler mediaHandler = new MediaHandler();
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter a movie name to search: ");
                String movieName = scanner.nextLine();

                List<Movies> matchingMovies = mediaHandler.searchMovieByName(movieName);

                if (matchingMovies.size() == 0) {
                    System.out.println("No matching movies found.");
                    return;
                }

                System.out.println("Matching movies:");
                for (int i = 0; i < matchingMovies.size(); i++) {
                    System.out.println((i + 1) + ". " + matchingMovies.get(i).getTitle());
                }

                System.out.print("Enter the number of the movie to select: ");
                int movieIndex = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                if (movieIndex < 1 || movieIndex > matchingMovies.size()) {
                    System.out.println("Invalid movie number.");
                    return;
                }

                Movies selectedMovies = matchingMovies.get(movieIndex - 1);
                System.out.println("Selected movie: " + selectedMovies.getTitle());

                // Call your function on selectedMovie here
               if (selectedMovies.getTitle().contains(""))
               {
                   System.out.println("Choose between the following options:");
                   System.out.println("1. Save to favorite");
                   System.out.println("2. Play " + selectedMovies.getTitle());

                   String choice = scanner.nextLine();
                   if (choice.equals("1")) {
                       movie.saveMovie(); // save movie to favorite movie list.
                   } else if (choice.equals("2")) {
                       System.out.println("You're now watching " + selectedMovies.getTitle());
                   } else {
                       System.out.println("Invalid choice. Please choose 1 or 2.");
                   }
               }

            case "2":

            //    MediaHandler.movieList();
                break;
            case "3":

            case "4":

            case "5":
                List<Movies> liste = csv.getMovies();
                Scanner movieScanner = new Scanner(System.in);

                for (int i = 0; i < liste.size(); i++) {
                    Movies movies = liste.get(i);
                    System.out.println((i+1) + ". " + movies.getTitle());
                }

                System.out.print("Please enter the number of the movie you'd like to select: ");
                int selection = movieScanner.nextInt();

                if (selection < 1 || selection > liste.size()) {
                    System.out.println("Invalid movie number.");
                    return;
                }

                Movies selectedMovies2 = liste.get(selection - 1);
                System.out.println("Selected movie: " + selectedMovies2.getTitle());
                break;

        }

    }
}