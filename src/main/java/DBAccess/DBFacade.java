package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.User;

public class DBFacade {

    public static User SignIn(String email, String password) throws LoginSampleException {
        
        return UserMapper.login(email, password);
    }
    
    public static User user (User user) throws LoginSampleException {
        
       UserMapper.createUser(user);
       return user;
    }
    
    public static void createOrder (Order order) throws OrderException {
        OrderMapper.createOrder(order);
    }
}