<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Choose your bricks carefully</h1>
        <form action="FrontController" method="POST" name="contruct">
            <input name="command" type="hidden" value="contruct" />
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
            <br /> <br /><br /> <br /><br /> <br />
            <table>
                <tbody>
                    <tr>
                        <td>Bricks</td>
                        <td>Count</td>
                    </tr>
                    <tr>
                        <td>2x4</td>
                        <td><%=request.getSession().getAttribute("4x2Count")%></td>
                    </tr>
                    <tr>
                        <td>2x2</td>
                        <td><%=request.getSession().getAttribute("2x2Count")%></td>
                    </tr>
                    <tr>
                        <td>1x2</td>
                        <td><%=request.getSession().getAttribute("1x2Count")%></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>

