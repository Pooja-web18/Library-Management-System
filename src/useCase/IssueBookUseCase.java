package useCase;

import dao.BookDaoImpl;
import exception.BookException;

import java.util.Scanner;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

public class IssueBookUseCase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book ID to issue: ");
        int id = sc.nextInt();

        System.out.println("Enter use ID : ");
        int userId = sc.nextInt();

        BookDaoImpl bookDao = new BookDaoImpl();

        try {
            bookDao.issueBook(id, userId);
            System.out.println("Book issued succesfully!");

        } catch (BookException e) {
            System.out.println(e.getMessage());
        }
     sc.close();
    }

    public Object getid() {
        return null;
    }
}


