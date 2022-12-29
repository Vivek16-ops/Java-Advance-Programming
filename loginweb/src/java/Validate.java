/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 *
 * @author ASUS
 */
public class Validate extends HttpServlet {

    public static boolean checkUser(String user, String pass) {
        boolean st = false;
        try {

            //loading drivers for mysql
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-FG53LVAJ:1521:XE", "vivekblog", "vivekblog");
            PreparedStatement ps = con.prepareStatement("select * from login where name=? and pass=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}
