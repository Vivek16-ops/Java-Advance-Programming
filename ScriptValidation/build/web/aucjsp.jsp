<%-- 
    Document   : aucjsp
    Created on : Oct 14, 2022, 12:35:42 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*"%>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            String id = request.getParameter("itemid");
            String name = request.getParameter("name");
            String addr = request.getParameter("mail");
            String con = request.getParameter("bid");
            out.println("your id will be " + id);
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");

                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-FG53LVAJ:1521:XE", "vivekblog", "vivekblog");
                PreparedStatement st = conn.prepareStatement("insert into scirptform values(?,?,?,?)");
                st.setString(1, id);
                st.setString(2, name);
                st.setString(3, addr);
                st.setString(4, con);
                int row = st.executeUpdate();
                if (row == 1) {
                    out.println("Registration is successful");
                } else {
                    out.println("Registration is not successful");
                }
            } catch (Exception e) {
                out.println(e);
            }

        %>
    </body>
</html>
