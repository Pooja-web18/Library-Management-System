package useCase;
import java.util.Scanner;

import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;
import exception.UserException;

public class ChangeUserPasswordUseCase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your User ID:");
        int userId = sc.nextInt();

        sc.nextLine();  // Consume newline

        System.out.println("Enter your current password:");
        String currentPassword = sc.nextLine();

        System.out.println("Enter your new password:");
        String newPassword = sc.nextLine();

        UserDao dao = new UserDaoImpl();

        try {
            // Verifying if the user exists with the given userId and current password
            User user = dao.loginUser(dao.viewUser(userId).getEmail(), currentPassword);

            if (user != null) {
                // Changing the password
                String result = dao.changePassword(userId, newPassword);
                System.out.println(result);
            } else {
                System.out.println("Invalid user credentials.");
            }
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }
}

