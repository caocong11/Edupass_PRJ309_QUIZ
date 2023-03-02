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
import java.util.regex.Pattern;

/**
 *
 * @author ASUS
 */
public class SignupControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acc = req.getParameter("acc");
        String pass = req.getParameter("pass");
        String repass = req.getParameter("repass");

        boolean isMatch = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,20}$")
                .matcher(pass)
                .find();
        String phone = req.getParameter("phone");
        if (isMatch == true) {
            User u = new User();

            if (u.checkAccount(acc)) {

                req.setAttribute("err", "Tài khoản đã có sẵn.Vui lòng đăng ký lại!!!!");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);

            } else {
                if (pass != repass) {
                    req.setAttribute("err", "Mật khẩu không trùng nha");
                    req.getRequestDispatcher("signup.jsp").forward(req, resp);
                } else {
                    HttpSession session = req.getSession();
                    session.setAttribute("accS", acc);
                    session.setAttribute("passS", pass);

                    u.createUser(acc, pass, phone);
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }

            }
        } else {
            req.setAttribute("err", "Mât khẩu có ít nhất 8-20 kí tự, có ít nhất 1 kí tự viết hoa và số tự nhiên ");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }

    }

}
