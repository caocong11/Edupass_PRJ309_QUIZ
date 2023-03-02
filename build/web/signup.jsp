<%-- 
    Document   : signup
    Created on : Oct 18, 2022, 1:58:35 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Sign up</title>
    <link rel="stylesheet" href="css/signup.css">
  </head>
  <body>
    <div class="center">
      <h1>Sign up</h1>
      <h2 style="color: red;text-align: center" >${err}</h2>
      <form method="get" action="signup">
        
        <div class="txt_field">
          <input type="text" required name="acc">
          <span></span>
          <label>Tài khoản</label>
        </div>
        <div class="txt_field">
          <input type="password" required name="pass">
          <span></span>
          <label>Mật khẩu</label>
        </div>
            <div class="txt_field">
          <input type="password" required name="repass">
          <span></span>
          <label>Nhập lại mật khẩu</label>
        </div>
        <div class="txt_field">
          <input type="number" required name="phone">
          <span></span>
          <label>Số điện thoại</label>
        </div>
       
        <br>
        
          
          <br>
          <br> 
         
        
        
        <input type="submit" value="Đăng ký">
        <div class="signup_link">
          Bạn đã có tài khoản: <a href="login.jsp">Đăng nhập</a>
          
        </div>
      </form>
    </div>

  </body>
</html>
