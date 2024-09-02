package StartApplication;
import java.util.Scanner;
import dao.AdminDaoImpl;
import dao.UserDaoImpl;
import dao.BookDaoImpl;
import exception.BookException;
import useCase.*;


public class StartApp {
    public static void main(String[] args) throws BookException {

        Scanner sc = new Scanner(System.in);

        AdminDaoImpl adminDaoImpl = new AdminDaoImpl();

        UserDaoImpl userDaoImpl = new UserDaoImpl();

        BookDaoImpl bookDaoImpl = new BookDaoImpl();

        System.out.println("----------Welcome to The Library Management System------------");

        while (true) {
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as User");
            System.out.println("3. Exit Application");

            System.out.println("Enter a number:");

            int login = sc.nextInt();
            sc.nextLine();

            if (login == 1) {
                AdminLoginUseCase adminlogin = new AdminLoginUseCase();
                boolean result = adminlogin.main(args);
                if(result) {
                    while (true) {
                        System.out.println("1. Add Book ");
                        System.out.println("2. View book Details ");
                        System.out.println("3. Update the Book ");
                        System.out.println("4. Delete the Book ");
                        System.out.println("5. Issued Book ");
                        System.out.println("6. Returned Book");
                        System.out.println("7. View ALl Book ");
                        System.out.println("8. Logout");

                        System.out.println("Enter a number ");

                        int choice = sc.nextInt();


                        switch (choice) {
                            case 1: {
                                AddBookUseCase addBook = new AddBookUseCase();
                                addBook.main(args);
                                bookDaoImpl.logBookOperations(addBook.getBookId());
                                System.exit(0);
                                //                                break;
                            }
                            case 2: {
                                ViewBookDetailsUseCase viewBookDetailsUseCase = new ViewBookDetailsUseCase();
                                viewBookDetailsUseCase.main(args);
                                System.exit(0);
                                //                                break;
                            }
                            case 3: {
                                UpdateBookUseCase updateBookUseCase = new UpdateBookUseCase();
                                updateBookUseCase.main(args);
                                bookDaoImpl.logBookOperations(updateBookUseCase.getBookId());
                                System.exit(0);
//                                break;
                            }
                            case 4: {
                                DeleteBookUseCase deleteBookUseCase = new DeleteBookUseCase();
                                deleteBookUseCase.main(args);
                                bookDaoImpl.logBookOperations(deleteBookUseCase.getid());
                                System.exit(0);
//                                break;
                            }
                            case 5: {
                                IssueBookUseCase issueBookUseCase = new IssueBookUseCase();
                                issueBookUseCase.main(args);
                                bookDaoImpl.logBookOperations(issueBookUseCase.getid());
                                System.exit(0);
                                //   break;
                            }
                            case 6: {
                                ReturnBookUseCase returnBookUseCase = new ReturnBookUseCase();
                                returnBookUseCase.main(args);
                                bookDaoImpl.logBookOperations(returnBookUseCase.getid());
                                System.exit(0);
//                                break;
                            }
                            case 7: {
                                ViewAllBooksUseCase viewAllBooksUseCase = new ViewAllBooksUseCase();
                                viewAllBooksUseCase.main(args);
                                System.exit(0);
//                                break;
                            }
                            case 8: {
                                System.out.println("Admin Logged out Successfully!!");
                                System.exit(0);
                                //                                return;
                            }
                            default: {
                                System.out.println("Enter a valid number");
                                System.out.println("---------------------------");
                            }

                        }
                        System.out.println("--------------------------------------------------------");
                        System.out.println("--------------------------------------------------------");
                    }

                }
            } else if (login == 2) {
                UserLoginUseCase userLogin = new UserLoginUseCase();
                boolean result = userLogin.main(args);
                if(result) {
                    while (true) {
                        System.out.println("1. Issue Book");
                        System.out.println("2. Return Book");
                        System.out.println("3. view All Books");
                        System.out.println("4. Logout");
                        System.out.println("Enter a number:");


                        int choice = sc.nextInt();

                        switch (choice) {
                            case 1: {
                                IssueBookUseCase issueBookUseCase = new IssueBookUseCase();
                                issueBookUseCase.main(args);
                                System.exit(0);
//                                break;
                            }
                            case 2: {
                                ReturnBookUseCase returnBookUseCase = new ReturnBookUseCase();
                                returnBookUseCase.main(args);
                                System.exit(0);
//                                break;
                            }
                            case 3: {
                                ViewAllBooksUseCase viewAllBooksUseCase = new ViewAllBooksUseCase();
                                viewAllBooksUseCase.main(args);
                                System.exit(0);
//                                break;
                            }
                            case 4: {
                                System.out.println("User logged out Successfully!!");
                               System.exit(0);
//                                return;
                            }
                            default: {
                                System.out.println("Enter a valid number!");

                            }
                        }
                        System.out.println("-----------------------------");
                    }
                }

            } else if (login == 3) {
                System.out.println("Thank you for using Our Application");
                break;

            } else {
                System.out.println("Enter a valid number!!");
                System.out.println("------------------------------");
            }

        }
        sc.close();
    }

    }





