package useCase;

import java.util.Scanner;
import dao.UserDao;
import dao.UserDaoImpl;
import bean.User;
import exception.UserException;

public class AddUserUseCase {

    public static void main(String[] args) throws UserException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter username:");
        String userName = sc.nextLine();

        System.out.println("Enter email:");
        String email = sc.nextLine();

        System.out.println("Enter password:");
        String password = sc.nextLine();

        UserDao dao = new UserDaoImpl();

        User newUser = new User(userName, email, password);

        String result = dao.addUser(newUser);
        System.out.println(result);
    }
}

