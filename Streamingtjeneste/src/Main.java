import java.util.List;
import java.util.Scanner;


public class Main {

    //public static MediaHandler csv=new MediaHandler();

    public static void main(String[] args) {

        //// Login Part
        UserHandler userHandler = new UserHandler("users.txt");
        TextUI textUI = new TextUI(userHandler);
        MediaHandler mediaHandler = new MediaHandler();



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

          String userChoice = textUI.startMenu();

        switch (userChoice) {
            case "1":
                mediaHandler.searchmovie();

            case "2":

            //    MediaHandler.movieList();
                break;
            case "3":

            case "4":

            case "5":
                mediaHandler.showAllMovies();


        }

    }
}