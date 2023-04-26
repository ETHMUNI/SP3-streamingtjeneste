import java.util.Scanner;

public class DashBoard {



    static Scanner scan = new Scanner(System.in);


    public static String getUserInput() {
        System.out.println("Write the movie you want to search");
        return scan.nextLine();
    }

}
