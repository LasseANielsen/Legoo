package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlaceOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderException {
        int userId = ((User) request.getSession().getAttribute("user")).getId();

        int length = (Integer) request.getSession().getAttribute("length");
        int width = (Integer) request.getSession().getAttribute("width");
        int height = (Integer) request.getSession().getAttribute("height");
        Order order = new Order(userId, length, width, height, "false");
        LogicFacade.placeOrder(order);
        
        User user = (User) request.getSession().getAttribute("user");
        int count = LogicFacade.getOrderCount(user.getId());
        request.getSession().setAttribute("orderCount", count);
        List<Order> orders = LogicFacade.getAllOrdersByUser(user.getId());
        request.getSession().setAttribute("orders", orders);

        return "customerpage";
    }
}
