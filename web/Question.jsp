<%-- 
    Document   : Question
    Created on : Nov 10, 2022, 3:18:05 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="enity.Quiz" %>
<%@page  import="java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="quiz" method="post">
           
                <%
                    HttpSession a = request.getSession();
                int i = 1;
                int radioname = 0;
                int count = 0;
//                 String id = request.getParameter("sid");
//                  String le = (String) a.getAttribute("level");
              Quiz q = new Quiz();
        List<Quiz> list = q.getQuestionA() ;
                    for(Quiz e : list)
                    {   
                         
                    %> 
                
                <h3>Question<%=i++%>:<%=e.getQuestion() %></h3>
               
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
        <input type="submit" value="next">
<!--        <input type="reset" value="reset">-->
        </form>
    </body>
</html>
