import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MediaHandler {
    List<Movie> movies = readMoviesFromCSV("Movies.txt");

    public List<Movie> getMovies() {
        return movies;
    }
    public List<Movie> searchMovieByName(String movieName) {
        return movies;
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

    public void searchMovieByName(String movieName) {
        boolean foundMovie = false;

        List<Movie> movies = new ArrayList<>();
        for (Movie movie : movies) {
            String name = movie.getName();
            if (name.equalsIgnoreCase(movieName)) {
                foundMovie = true;
                System.out.println("You are now playing " + name);
                break;
            }
        }

        if (!foundMovie) {
            System.out.println("Movie not found.");
        }
    }

    @Override
    public String toString() {
        return name + ", year=" + year + ", category=" + category;
    }







}

