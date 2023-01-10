<%-- 
    Document   : Result
    Created on : Nov 4, 2022, 3:57:31 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table  border="1" style="    margin: auto;
    font-size: 50px;">
  <thead >
    <tr class="table-warning">
        <th colspan="3" scope="col"><center><pre>RESULT'S <b>${sessionScope.accS}</b></pre></center></th>
    </tr>
  </thead>
  <tbody>
      <tr>
  
      <td>Mã Môn</td>
      <td>${sid}</td>
    </tr>
    <tr>
  
      <td>Tổng số câu hỏi</td>
      <td>${size} </td>
    </tr>
    <tr>

      <td>Số câu đã làm</td>
      <td>${attemped} </td>
    </tr>
    <tr>
   
      <td  >Trả lời đúng</td>
      <td >${correctanswer} </td>
    </tr>
     <tr>
    
      <td>Trả lời sai</td>
      <td >${wrong}     </td>
    </tr>
     <tr>
    
      <td>  <a href="main.jsp">Back</a>
</td>
      <td >      </td>
    </tr>
  </tbody>
</table>
        </body>
</html>
