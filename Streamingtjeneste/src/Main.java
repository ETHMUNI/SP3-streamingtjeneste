import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bed brugeren om at indtaste filnavnet og den streng, der skal søges efter
        System.out.print("Indtast filnavnet: ");
        String fileName = scanner.nextLine();
        System.out.print("Indtast søgestrengen: ");
        String searchString = scanner.nextLine();

        // Kald søgemetoden i FileSearch-klassen
        Dashboard.search(fileName);

        // Luk scanneren
        scanner.close();
    }
}
