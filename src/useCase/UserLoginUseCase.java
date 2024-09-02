package useCase;

import java.util.Scanner;

import dao.UserDao;
import dao.UserDaoImpl;
import bean.User;
import exception.UserException;

public class UserLoginUseCase {
    public boolean main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Email :");
        String email = sc.next();

        System.out.println("Enter Password:");
        String pass = sc.next();

        UserDao dao = new UserDaoImpl();

        try {
            User user = dao.loginUser(email, pass);

            System.out.println(" Hi " + user.getUserName());
            System.out.println("Your User id is " +user.getUserId());
          return true;

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return false;


        }

    }
}




