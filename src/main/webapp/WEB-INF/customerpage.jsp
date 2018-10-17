<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
        <link href="Style/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Hello <%=request.getParameter( "email" )%> </h1>
        You are now logged in as a customer of our wonderful site.
        <br/>
        It's time
        <form action="FrontController" method="POST" name="transfer">
            <input name="command" type="hidden" value="transfer" />
            <input type="submit" value="Lets build" />
        </form>
        <hr>
        <h2> Your orders: </h2>
        <table border="1" style="border-collapse: collapse; width: 50%;">
            <tbody>
                <tr>
                    <td style="width: 10%;">Id</td>
                    <td style="width: 10%;">Length</td>
                    <td style="width: 10%;">Width</td>
                    <td style="width: 10%;">Height</td>
                    <td style="width: 10%;">Shipped</td>
                </tr>
                <%  List<Order> orders = (List<Order>)request.getSession().getAttribute("orders");
                    for (int i = 0; i < (Integer)request.getSession().getAttribute("orderCount"); i++) { 
                    Order order = orders.get(i); %>
                <tr>
                    <td style="width: 1%;"><%= order.getId()%></td>
                    <td style="width: 1%;"><%= order.getLength()%></td>
                    <td style="width: 1%;"><%= order.getWidth()%></td>
                    <td style="width: 1%;"><%= order.getHeight()%></td>
                    <td style="width: 1%;"><%= order.isShipped()%></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
