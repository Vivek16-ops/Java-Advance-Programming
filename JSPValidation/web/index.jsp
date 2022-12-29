<%-- 
    Document   : index
    Created on : Dec 28, 2022, 7:57:39 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login.java" method="post">
            <table align="center">
                <tr align="center">
                    <td colspan="2"><h2>Login Form</h2></td>
                </tr>
                <tr>
                    <td>Username:</td><td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Password:</td><td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td></td><td><input type="submit" value="logn"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
