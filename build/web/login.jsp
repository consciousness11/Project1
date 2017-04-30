<%-- 
    Document   : login
    Created on : Sep 16, 2014, 7:16:46 PM
    Author     : Latitude
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login</title>
    </head>
    <body>
        <h1>Provide your username and password</h1>
        <form action="UserController" method="post">
        User Name:<input type="text" name="userName"><br>
        User Password:<input type="password" name="userPassword"><br>
        <input type="submit" value="login">
        </form>
    </body>
</html>
