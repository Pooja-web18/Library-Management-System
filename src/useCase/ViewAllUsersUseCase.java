package useCase;
import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;
import exception.UserException;

import java.util.List;

public class ViewAllUsersUseCase {

    public static void main(String[] args) {

        // Create UserDao instance
        UserDao dao = new UserDaoImpl();

        try {
            // Retrieve all users
            List<User> users = ((UserDaoImpl) dao).viewAllUsers();

            // Display users
            users.forEach(user -> {
                System.out.println("User ID: " + user.getUserId());
                System.out.println("User Name: " + user.getUserName());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Password: " + user.getPassword());
                System.out.println("=========================");
            });

        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }
}
