<%-- 
    Document   : login
    Created on : Oct 18, 2022, 1:37:58 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css">
  </head>
  <body>
    <div class="center">
      <h1>Login</h1>
      <p style="color: red;text-align: center">${err}</p>
      <form method="get" action="login">
        <div class="txt_field">
            <input type="text" required name="acc" value="${acc}">
          <span></span>
          <label>Username</label>
        </div>
        <div class="txt_field">
          <input type="password" required name="pass" value="${pass}">
          <span></span>
          <label>Password</label>
        </div>
        <div class="pass"><a href="forgetPass.jsp">Forgot Password?</div>
        <input type="submit" value="Login">
        <div class="signup_link">
          Not a member? <a href="signup.jsp">Signup</a>
        </div>
       
      </form>
    </div>

  </body>
</html>
