/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import enity.Quiz;
import enity.Score;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "quiz", urlPatterns = {"/quiz"})
public class quiz extends HttpServlet {

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
            out.println("<title>Servlet quiz</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet quiz at " + request.getContextPath() + "</h1>");
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
         String id = request.getParameter("sid");
         String level = request.getParameter("level");
         if(level.equals("Easy")){
             level="1";
         }
         if(level.equals("Medium")){
             level="2";
         }
         if(level.equals("Hard")){
             level="3";
         }
        HttpSession a = request.getSession();
          if(a.getAttribute("accS")!=null){
            Quiz q = new Quiz();
        List<Quiz> list = q.getQuestionAllbyLevel(id,level);
          a.setAttribute("level", level);
          a.setAttribute("sid", id);
        request.setAttribute("list", list);
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
          }else{
              response.sendRedirect("Message.jsp");
          }
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
       
          HttpSession a = request.getSession();
          String user = (String) a.getAttribute("accS");
    String id = (String) a.getAttribute("sid");
   String le = (String) a.getAttribute("level");
          if(a.getAttribute("accS")!=null){
         Quiz q = new Quiz();
    String[] chon = new String[100];
    List<Quiz> list = q.getQuestionAllbyLevel(id,le);
    int i = 0;
    int size = list.size();
    for(Quiz e : list)
    {   
            chon[i] = e.getCorrect();
              i++;
    }
    String[] userans = new String[100];
    for(int j = 0 ; j < size ; j++)
    {
            userans[j] = request.getParameter(Integer.toString(j));
    }
    int correctanswer=0;
    int unattempted = 0;
    int wronganswer=0;
    for(int k = 0 ; k< size;k++)
    {
            if(userans[k].equalsIgnoreCase(chon[k]))
            {
                    correctanswer++;
            }
            else if(userans[k].equals("e"))
            {
                    unattempted++;
            }
            else
            {
                    wronganswer++;
            }
    }
    int attemped = size - unattempted;
   request.setAttribute("size", size);
   request.setAttribute("attemped", attemped);
   request.setAttribute("correctanswer", correctanswer);
     request.setAttribute("wrong", wronganswer);
     Score r = new Score();
     r.insertScore(user,id,size,attemped,correctanswer,wronganswer);
     request.getRequestDispatcher("Result.jsp").forward(request, response);
    }else{
               response.sendRedirect("Message.jsp");
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
