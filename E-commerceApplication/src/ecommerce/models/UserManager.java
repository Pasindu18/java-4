package ecommerce.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private static final String FILE_NAME = "users.txt"; // File to store user data
    private List<User> users; // List to hold registered users

    // Constructor: Initializes the users list and loads users from the file
    public UserManager() {
        this.users = new ArrayList<>();
        loadUsersFromFile();
    }

    // Register a new user
    public boolean register(User user) {
        // Check if the email already exists
        for (User existingUser : users) {
            if (existingUser.getEmail().equals(user.getEmail())) {
                System.out.println("Error: Email already exists.");
                return false;
            }
        }
        // Add the user to the list and save to the file
        users.add(user);
        saveUsersToFile();
        System.out.println("User registered successfully!");
        return true;
    }

    // Login a user
    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome, " + user.getName() + "!");
                return user;
            }
        }
        System.out.println("Error: Invalid email or password.");
        return null;
    }

    // Save users to a file
    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users) {
                writer.write(user.getId() + "," + user.getName() + "," + user.getEmail() + "," + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to save users to file.");
            e.printStackTrace();
        }
    }

    // Load users from a file
    private void loadUsersFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return; // No users to load if the file doesn't exist
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String email = parts[2];
                    String password = parts[3];
                    users.add(new User(id, name, email, password));
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to load users from file.");
            e.printStackTrace();
        }
    }

    // Get the count of registered users
    public int getUsersCount() {
        return users.size(); // Return the size of the users list
    }

    // View all users (For testing purposes)
    public void viewAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users are currently registered.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}