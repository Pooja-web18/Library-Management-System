package useCase;

import dao.BookDao;
import dao.BookDaoImpl;
import exception.BookException;

import java.util.Scanner;

public class ReturnBookUseCase {

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book ID to return: ");
        int id = sc.nextInt();
        System.out.println("Enter user ID : ");
        int userId = sc.nextInt();

        BookDaoImpl bookDao = new BookDaoImpl();

        try {
             bookDao.returnBook(id , userId);
            System.out.println("Book returned successfully!");
        } catch (BookException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }

    public Object getid() {
        return null;
    }
}





