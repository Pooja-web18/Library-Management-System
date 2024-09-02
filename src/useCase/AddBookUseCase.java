package useCase;

import bean.Book;
import dao.BookDao;
import dao.BookDaoImpl;
import exception.BookException;

import java.util.Scanner;

public class AddBookUseCase {

    public static void addBook() throws BookException {
        Scanner scanner = new Scanner(System.in);
        BookDao bookDao = new BookDaoImpl();

        System.out.print("Enter book id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

       // Create a new Book object
        Book book = new Book(id, title, author);

        // Add the book to the database
        String result = bookDao.addBook(book);
        System.out.println(result);
    }

    public static void main(String[] args) throws BookException {
        addBook();
    }

    public Object getBookId() {
        return null;
    }
}