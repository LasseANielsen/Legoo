package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Construct extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        int height = Integer.parseInt(request.getParameter("height"));
        HashMap<String, Integer> blockHolder = LogicFacade.createBlockHolder(length, width, height);
        request.getSession().setAttribute("length", length);
        request.getSession().setAttribute("width", width);
        request.getSession().setAttribute("height", height);
        request.getSession().setAttribute("2x4", blockHolder.get("2x4"));
        request.getSession().setAttribute("2x2", blockHolder.get("2x2"));
        request.getSession().setAttribute("1x2", blockHolder.get("1x2"));
        return "cpage";

    }
}
