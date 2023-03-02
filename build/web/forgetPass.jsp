<%-- 
    Document   : forgetPass
    Created on : Oct 19, 2022, 12:37:05 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="css/fgpass.css">
  </head>
  <body>
    <div class="center">
      <h1>Fogot Password</h1>
      <p style="color: red;text-align: center">${err}</p>
      <form method="get" action="forget">
        <div class="txt_field">
          <input type="text" required name="acc" >
          <span></span>
          <label>Tài khoản</label>
        </div>
        <div class="txt_field">
          <input type="text" required name="phone">
          <span></span>
          <label>Số điện thoại</label>
        </div>
        <div class="txt_field">
          <input type="password" required name="newpass">
          <span></span>
          <label>Mật khẩu mới</label>
        </div>
        
         
        
        
        <input type="submit" value="Đổi mật khẩu">
        <br>
        <br>
        <br>
      </form>
    </div>

  </body>
</html>
