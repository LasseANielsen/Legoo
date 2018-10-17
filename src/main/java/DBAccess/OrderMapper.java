package DBAccess;

import FunctionLayer.Order;
import FunctionLayer.OrderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static void createOrder(Order order) throws OrderException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO `Order` (userid, length, width, height, sent) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUser_id());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, order.getHeight());
            ps.setString(5, order.isShipped());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

   public static int countOrders(int id) throws OrderException {
        int count = 0;
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT COUNT(id) AS count FROM Order WHERE user_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet ids = ps.executeQuery();
            if (ids.next()) {
                count = ids.getInt("count");
            } else {
                throw new OrderException("Could not find any orders!");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
        return count;
    }

    public static List<Order> getAllOrdersbyUser(int id) throws OrderException {
        List<Order> orders = new ArrayList<>();
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM Order WHERE user_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet ids = ps.executeQuery();
            while (ids.next()) {
                int Id = ids.getInt("id");
                int user_id = ids.getInt("user_id");
                int length = ids.getInt("length");
                int width = ids.getInt("width");
                int height = ids.getInt("height");
                String shipped = ids.getString("shipped");
                Order order = new Order(user_id, length, width, height, shipped);
                order.setId(Id);
                orders.add(order);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
        return orders;
    }

    public static int countAllOrders() throws OrderException {
        int count = 0;
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT COUNT(id) AS count FROM Order";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet ids = ps.executeQuery();
            if (ids.next()) {
                count = ids.getInt("count");
            } else {
                throw new OrderException("No orders!");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
        return count;
    }

    public static List<Order> getAllOrders() throws OrderException {
        List<Order> orders = new ArrayList<>();
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM Orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet ids = ps.executeQuery();
            while (ids.next()) {
                int id = ids.getInt("id");
                int user_id = ids.getInt("user_id");
                int length = ids.getInt("length");
                int width = ids.getInt("width");
                int height = ids.getInt("height");
                String shipped = ids.getString("shipped");
                Order order = new Order(user_id, length, width, height, shipped);
                order.setId(id);
                orders.add(order);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
        return orders;
    }
}
