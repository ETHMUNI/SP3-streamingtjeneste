import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Movies extends RollingPictures{

    static Scanner scan = new Scanner(System.in);
    public static TextUI ui;



    public static void searchFile(String userInput) {
        File file = new File("Movies.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(userInput)) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getUserInputMovie() {
        System.out.println("Write the movie you want to search for");
        return scan.nextLine();
    }

    public static String getUserInputCategory() {
        System.out.println("Write the category you want to search for");
        return scan.nextLine();
    }

    // Function that user writes the name of the movie and it starts playing OR is going back to search for some new movies.
    public static void playMovie() {
        System.out.println("Enter the name of the movie you want to watch:");
        String movieName = scan.nextLine();

        // Check if the movie is in the file
        File file = new File("Movies.txt");
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine(); // ignore header in csv
            boolean foundMovie = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // Ask the user if they want to go back to the dashboard or exit app
    public static void backToMenu() {
        System.out.println("Enter 'back' to return to the dashboard or press enter to exit");
        String input = scan.nextLine();
        if (input.equalsIgnoreCase("back")) {
            ui.startMenuMovies(); // throws an error!!!
        } else {
            System.exit(0); // Close app
            System.out.println("Closing down application");
        }
    }

    public static void getAllMovies() {
        File file = new File("Movies.txt");
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine(); // ignore header in csv
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";"); // split line by semicolon
                System.out.println(parts[0]); // prints the first item in array (the movie name)
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




}
