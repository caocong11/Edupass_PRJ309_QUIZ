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
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class FGPass extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String acc = req.getParameter("acc");
       String phone = req.getParameter("phone");
       String newpass  = req.getParameter("newpass");
       User u = new User();
       
       if (u.checkConPass(acc,phone)) {
           u.changePass(acc,newpass);
            req.setAttribute("acc", acc);
            req.setAttribute("pass", newpass);
            
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            
        } else {
            req.setAttribute("err", "Tài khoản hoặc SĐT của bạn không đúng!");
            req.getRequestDispatcher("forgetPass.jsp").forward(req, resp);
        }
    }
    
}
