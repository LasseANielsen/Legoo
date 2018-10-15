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
            Length of house (in dots):<br /> 
            <input min="12" name="length" type="number" value="12" /> 
            <br /> <br /> 
            Width of house (in dots):<br /> 
            <input min="8" name="width" type="number" value="8" /> 
            <br /> <br /> 
            Height of house (in blocks):<br /> 
            <input min="4" name="height" type="number" value="4" /> 
            <br /> <br /> 
            <input type="submit" value="Generate list" />
        </form>
    </body>
</html>

