package dao;

import bean.User;
import exception.UserException;

import java.util.List;

public interface UserDao {

//    public String addUser(User user) throws UserException;

    public User loginUser(String email, String password) throws UserException;
      User viewUser(int userId) throws UserException;

    String updateUser(int userId, String userName, String email) throws UserException;

    String changePassword(int userId, String newPassword) throws UserException;

    String addUser(User newUser) throws UserException;

    public String deleteUser(int userId) throws UserException;

    public List<User> viewAllUsers() throws UserException;
}

