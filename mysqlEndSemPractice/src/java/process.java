
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class process extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String addr = request.getParameter("addr");
            String ch = request.getParameter("op");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice2", "root", "");
                if (ch.equals("insert")) {
                    PreparedStatement pst = conn.prepareStatement("insert into endsem values(?,?,?)");
                    pst.setString(1, name);
                    pst.setString(2, email);
                    pst.setString(3, addr);
                    int row = pst.executeUpdate();
                    if (row == 1) {
                        out.println("<h2>Insertion Succesful</h2>");
                    } else {
                        out.println("<h2>Insertion not Succesful</h2>");
                    }
                } else if (ch.equals("delete")) {
                    PreparedStatement pst = conn.prepareStatement("DELETE from endsem where name=?");
                    pst.setString(1, name);
                    pst.executeUpdate();
                    out.println("<h2>Deletion Succesful</h2>");
                } else if (ch.equals("update")) {
                    PreparedStatement pst = conn.prepareStatement("UPDATE `endsem` SET `Email`=(?) , `Address`=(?) where `Name`=(?)");
                    pst.setString(1, email);
                    pst.setString(2, addr);
                    pst.setString(3, name);
                    pst.executeUpdate();
                    out.println("<h2>Updation Succesful</h2>");
                }
            } catch (Exception e) {
                out.print(e.getCause());
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
