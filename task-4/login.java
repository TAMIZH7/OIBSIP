import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BasicLoginAuthenticationSystem {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Basic Login Authentication System");
            System.out.println(" ");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println(" ");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose another one.");
            return;
        }

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        // Store the username and password (in plain text for simplicity).
        users.put(username, password);
        System.out.println("Registration successful.");
    }

    private static void loginUser(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        if (!users.containsKey(username)) {
            System.out.println("Username not found. Please register.");
            return;
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Compare the entered password with the stored password.
        if (password.equals(users.get(username))) {
            System.out.println("Login successful. Welcome, " + username + "!");
        } else {
            System.out.println("Login failed. Incorrect password.");
        }
    }
}
