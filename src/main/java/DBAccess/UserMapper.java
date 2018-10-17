package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import FunctionLayer.UserException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class UserMapper {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO `User` (email, `password`, `role`) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT id, role FROM `User` "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    static int countAllUsers() throws UserException {
        int count = 0;
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT COUNT(id) AS count FROM Users";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet ids = ps.executeQuery();
            if (ids.next()) {
                count = ids.getInt("count");
            } else {
                throw new UserException("Could not find any users!");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new UserException(ex.getMessage());
        }
        return count;
    }

    static List<User> getAllUsers() throws UserException {
        List<User> orders = new ArrayList<>();
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM Users";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet ids = ps.executeQuery();
            while (ids.next()) {
                int id = ids.getInt("id");
                String email = ids.getString("email");
                String password = ids.getString("password");
                String role = ids.getString("role");
                User user = new User(email, password, role);
                user.setId(id);
                orders.add(user);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new UserException(ex.getMessage());
        }
        return orders;
    }
}


