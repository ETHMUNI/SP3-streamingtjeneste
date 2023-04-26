import java.util.Scanner;

public class TextUI implements UI{
    Scanner scan = new Scanner(System.in);
    public String startMenu(){
        System.out.println("Welcome to Mustafa's movies, you can now choose one of the options" + "\n" + "1: Search for a movie" + "\n" + "2: Search a movie in a specific category" + "\n" + "3: The list of the movies you have watched" + "\n" + "4: The list of the movies you have saved" + "\n" + "5: Show movies");
        return scan.nextLine();
    }

}
