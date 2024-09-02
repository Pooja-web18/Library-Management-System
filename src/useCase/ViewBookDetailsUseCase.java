package useCase;

import bean.Book;
import dao.BookDaoImpl;
import exception.BookException;

import java.util.Scanner;

public class ViewBookDetailsUseCase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter book ID to view details: ");
        int id = scanner.nextInt();

        BookDaoImpl bookDaoImpl = new BookDaoImpl();

        try {
            Book book = bookDaoImpl.viewBookdetails(id);

            System.out.println("Book details");
            System.out.println("ID : " + book.getId());
            System.out.println("Title : " + book.getTitle());
            System.out.println("Author : " + book.getAuthor());
    }catch (BookException  e ) {
            System.out.println("Error : + e.getMessage");
        }



    }
}

