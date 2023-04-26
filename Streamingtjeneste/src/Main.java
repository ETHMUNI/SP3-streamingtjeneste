import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextUI UI = new TextUI();
        //FindMovies mo = new FindMovies();
        FindMovies.Movies mo = new FindMovies.Movies();
        //UI.startMenu();


        String userChoice = UI.startMenu();
        switch (userChoice) {
            case "1":

            case "2":

            case "3":

            case "4":
        }
    }
}
