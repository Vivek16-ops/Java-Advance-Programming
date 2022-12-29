/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class process1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String ch = request.getParameter("op");
            
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-FG53LVAJ:1521:XE", "vivekblog", "vivekblog");
                
                if (ch.equals("insert")) {
                    PreparedStatement pst = conn.prepareStatement("insert into netform2 values(?,?,?)");
                    pst.setString(1, name);
                    pst.setString(2, email);
                    pst.setString(3, phone);
                    int row = pst.executeUpdate();
                    if (row == 1) {
                        out.println("Registration is successful");
                    } else {
                        out.println("Registration is not successful");
                    }
                } else if (ch.equals("delete")) {
                    PreparedStatement pst = conn.prepareStatement("delete from netform2 where name = ?");
                    
                    pst.setString(1, name);
                    
                    int x = pst.executeUpdate();
                    conn.close();
                    if (x > 0) {
                        out.println("Success");
                    } else {
                        out.print("failed");
                    }
                } else if (ch.equals("search")) {
                    PreparedStatement pst = conn.prepareStatement("select * from netform2 where name = ?");
                    
                    pst.setString(1, name);
                    
                    out.print("<table width=75% border=1>");
                    out.print("<caption>Student result : </caption>");
                    
                    ResultSet rs = pst.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    
                    int totalColumn = rsmd.getColumnCount();
                    
                    for (int i = 1; i <= totalColumn; i++) {
                        out.print("<th>" + rsmd.getColumnName(i) + "</th>");
                    }
                    
                    out.print("<tr>");
                    while (rs.next()) {
                        out.print("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td></tr>");
                    }
                    out.print("</table>");
                    
                } else if (ch.equals("update")) {
                    PreparedStatement pst = conn.prepareStatement("Update netform2 set email=? , phone=? where name = ?");
                    pst.setString(1, email);
                    pst.setString(2, phone);
                    pst.setString(3, name);
                    
                    int row = pst.executeUpdate();
                    if (row >= 1) {
                        out.print("Update Sucessful");
                    }
                }
            } catch (Exception e) {
                out.println("Control to aa gya");
                out.println(e);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
