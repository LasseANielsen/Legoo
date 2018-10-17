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
    </body>
</html>
