import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MediaHandler {
    private List<Movies> movies = readMoviesFromCSV("Movies.txt");

    public List<Movies> getMovies() {
        return movies;
    }
    public List<Movies> searchMovieByName(String movieName) {
        List<Movies> matchingMovies = new ArrayList<>();
        for (Movies movies : this.movies) {
            String name = movies.getTitle();
            if (name.toLowerCase().contains(movieName.toLowerCase())) {
                matchingMovies.add(movies);
            }
        }
        return matchingMovies;
    }
    public Movies getMovieByNumber(int number) {
        return movies.get(number - 1);
    }


    private static List<Movies> readMoviesFromCSV(String fileName) {
        List<Movies> movies = new ArrayList<>();

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

                Movies movie = createMovie(parts);

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

    private static Movies createMovie(String[] metadata) {
        String name = metadata[0];
        String year = metadata[1];
        String category = metadata[2];
        String rating = metadata[3];

        // create and return book of this metadata
        return new Movies(name, year, category, rating);
    }

}

