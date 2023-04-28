public class Main {

    public static void main(String[] args) {

        //// Login Part
        UserHandler userHandler = new UserHandler("Streamingtjeneste/users.txt");
        TextUI textUI = new TextUI(userHandler);

        userHandler.loadUsers();

        //log in or create a new user
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


        // String movieUserInput = Movies.getUserInput();
        String user = textUI.firstMenu();


        //It first asks if you want to watch movies or series and then with movie/serie or the other things
        switch (user) {
            case "1":
                String userChoice = textUI.startMenuMovies();
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
                        break;
                    case "4":
                        break;
                    case "5":
                        // go through the movies.txt and print out all the names
                        // then user enters the name of the movie, user wants to watch
                        Movies.getAllMovies();
                        Movies.playMovie();
                        Movies.backToMenu();
                        break;
                }
                break;

            case "2":
                String userChoice2 = textUI.startMenuSeries();
                switch (userChoice2) {
                    case "1":
                        Series.searchFile(Series.getUserInputSerie());
                        Series.playSerie();
                        break;
                    case "2":
                        Series.searchFile(Series.getUserInputSerie());
                        Series.playSerie();
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    case "5":
                        Series.getAllMovies();
                        Series.playSerie();
                        textUI.startMenuSeries();
                        break;
                }
                break;
        }
        }

    }