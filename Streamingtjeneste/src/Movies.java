import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import util.FileIO;

public class Movies extends RollingPictures{

    static Scanner scan = new Scanner(System.in);
    public TextUI ui;
    private static FileIO io = new FileIO();
    ArrayList<String> data = io.readMovieData("Movies.txt");

    public Movies(TextUI ui) {
        this.ui = ui;
    }

    public void searchFile(String userInput) {
        Scanner scanner = new Scanner(String.valueOf(data));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                String name = parts[0];
                if (line.contains(userInput)) {
                    System.out.println(name);
                }
            }
            scanner.close();
    }

    public String getUserInputMovie() {
        System.out.println("Write the movie you want to search for");
        return scan.nextLine();
    }

    public String getUserInputCategory() {
        System.out.println("Write the category you want to search for");
        return scan.nextLine();
    }

    // Function that user writes the name of the movie and it starts playing OR is going back to search for some new movies.
    public void playMovie() {

        System.out.println("Enter the name of the movie you want to watch:");
        String movieName = scan.nextLine(); // input from user

        // Check if the movie is in the file
            Scanner scanner = new Scanner(String.valueOf(data));
            scanner.nextLine(); // ignore header in csv
            boolean foundMovie = false;
            for(String s : data) {
               // String line = scanner.nextLine();
                String[] parts = s.split(";");
                String name = parts[0];
                if (name.equalsIgnoreCase(movieName)) {
                    foundMovie = true;
                    System.out.println("You are now playing " + name);
                    break;
                }
            }
            scanner.close();
            if (foundMovie == false) {
                System.out.println("Movie not found");
            }
        }
    // Ask the user if they want to go back to the dashboard or exit app
    public void backToMenu() {
        System.out.println("Enter 'back' to return to the dashboard or press enter to exit");
        String input = scan.nextLine();
        if (input.equalsIgnoreCase("back")) {
            ui.startMenu(); // throws an error!!!
        } else {
            System.exit(0); // Close app
            System.out.println("Closing down application");
        }
    }

    public void getAllMovies() {
        Scanner scanner = new Scanner(String.valueOf(data));
            scanner.nextLine(); // ignore header in csv
                for(String s : data) {
                    String[] parts = s.split(";"); // split line by semicolon
                    System.out.println(parts[0]); // prints the first item in array (the movie name)
                }
            scanner.close();
    }

}
