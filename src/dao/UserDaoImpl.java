package dao;

import bean.User;
import exception.UserException;
import utility.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public String addUser(User user) throws UserException {
        String message = "User not added";

        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO user(userName, email, password) VALUES(?, ?, ?)");

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int x = ps.executeUpdate();

            if (x > 0) {
                message = "User added successfully";
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }

        return message;
    }

    @Override
    public User loginUser(String email, String password) throws UserException {
        User user = null;

        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("userId");
                String name = rs.getString("userName");
                user = new User(name, id );
                System.out.println("Welcome to  the library management system");
            } else {
                throw new UserException("Invalid email or password");
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }

        return user;
    }

    @Override


    public User viewUser(int userId) throws UserException {
        User user = null;

        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE userId = ?");
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("userName");
                String email = rs.getString("email");
                String password = rs.getString("password");

                user = new User( name, email, password);
            } else {
                throw new UserException("User not found with ID: " + userId);
            }
        } catch (SQLException | UserException e) {
            throw new UserException(e.getMessage());
        }

        return user;
    }


    public String updateUser(int userId, String userName,String email) throws UserException {
        String message = "Profile not updated";

        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE user SET userName = ? WHERE userId = ?");

            ps.setString(1, userName);
            ps.setInt(2, userId);

            int x = ps.executeUpdate();

            if (x > 0) {
                message = "Profile updated successfully";
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }

        return message;
    }


    public String changePassword(int userId, String newPassword) throws UserException {
        String message = "Password not changed";

        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE user SET password = ? WHERE userId = ?");

            ps.setString(1, newPassword);
            ps.setInt(2, userId);

            int x = ps.executeUpdate();

            if (x > 0) {
                message = "Password changed successfully";
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }

        return message;
    }

    public String deleteUser(int userId) throws UserException {
        String message = "User not deleted";

        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM user WHERE userId = ?");

            ps.setInt(1, userId);

            int x = ps.executeUpdate();

            if (x > 0) {
                message = "User deleted successfully";
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }

        return message;
    }

  public List<User> viewAllUsers() throws UserException {
        List<User> users = new ArrayList<>();

        try (Connection conn = DBUtil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("userId");
                String name = rs.getString("userName");
                String email = rs.getString("email");
                String password = rs.getString("password");

                User user = new User(id, name, email, password);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new UserException(e.getMessage());
        }

        return users;
    }
}
