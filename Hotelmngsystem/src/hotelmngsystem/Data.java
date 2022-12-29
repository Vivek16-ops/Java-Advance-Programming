/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmngsystem;

/**
 *
 * @author ASUS
 */
import java.sql.*;
import java.util.*;

public class Data {

    public String BookRoom(Bean bn) throws Exception {
        if (bn != null) {
            if (bn.getRoom_no() <= 0) {
                return "input";
            } else if (bn.getName().equals("")) {
                return "input";
            } else if (bn.getNumber() <= 0) {
                return "input";
            } else if (bn.getAddress().equals("")) {
                return "input";
            }
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-FG53LVAJ:1521:XE", "vivekblog", "vivekblog");

            PreparedStatement pst = con.prepareStatement("insert into HOTEL2 values(?,?,?,?)");

            pst.setInt(1, bn.getRoom_no());
            pst.setString(2, bn.getName());
            pst.setInt(3, bn.getNumber());
            pst.setString(4, bn.getAddress());
            pst.executeUpdate();
            con.close();
            return "success";
        } else {
            return "input";
        }
    }

    public String DeleteRoom(int room_no) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-FG53LVAJ:1521:XE", "vivekblog", "vivekblog");

        PreparedStatement pst = con.prepareStatement("delete from HOTEL2 where room_no = ?");
        pst.setInt(1, room_no);

        int x = pst.executeUpdate();
        con.close();
        if (x > 0) {
            return "success";
        } else {
            return "input";
        }
    }

    public Bean Search(int room_no) throws Exception {
        Bean b = null;

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-FG53LVAJ:1521:XE", "vivekblog", "vivekblog");

        PreparedStatement pst = con.prepareStatement("select * from HOTEL2 where room_no = ?");
        pst.setInt(1, room_no);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            b = new Bean();
            b.setRoom_no(rs.getInt(1));
            b.setName(rs.getString(2));
            b.setNumber(rs.getInt(3));
            b.setAddress(rs.getString(4));
        }
        con.close();
        return b;
    }

    public ArrayList Display() throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-FG53LVAJ:1521:XE", "vivekblog", "vivekblog");

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("Select * from HOTEL2 order by 1");

        ArrayList al = new ArrayList();
        Bean bn = null;

        while (rs.next()) {
            bn = new Bean();
            bn.setRoom_no(rs.getInt(1));
            bn.setName(rs.getString(2));
            bn.setNumber(rs.getInt(3));
            bn.setAddress(rs.getString(4));
            al.add(bn);
        }
        con.close();
        return al;
    }
}
