package useCase;
import dao.UserDao;
import dao.UserDaoImpl;
import exception.UserException;
import java.util.Scanner;

public class DeleteUserUseCase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user for ID
        System.out.println("Enter User ID to delete:");
        int userId = sc.nextInt();

        // Create UserDao instance
        UserDao dao = new UserDaoImpl();

        // Attempt to delete user
        try {
            String result = ((UserDaoImpl) dao).deleteUser(userId);
            System.out.println(result);
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    public Object getid() {
        return null;
    }
}
