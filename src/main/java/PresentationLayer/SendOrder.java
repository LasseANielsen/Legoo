package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        try {
            int id = Integer.parseInt(request.getParameter("orderId"));
            LogicFacade.sendOrder(id);
            request.getSession().setAttribute("orderDone", "order shipped!");
            int orderCount = LogicFacade.getAllOrderCount();
            request.getSession().setAttribute("orderCount", orderCount);
            List<Order> orders = LogicFacade.getAllOrders();
            request.getSession().setAttribute("orders", orders);
        } catch (OrderException | NumberFormatException e) {
            request.getSession().setAttribute("orderError", e.getMessage());
        }
        return "employeepage";
    }

}
