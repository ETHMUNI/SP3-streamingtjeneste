package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO implements IO {

    File file;
    Scanner scan;
    public ArrayList<String> readMovieData(String path) {
        file = new File(path);
        ArrayList<String> data = new ArrayList<>();

        try {
            scan = new Scanner(file);

            scan.nextLine(); // ignore header in csv
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                data.add(line);
                /*String[] parts = line.split(";");
                String name = parts[0];
                String year = parts[1];
                String category = parts[2];
                String rating = parts[3];*/
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found");

        }

        return data;
    }
}
