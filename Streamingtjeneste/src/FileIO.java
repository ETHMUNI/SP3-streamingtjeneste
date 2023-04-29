import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

    private static final String FILEPATH = "Favorite.txt";
    private static final String FILEPATH2 = "WatchedMovies.txt";

    public static void saveMovieName(String name,String movieName) {
        try {
            FileWriter writer = new FileWriter(FILEPATH, true);
            writer.write(name +","+movieName + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving movie name: " + e.getMessage());
        }
    }

    public static void watchedMovieName(String name,String movieName) {
        try {
            FileWriter writer = new FileWriter(FILEPATH2, true);
            writer.write(name +","+ movieName + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving movie name: " + e.getMessage());
        }
    }
}