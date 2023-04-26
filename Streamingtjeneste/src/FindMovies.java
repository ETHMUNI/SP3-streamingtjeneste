//public class Movies extends RollingPictures{}

import java.io.*;
import java.util.*;

public class FindMovies {

    ArrayList<Movies> movie = new ArrayList<Movies>();

    class Movies {

        private String title;
        private String genre;
        private String category;
        private String year;

        public Movies(String title, String genre, String category, String year) {
            this.title = title;
            this.genre = genre;
            this.category = category;
            this.year = year;

        }

        public void fillMovieArray() {
            // properties

            int size; // total number of Students in collection

            File file = new File("Movies.txt");

            try {
                Scanner in = new Scanner(file);

                while (in.hasNextLine()) {
                    String title = in.next();
                    String genre = in.next();
                    String category = in.next();
                    String year = in.next();

                    movie.add(new Movies(title, genre, category, year));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String getTitle(Movies movies) {
            return movies.title;
        }

        public void printname() {
            System.out.println("hello");
        }

        public Movies search(String title) {
            System.out.print("Enter the name you wish to search: ");

            for (Movies m : movie) {
                if (m.title.equalsIgnoreCase(title)) ;
                return m;
            }
            return null;
        }
    }
}