package FunctionLayer;

import DBAccess.DBFacade;
import DBAccess.UserMapper;
import java.util.HashMap;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static HashMap<String, Integer> createBlockHolder(int length, int width, int height) {
        return HouseMath.math().makeHouse(length, width, height);
    }

    public static void placeOrder(Order order) throws OrderException {
        DBFacade.createOrder(order);
    }

    public static int getOrderCount(int id) throws OrderException {
        return DBFacade.getOrderCount(id);
    }

    public static List<Order> getAllOrdersByUser(int id) throws OrderException {
        return DBFacade.getAllOrdersByUser(id);
    }

    public static int getAllOrderCount() throws OrderException {
        return DBFacade.getAllOrderCount();
    }

    public static List<Order> getAllOrders() throws OrderException {
        return DBFacade.getAllOrders();
    }

    public static int getAllUserCount() throws UserException {
        return DBFacade.getAllUserCount();
    }

    public static List<User> getAllUsers() throws UserException {
        return DBFacade.getAllUsers();
    }

}
