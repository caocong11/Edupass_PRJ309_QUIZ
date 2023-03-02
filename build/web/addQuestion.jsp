<%-- 
    Document   : addQuestion
    Created on : Oct 30, 2022, 1:08:14 PM
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
        <form action="addQ" method="post">
            <table>
                <tr>
                    <td>QuestionID</td>
                    <td>
                        <select name="questionID">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                        </select>
                        
                    </td>
                </tr>
                <tr>
                    <td>Question</td>
                    <td>
                        <input type="text" name="question">
                    </td>
                </tr>
                <tr>
                    <td>Answer1</td>
                    <td>
                        <input type="text" name="answer1" >
                        
                    </td>
                </tr>
                <tr>
                    <td>Answer2</td>
                    <td><input type="text" name="answer2"></td>
                </tr>
                <tr>
                    <td>Answer3</td>
                    <td><input type="text" name="answer3"></td>
                </tr>
                <tr>
                    <td>Answer4</td>
                    <td><input type="text" name="answer4"></td>
                </tr>
                <tr>
                    <td>RightAnswer</td>
                    <td><input type="text" name="rightanswer"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Add Question</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
