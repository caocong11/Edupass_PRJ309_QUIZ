<%-- 
    Document   : updateQuestion
    Created on : Oct 31, 2022, 12:09:29 AM
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
        <form action="updateQ" method="post">
            <table>
                <tr style="display: none">
                    <td>ID</td>
                    <td>
                        <input type="text" value="${qu.getId()}" name="id" readonly>

                    </td>
                </tr>
                <tr>
                    <td>QuestionID</td>
                    <td>
                        <input type="text" value="${qu.getType_id()}" name="questionID">

                    </td>
                </tr>
                <tr>
                    <td>Question</td>
                    <td>
                        <input type="text" name="question" value="${qu.getQuestion()}">
                    </td>
                </tr>
                <tr>
                    <td>Answer1</td>

                    <td><input type="text" name="anwser1" value="${qu.getAnswerA()}"></td>


                </tr>
                <tr>
                    <td>Answer2</td>
                    <td><input type="text" name="anwser2" value="${qu.getAnswerB()}"></td>
                </tr>
                <tr>
                    <td>Answer3</td>
                    <td><input type="text" name="answer3" value="${qu.getAnswerC()}"></td>
                </tr>
                <tr>
                    <td>Answer4</td>
                    <td><input type="text" name="answer4" value="${qu.getAnswerD()}"></td>
                </tr>
                <tr>
                    <td>RightAnswer</td>
                    <td><input type="text" name="rightanswer" value="${qu.getRightAnswer()}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Update</button></td>
                </tr>
            </table>
                ${err}
        </form>
    </body>
</html>
