import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

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
            movieMenu();
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
            movieMenu();
        }
        else{
            System.out.println("Sorry, the username or password can not be used try agin:");
            createUserMenu();
        }
    }

    public String movieMenu(){
        System.out.println("You are now logged in and have the following choises: " + "\n" + "1: movies" + "\n" + "2: series");
        return scanner.nextLine();
    }

    public int counter(){
        Random rn = new Random();
        int answer = rn.nextInt(100) + 1;
        return answer;
    }

}