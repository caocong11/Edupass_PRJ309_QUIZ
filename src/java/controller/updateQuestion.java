/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import enity.Question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "updateQuestion", urlPatterns = {"/updateQ"})
public class updateQuestion extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateQuestion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateQuestion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String id = request.getParameter("Qid");
        HttpSession s = request.getSession();
       Question q = new Question();
       q.getQuestionbyID(id);
       s.setAttribute("id1", id);
       request.setAttribute("qu", q.getQuestionbyID(id));
       request.getRequestDispatcher("updateQuestion.jsp").forward(request, response);
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
        try {
            String id = request.getParameter("id");
            String questID  = request.getParameter("questionID");
            String question  = request.getParameter("question");
            String answer1  = request.getParameter("anwser1");
            String answer2  = request.getParameter("anwser2");
            String answer3  = request.getParameter("answer3");
            String answer4  = request.getParameter("answer4");
            String rightA  = request.getParameter("rightanswer");
            
           if(rightA.matches("[ABCD]")){
                Question q = new Question();
            q.updateQuestion(id,questID,question,answer1,answer2,answer3,answer4,rightA);
            response.sendRedirect("question");
           }
            
          else{
              request.setAttribute("err", "RightAnswer: You can type(A,B,C or D)");
               HttpSession ss= request.getSession();
       Question q = new Question();
       q.getQuestionbyID((String) ss.getAttribute("id1 "));
       request.setAttribute("qu", q.getQuestionbyID(id));
       request.getRequestDispatcher("updateQuestion.jsp").forward(request, response);
              
           }
        } catch (SQLException ex) {
            Logger.getLogger(updateQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
