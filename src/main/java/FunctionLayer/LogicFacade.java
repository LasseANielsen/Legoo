package FunctionLayer;

import DBAccess.DBFacade;
import DBAccess.UserMapper;
import java.util.HashMap;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
    public static HashMap<String, Integer> createBlockHolder(int length, int width, int height){
        return HouseMath.math().makeHouse(length, width, height);
    }
    
    public static void placeOrder(Order order) throws OrderException {
        DBFacade.createOrder(order);
    }
            

}
