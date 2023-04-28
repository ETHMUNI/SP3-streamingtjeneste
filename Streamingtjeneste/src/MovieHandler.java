import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieHandler {
    private List<Movie> movies = readMoviesFromCSV("Movies.txt");

    public List<Movie> getMovies() {
        return movies;
    }
    public List<Movie> searchMovieByName(String movieName) {
        List<Movie> matchingMovies = new ArrayList<>();
        for (Movie movie : movies) {
            String name = movie.getName();
            if (name.toLowerCase().contains(movieName.toLowerCase())) {
                matchingMovies.add(movie);
            }
        }
        return matchingMovies;
    }
    public Movie getMovieByNumber(int number) {
        return movies.get(number - 1);
    }


    private static List<Movie> readMoviesFromCSV(String fileName) {
        List<Movie> movies = new ArrayList<>();

        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] parts = line.split(";");

                Movie movie = createMovie(parts);

                // adding book into ArrayList
                movies.add(movie);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return movies;
    }

    private static Movie createMovie(String[] metadata) {
        String name = metadata[0];
        String year = metadata[1];
        String category = metadata[2];
        String rating = metadata[3];

        // create and return book of this metadata
        return new Movie(name, year, category, rating);
    }

    public void saveMovieName(String movieName, String filePath) {
        try {
            File file = new File(filePath);
            FileWriter writer = new FileWriter(file);
            writer.write(movieName);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchmovie() {
        MovieHandler movieHandler = new MovieHandler();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a movie name to search: ");
        String movieName = scanner.nextLine();

        List<Movie> matchingMovies = movieHandler.searchMovieByName(movieName);

        if (matchingMovies.size() == 0) {
            System.out.println("No matching movies found.");
            return;
        }

        System.out.println("Matching movies:");
        for (int i = 0; i < matchingMovies.size(); i++) {
            System.out.println((i + 1) + ". " + matchingMovies.get(i).getName());
        }

        System.out.print("Enter the number of the movie to select: ");
        int movieIndex = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        if (movieIndex < 1 || movieIndex > matchingMovies.size()) {
            System.out.println("Invalid movie number.");
            return;
        }

        Movie selectedMovie = matchingMovies.get(movieIndex - 1);
        System.out.println("Selected movie: " + selectedMovie.getName());

        // Call your function on selectedMovie here
        if (selectedMovie.getName().contains("")) {
            System.out.println("What would you like to do?");
            System.out.println("1. Play Movie");
            System.out.println("2. Save to favorites");
            int pick = scanner.nextInt();
            if (pick == 1){
                System.out.println(selectedMovie.getName() + " Is now playing enjoy!");
            } else if(pick == 2){
                System.out.println("You have now added the movie to you favorite list");
                String movieName2 = selectedMovie.getName();
                String filePath = "Favorite.txt";
                saveMovieName(movieName2, filePath);
            }
        }
    }

    public void showAllMovies() {
        MovieHandler movieHandler = new MovieHandler();
        List<Movie> liste = movieHandler.getMovies();
        Scanner movieScanner = new Scanner(System.in);

        for (int i = 0; i < liste.size(); i++) {
            Movie movie = liste.get(i);
            System.out.println((i+1) + ". " + movie.getName());
        }

        System.out.print("Please enter the number of the movie you'd like to select: ");
        int selection = movieScanner.nextInt();

        if (selection < 1 || selection > liste.size()) {
            System.out.println("Invalid movie number.");
            return;
        }

        Movie selectedMovie2 = liste.get(selection - 1);
        System.out.println("Selected movie: " + selectedMovie2.getName());
    }
}
class Movie {
    private String name;
    private String year;
    private String category;
    private String rating;

    public Movie(String name, String year, String category, String rating) {
        this.name = name;
        this.year = year;
        this.category = category;
        this.rating = rating;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public static void getAllMovies(){


    }




    @Override
    public String toString() {
        return name + ", year=" + year + ", category=" + category;
    }






}

