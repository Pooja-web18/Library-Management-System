package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Book;
import bean.BookOperation;
import exception.BookException;
import utility.DBUtil;

public class BookDaoImpl implements BookDao {

    private Connection connection;

    public BookDaoImpl() {
        this.connection = DBUtil.provideConnection();
    }

    @Override
    public String addBook(Book book) throws BookException {
        String message = "Not inserted";

        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO books(id, title, author) VALUES(?, ?, ?)")) {
            ps.setInt(1, book.getId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());

            int x = ps.executeUpdate();

            if (x > 0) {
                message = "New book added successfully.";
                logBookOperations(book.getId(), book.getTitle(), "ADD");
            }
        } catch (SQLException e) {
            throw new BookException("Error adding book: " + e.getMessage());
        }

        return message;
    }

    private void logBookOperations(int id, String title, String add) {
    }

    @Override
    public Book viewBookdetails(int id) throws BookException {

        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM books WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int bookId= rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                return new Book(id, title, author);
            } else {
                throw new BookException("Book not found with ID: " + id);
            }
        }catch (SQLException e) {
            throw new BookException("Error while retrieving book details: " + e.getMessage());
        }

    }
    public List<Book> viewAllBooks() throws BookException {
        List<Book> books = new ArrayList<>();

        try(Connection conn = DBUtil.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM books");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");

                books.add(new Book(id, title, author));
            }
        }catch (SQLException e){
            throw new BookException(e.getMessage());
        }
        return books;
    }

    @Override
    public String updateBook(int id, String title, String author) throws BookException {
        String message = "Not updated";

        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE books SET title = ?, author = ? WHERE id = ?")) {
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, id);

            int x = ps.executeUpdate();

            if (x > 0) {
                message = "Book updated successfully.";
                logBookOperations(id, title, "UPDATE");
            } else {
                throw new BookException("Book not found with this ID: " + id);
            }
        } catch (SQLException e) {
            throw new BookException("Error updating book: " + e.getMessage());
        }

        return message;
    }

    @Override
    public String deleteBook(int id) throws BookException {
        String message = "Book not deleted";

        try (Connection conn = DBUtil.provideConnection()) {
            String title = getTitleById(conn, id);

            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM books WHERE id = ?")) {
                ps.setInt(1, id);

                int x = ps.executeUpdate();

                if (x > 0) {
                    message = "Book deleted Successfully";
                    logBookOperations(id, title, "DELETE");
                } else {
                    throw new BookException("Book not found with this ID: " + id);
                }
            }
        } catch (SQLException e) {
            throw new BookException("Error deleting book: " + e.getMessage());
        }

        return message;
    }


    public String issueBook(int id, int userId) throws BookException {
        String message = "Book not issued";

        try (Connection conn = DBUtil.provideConnection()) {
            String title = getTitleById(conn, id);
            message = "Book issued successfully.";
            logBookOperations(id, title, "ISSUE", userId);
        } catch (SQLException e) {
            throw new BookException("Error issuing book: " + e.getMessage());
        }

        return message;
    }

    @Override
    public String returnBook(int id, int userId) throws BookException {
        String message = "Book not returned";

        try (Connection conn = DBUtil.provideConnection()) {
            String title = getTitleById(conn, id);
            message = "Book returned successfully.";
            logBookOperations(id, title, "RETURN", userId);
        } catch (SQLException e) {
            throw new BookException("Error returning book: " + e.getMessage());
        }

        return message;
    }


    public Book getBookById(int bookId) throws BookException {
        return viewBookdetails(bookId);
    }


    public void logBookOperations(Object id) {

    }

    private String getTitleById(Connection conn, int id) throws SQLException, BookException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT title FROM books WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("title");
                } else {
                    throw new BookException("Book not found with ID: " + id);
                }
            }
        }
    }

    private void logBookOperations(int id, String title, String operation, int userId) throws SQLException {
        String sql = "INSERT INTO bookoperations (id, title, operation, userId) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, operation);
            ps.setInt(4,userId);
            ps.executeUpdate();
        }
    }

    @Override
    public void addBookOperation(BookOperation bookOperation) throws SQLException {
        String sql = "INSERT INTO bookoperations (title, operation) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, bookOperation.getTitle());
            stmt.setString(2, bookOperation.getOperation());
            stmt.executeUpdate();
        }
    }

    @Override
    public void updateBookOperation(BookOperation bookOperation) throws SQLException {
        String sql = "UPDATE bookoperations SET title = ?, operation = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, bookOperation.getTitle());
            stmt.setString(2, bookOperation.getOperation());
            stmt.setInt(3, bookOperation.getId());
            stmt.executeUpdate();
        }
    }


    public void deleteBookOperation(int id) throws SQLException {
        String sql = "DELETE FROM bookoperations WHERE id = ?";
        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Book operation deleted successfully.");
            } else {
                System.out.println("No book operation found with this ID: " + id);
            }
        }
    }


    public void issueBookOperation(BookOperation bookOperation) throws SQLException {
        String sql = "INSERT INTO bookoperations (title, operation) VALUES (?, 'ISSUE')";
        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bookOperation.getTitle());
            stmt.executeUpdate();
            System.out.println("Book Issued Successfully.");
        }
    }


    public void returnBookOperation(BookOperation bookOperation) throws SQLException {
        String sql = "INSERT INTO bookoperations (title, operation) VALUES (?, 'RETURN')";
        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bookOperation.getTitle());
            stmt.executeUpdate();
            System.out.println("Book returned Successfully!!");
        }
    }


    public BookOperation getBookOperationById(int id) throws SQLException {
        BookOperation bookOperation = null;
        String sql = "SELECT * FROM bookoperations WHERE id = ?";

        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String title = rs.getString("title");
                    String operation = rs.getString("operation");
                    bookOperation = new BookOperation(id, title, operation);
                } else {
                    System.out.println("No Book operation found with ID: " + id);
                }
            }
        }
        return bookOperation;
    }

    public List<BookOperation> getAllBookOperations() throws SQLException {
        List<BookOperation> operations = new ArrayList<>();
        String sql = "SELECT * FROM bookoperations";

        try (Connection conn = DBUtil.provideConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String operation = rs.getString("operation");
                operations.add(new BookOperation(id, title, operation));
            }
        }
        return operations;
    }
}