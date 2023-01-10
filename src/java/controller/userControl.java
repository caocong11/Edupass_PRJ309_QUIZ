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
import java.util.List;

/**
 *
 * @author ASUS
 */
public class userControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("accS")!=null) {
            if(session.getAttribute("accS").equals("admin")){
            User u = new User();
            List<User> list = u.getAll();
            req.setAttribute("list", list);
            req.getRequestDispatcher("admin.jsp").forward(req, resp);
            }
            else {
            resp.sendRedirect("Message.jsp");
        }
        } else {
            resp.sendRedirect("Message.jsp");
        }

    }

}
