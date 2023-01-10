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
public class SignupControl extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acc = req.getParameter("acc");
        String pass = req.getParameter("pass");
        
        String phone = req.getParameter("phone");
        
    

        User u = new User();

        if (u.checkAccount(acc)) {  
            
            req.setAttribute("err", "Tài khoản đã có sẵn.Vui lòng đăng ký lại!!!!");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
            
        } else {
              HttpSession session = req.getSession();
            session.setAttribute("accS", acc);
            session.setAttribute("passS", pass);
            
            u.createUser(acc, pass, phone);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
    
    
}
