package ecommerce;

import ecommerce.models.User;
import ecommerce.models.UserManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the User Management System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View All Users (Admin)");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Register a new user
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();

                    // Generate user ID (based on current user count)
                    int userId = userManager.getUsersCount() + 1;
                    User newUser = new User(userId, name, email, password);

                    // Register user
                    userManager.register(newUser);
                    break;

                case 2:
                    // Login an existing user
                    System.out.print("Enter your email: ");
                    String loginEmail = scanner.nextLine();

                    System.out.print("Enter your password: ");
                    String loginPassword = scanner.nextLine();

                    userManager.login(loginEmail, loginPassword);
                    break;

                case 3:
                    // View all registered users
                    System.out.println("Registered Users:");
                    userManager.viewAllUsers();
                    break;

                case 4:
                    // Exit the application
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}