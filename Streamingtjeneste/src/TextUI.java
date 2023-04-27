import java.util.Random;
import java.util.Scanner;

public class TextUI {
    Scanner scanner;
    UserHandler userHandler;

    public TextUI(UserHandler userHandler){
        this.userHandler = userHandler;
        this.scanner = new Scanner(System.in);
    }

    public String getUserInput(){
        System.out.println("Hello. Would you like to: " + "\n" + "1) Log in or" + "\n" + "2) Create user?" + "\n" + "Please write 1 or 2 and press Enter:");
        return scanner.nextLine();
    }

    public void loginMenu() {
        System.out.println("Please enter your username: ");
        String userName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        String id = Integer.toString(counter()); ////(UUID.randomUUID().toString();)
        if(userHandler.login(userName, password, id)){
            System.out.println("Welcome " + userName);
        }
        else{
            System.out.println("Sorry, the username or password is incorrect");
            loginMenu();
        }

    }

    public void createUserMenu() {
        System.out.println("Please enter a username: ");
        String userName = scanner.nextLine();
        System.out.println("Please enter a password: ");
        String password = scanner.nextLine();
        String id = Integer.toString(counter());
        if(userHandler.createUser(userName, password, id)){
            System.out.println("Welcome " + userName);
        }
        else{
            System.out.println("Sorry, the username or password can not be used try agin:");
            createUserMenu();
        }
    }

    public int counter(){
        Random rn = new Random();
        int answer = rn.nextInt(100) + 1;
        return answer;
    }

    public String firstMenu(){
        System.out.println("Welcome to Mustafa's movies, you can now choose one of the options" + "\n" + "1: Movies" +"\n"+ "2: Series");
        return scanner.nextLine();

    }

    public String startMenuMovies(){
        System.out.println("You choose movies, now you can pick one of the options");
        System.out.println( "1: Search for a movie" + "\n" + "2: Search a movie in a specific category" + "\n" + "3: The list of the movies you have watched" + "\n" + "4: The list of the movies you have saved" + "\n" + "5: Show all movies");
        return scanner.nextLine();
    }
    public String startMenuSeries(){
        System.out.println("You choose series, now you can pick one of the options");
        System.out.println( "1: Search for a series" + "\n" + "2: Search a serie in a specific category" + "\n" + "3: The list of the series you have watched" + "\n" + "4: The list of the series you have saved" + "\n" + "5: Show all series");
        return scanner.nextLine();
    }




}