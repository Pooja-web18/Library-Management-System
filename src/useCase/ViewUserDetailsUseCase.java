package useCase;

import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;

import java.util.Scanner;

public class ViewUserDetailsUseCase {

    public static void viewUserDetails() {
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDaoImpl();

        // Input user ID to view details
        System.out.print("Enter user ID to view details: ");
        int userId = scanner.nextInt();

        try {

            User user = userDao.viewUser(userId);

            if (user != null) {
                System.out.println("User details: " + user);
            } else {
                System.out.println("No user found with ID: " + userId);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void main(String[] args) {
        viewUserDetails();
    }
}

