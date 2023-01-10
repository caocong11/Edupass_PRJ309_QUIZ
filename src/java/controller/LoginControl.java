/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import enity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class LoginControl extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acc = req.getParameter("acc");
        String pass = req.getParameter("pass");
        
         User u = new User();
        HttpSession session = req.getSession();
        if (u.checkAccountLogin(acc,pass)) {
//            req.setAttribute("acc", acc);
//            req.setAttribute("pass", pass);
           
            session.setAttribute("accS", acc);
            session.setAttribute("passS", pass);
           
        
           resp.sendRedirect("main.jsp");
//            req.getRequestDispatcher("main.jsp").forward(req, resp);
           
        } else {
             req.setAttribute("err", "Mật khẩu hoặc tài khoản của bạn đã nhập sai.Xin vui lòng thử lại!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
    
}
