import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Movies extends RollingPictures{

    static Scanner scan = new Scanner(System.in);


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

    public static String getUserInput() {
        System.out.println("Write the movie you want to search");
        return scan.nextLine();
    }


}
