package useCase;
import dao.BookDao;
import dao.BookDaoImpl;
import exception.BookException;

import java.util.Scanner;

public class DeleteBookUseCase {

    public static void main(String[] args) throws BookException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ID of the book to delete: ");
        int id = scanner.nextInt();

        BookDao bookDao = new BookDaoImpl();

        try {
            String result = bookDao.deleteBook(id);
            System.out.println(result);
        }catch(BookException e){
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public Object getid() {
        return null;
    }
}

