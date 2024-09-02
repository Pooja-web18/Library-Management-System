package useCase;
import dao.BookDaoImpl;
import exception.BookException;
import java.util.Scanner;

public class UpdateBookUseCase {

    public static void main(String[] args) throws BookException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Book ID  to update:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the new title:");
        String title = sc.nextLine();

        System.out.println("Enter the new author:");
        String author = sc.nextLine();

        BookDaoImpl bookDao = new BookDaoImpl();

        try {
            String result = bookDao.updateBook(id, title, author);
            System.out.println(result);
        }catch (BookException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }


    public Object getBookId() {
        return null;
    }
}
