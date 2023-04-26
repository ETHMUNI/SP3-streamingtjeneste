import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

    public class Dashboard {
        public static void search(String fileName) {
            try {
                File file = new File(Movies.txt);
                Scanner fileScanner = new Scanner(Movies.txt);
                int lineNumber = 0;
                boolean found = false;
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    lineNumber++;
                    if (line.contains(Movies.txt)) {
                        System.out.println("Strengen '" + searchString + "' blev fundet på linje " + lineNumber + " i filen " + fileName);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Strengen '" + searchString + "' blev ikke fundet i filen " + fileName);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Filen " + fileName + " blev ikke fundet.");
            }
        }
    }