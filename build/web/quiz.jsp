<%-- 
    Document   : quiz
    Created on : Nov 4, 2022, 1:25:49 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="enity.Quiz" %>
<%@page  import="java.util.List" %>
<%@page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz </title>
    </head>     
    <body style="background-image: url('https://hainh2k3.com/wp-content/uploads/2018/11/Random-Pure-CSS-Parallax-Stars.gif')  ;color: white;font-size: 20px;font-family: monospace">
        
        <c:if test="${sid==2}"><h2 style="    border: 10px white solid;
    display: table;
    border-radius: 5px;
    margin: auto;
    padding: 20px;
    font-size: 34px;">TEST CSD202</h2></c:if>
         <c:if test="${sid==3}"><h2 style="    border: 10px white solid;
    display: table;
    border-radius: 5px;
    margin: auto;
    padding: 20px;
    font-size: 34px;">TEST DBI201</h2></c:if>
          <c:if test="${sid==1}"><h2 style="    border: 10px white solid;
    display: table;
    border-radius: 5px;
    margin: auto;
    padding: 20px;
    font-size: 34px;">TEST PRJ301</h2></c:if>
        <form action="quiz" method="post">
           
                <%
                    HttpSession a = request.getSession();
                int i = 1;
                int radioname = 0;
                int count = 0;
                 String id = request.getParameter("sid");
                  String le = (String) a.getAttribute("level");
              Quiz q = new Quiz();
        List<Quiz> list = q.getQuestionAllbyLevel(id,le);
                    for(Quiz e : list)
                    {   
                         
                    %> 
                
                <h3>Question<%=i++%>:</h3>
                <h4><%=e.getQuestion() %></h4>
                <input type="radio"  value="a" name="<%=radioname%>">A.<%=e.getAnA()%><br>
                <input type="radio" value="b" name="<%=radioname%>">B.<%=e.getAnB()%><br>
                <input type="radio" value="c" name="<%=radioname%>">C.<%=e.getAnC()%><br>
                <input type="radio" value="d" name="<%=radioname%>">D.<%=e.getAnD()%><br>
                <br>
                
                
                <br>
                <input type="radio" style="display: none" value="e" name="<%=radioname %>" checked="checked" name=<%=radioname %> >
 
        <%
        radioname++;
       
        }
        %>
        <input type="submit" value="submit">
        <input type="reset" value="reset">
        </form>
    </body>
</html>
