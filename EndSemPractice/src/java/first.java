
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class first extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             String name = request.getParameter("name");
             String email = request.getParameter("email");
             String phone = request.getParameter("phone");
             
             //Using RequestDispatcher 
             //RequestDispatcher rd = request.getRequestDispatcher("index.html");
             //rd.include(request, response);
             
             out.println("<h2>The name is:"+name+"</h2>");
             out.println("<h2>The email is:"+email+"</h2>");
             out.println("<h2>The phone is:"+phone+"</h2>");
             
             //Using Session
//             HttpSession se = request.getSession();
//             se.setAttribute("uname",name);
//             se.setAttribute("uemail",email);
//             se.setAttribute("uphone",phone);

//            Uisng Cookie 
             Cookie c = new Cookie("uname",name);
             response.addCookie(c);
             
             out.println("<a href='second'>Visit</a>");
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
