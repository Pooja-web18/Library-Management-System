package dao;
import java.sql.SQLException;
import java.util.List;
import bean.Book;
import bean.BookOperation;
import exception.BookException;

public interface BookDao {

    public String addBook(Book book) throws BookException;

    public Book viewBookdetails(int id) throws BookException;

    public String updateBook(int id, String title, String author) throws BookException;

    public List<Book> viewAllBooks() throws BookException;

    public String deleteBook(int id) throws BookException;

    public String issueBook(int id, int userId) throws BookException;

    public String returnBook(int id, int userId) throws BookException;

   public Book getBookById(int bookId) throws BookException;

     public void logBookOperations(Object id);

    void addBookOperation(BookOperation bookOperation) throws SQLException;

    void updateBookOperation(BookOperation bookOperation) throws SQLException;

    void deleteBookOperation(int id) throws SQLException;

    void issueBookOperation(BookOperation bookOperation) throws SQLException;

    void returnBookOperation(BookOperation bookOperation) throws SQLException;

    BookOperation getBookOperationById(int id) throws SQLException;

    List<BookOperation> getAllBookOperations() throws SQLException;
}
