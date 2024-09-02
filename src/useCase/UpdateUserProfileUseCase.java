package useCase;

import java.util.Scanner;

import dao.UserDao;
import dao.UserDaoImpl;
import exception.UserException;

public class UpdateUserProfileUseCase {

    public static void main(String[] args) throws UserException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter User ID: ");
        int userId = sc.nextInt();

        sc.nextLine();  // Consume newline

        System.out.println("Enter new Name: ");
        String name = sc.nextLine();

        System.out.println("Enter new Email: ");
        String email = sc.nextLine();

        UserDao dao = new UserDaoImpl();

        String result = dao.updateUser(userId, name, email);
        System.out.println(result);

        sc.close();
    }
}

