/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

/**
 *
 * @author ASUS
 */
import java.sql.*;
import java.util.*;

public class RackData {

    public String insert(RackBean rb) throws Exception {
        if (rb != null) {
            if (rb.getRackno() <= 0) {
                return "input";
            } else if (rb.getSubject().equals("")) {
                return "input";
            }

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-FG53LVAJ:1521:XE", "vivekblog", "vivekblog");

            PreparedStatement pst = con.prepareStatement("insert into EMP values(?,?)");
            pst.setInt(1, rb.getRackno());
            pst.setString(2, rb.getSubject());
            pst.executeUpdate();
            con.close();
            return "success";
        } else {
            return "input";
        }
    }

    public String delete(int rackno) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-FG53LVAJ:1521:XE", "vivekblog", "vivekblog");

        PreparedStatement pst = con.prepareStatement("delete from EMP where no = ?");
        pst.setInt(1, rackno);

        int x = pst.executeUpdate();
        con.close();
        if (x > 0) {
            return "success";
        } else {
            return "input";
        }
    }

    public RackBean search(int rackno) throws Exception {
        RackBean r = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-FG53LVAJ:1521:XE", "vivekblog", "vivekblog");

        PreparedStatement pst = con.prepareStatement("select * from EMP where no = ?");
        pst.setInt(1, rackno);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            r = new RackBean();
            r.setRackno(rs.getInt(1));
            r.setSubject(rs.getString(2));

        }
        con.close();
        return r;
    }

    public ArrayList getAll() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-FG53LVAJ:1521:XE", "vivekblog", "vivekblog");

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("Select * from EMP order by 1");

        ArrayList al = new ArrayList();
        RackBean rb = null;

        while (rs.next()) {
            rb = new RackBean();
            rb.setRackno(rs.getInt(1));
            rb.setSubject(rs.getString(2));
            al.add(rb);
        }
        con.close();
        return al;
    }
}
