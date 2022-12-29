/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcconnn;

import java.sql.*;

/**
 *
 * @author ASUS
 */
public class Jdbcconnn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-FG53LVAJ:1521:XE", "vivekblog", "vivekblog");
            // Statement stmt=con.createStatement();
            System.out.println("Database connected successfully");
            con.close();
        } catch (SQLException e) {
            System.out.println("SQL error");
        }
    }
}

