import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO implements IO{

    private static final String FILEPATH = "Favorite.txt";

    public static void saveMovieName(String movieName) {
        try {
            FileWriter writer = new FileWriter(FILEPATH, true);
            writer.write(movieName + "\n");
            writer.close();
            System.out.println("You have now added the movie to you favorite list");
        } catch (IOException e) {
            System.out.println("Error saving movie name: " + e.getMessage());
        }
    }
}
