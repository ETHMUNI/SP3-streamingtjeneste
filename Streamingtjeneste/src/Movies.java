import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Movies extends RollingPictures {

    static ArrayList<Movies> moviesSaved = new ArrayList<>();

    public Movies(String title, String year, String category, String rating) {
        super(title, year, category, rating);
    }

    public Movies(String fileName) {
        super(fileName);
    }

    public void loadMovies() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] values = input.split(";");
                moviesSaved.add(new Movies(values[0], values[1], values[2], values[3]));
            }
        } catch (IOException e) {
            System.out.println("The system is not working currently");
        }
    }

    public void saveMovie() {
        try {
            FileWriter writer = new FileWriter(file);
            for (Movies m : moviesSaved) {
                writer.write(m.getTitle() + ";" + m.getYear() + ";" + m.getCategory() + ";" + m.getRating() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Sorry, the system is not working currently");
        }
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
