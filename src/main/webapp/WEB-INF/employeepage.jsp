<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
        <link href="Style/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <h1>Hello <%=request.getParameter("email")%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.
        <h3 style="text-align:center;">Send order here!</h3>
        <div style="text-align: center;">
            <form name="sendOrder" action="FrontController" method="POST">
                <input type="hidden" name="command" value="sendOrder">
                Order ID:<br>
                <input type="number" name="orderId">
                <br><br>
                <input type="submit" value="Send Order">
            </form>
            <% if (session.getAttribute("orderError") != null) {
                    session.getAttribute("orderError");
                } else if (session.getAttribute("orderDone") != null) {
                    session.getAttribute("orderDone");
                } else { %>
            <br>
            <%}%>
        </div>
        <h3 style="text-align:center;">List of all orders</h3>
        <table border="1" style="border-collapse:collapse;width:100%;">
            <tbody>
                <tr>
                    <td style="width: 16.667%;">Id</td>
                    <td style="width: 16.667%;">User id</td>
                    <td style="width: 16.667%;">Length</td>
                    <td style="width: 16.667%;">Width</td>
                    <td style="width: 16.667%;">Height</td>
                    <td style="width: 16.667%;">Shipped</td>
                </tr>
                <%  List<Order> orders = (List<Order>) request.getSession().getAttribute("orders");
                    for (int i = 0; i < (Integer) request.getSession().getAttribute("orderCount"); i++) {
                        Order order = orders.get(i);%>
                <tr>
                    <td style="width: 16.667%;"><%= order.getId()%></td>
                    <td style="width: 16.667%;"><%= order.getUser_id()%></td>
                    <td style="width: 16.667%;"><%= order.getLength()%></td>
                    <td style="width: 16.667%;"><%= order.getWidth()%></td>
                    <td style="width: 16.667%;"><%= order.getHeight()%></td>
                    <td style="width: 16.667%;"><%= order.isShipped()%></td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>
