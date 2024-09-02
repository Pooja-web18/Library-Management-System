package useCase;
import dao.BookDao;
import bean.Book;
import dao.BookDaoImpl;
import exception.BookException;
import java.util.List;

    public class ViewAllBooksUseCase {

//        private BookDao bookDao;

        //        public ViewAllBooksUseCase() {
//            this.bookDao = bookDao;
//        }
        public static void main(String[] args) {
            try {
//        public List<Book> viewAllBooks() throws BookException {
//            List<Book> books = bookDao.viewAllBooks();
                BookDaoImpl bookDaoImpl = new BookDaoImpl();
                List<Book> books = bookDaoImpl.viewAllBooks();

                if (books.isEmpty()) {
                    System.out.println("No books available.");
                } else {
                    System.out.println("All Books:");
                    for (Book book : books) {
                        System.out.println("ID : " + book.getId() + " , Title : " + book.getTitle() + " , Author : " + book.getAuthor());
                    }
                }

            } catch (BookException e) {
                System.out.println(e.getMessage());
            }
        }
    }