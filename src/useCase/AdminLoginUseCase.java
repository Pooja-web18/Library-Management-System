package useCase;
import java.util.Scanner;
import dao.AdminDao;
import dao.AdminDaoImpl;
import bean.Admin;
import exception.AdminException;

public class AdminLoginUseCase {

    public  boolean main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.println("Enter Email :");
        String email = sc.next();

        System.out.println("Enter Password:");
        String pass = sc.next();

        AdminDao dao=new AdminDaoImpl();

        try {
            Admin admin = dao.loginAdmin(email,pass);

            System.out.println("Welcome  , Hi "+admin.getaName());
            return true;

        } catch (AdminException e) {

            System.out.println(e.getMessage());
            return false;
        }


    }


}
