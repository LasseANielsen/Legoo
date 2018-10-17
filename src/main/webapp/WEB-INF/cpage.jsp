<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Choose your bricks carefully</h1>
        <form action="FrontController" method="POST" name="construct">
            <input name="command" type="hidden" value="construct" />
            House length:<br /> 
            <input min="8" name="length" type="number" value="12" /> 
            <br /> <br /> 
            House width:<br /> 
            <input min="6" name="width" type="number" value="8" /> 
            <br /> <br /> 
            House height:<br /> 
            <input min="2" name="height" type="number" value="4" /> 
            <br /> <br /> 
            <input type="submit" value="Generate list" />

        </form>
        <br /> <br /><br /> <br /><br /> <br />
        <table>
            <tbody>
                <tr>
                    <td>Bricks</td>
                    <td>Count</td>
                </tr>
                <tr>
                    <td>2x4</td>
                    <td><%=request.getSession().getAttribute("2x4")%></td>
                </tr>
                <tr>
                    <td>2x2</td>
                    <td><%=request.getSession().getAttribute("2x2")%></td>
                </tr>
                <tr>
                    <td>1x2</td>
                    <td><%=request.getSession().getAttribute("1x2")%></td>
                </tr>
            </tbody>
        </table>
        <form name="order" action="FrontController" method="POST">
            <input type="hidden" name="command" value="order">
            <input type="submit" value="Next step">
        </form>
    </body>
</html>

