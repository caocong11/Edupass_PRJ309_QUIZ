/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enity;

import context.DBContext1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Question extends DBContext1 {

    private String id;
    private String rightAnswer;
    private String type_id;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String Question;

    Connection cnn; //Ket noi DB
    Statement stm; // Thuc hien cau lanh sql
    ResultSet rs; //Luu tru va xu ly du lieu
    PreparedStatement pstm;

    private void connectDB() {
        try {
            cnn = super.connection;
            System.out.println("Connect success");
        } catch (Exception e) {
            System.out.println("Connect error: " + e.getMessage());
        }
    }

    public Question(String id, String rightAnswer, String type_id, String answerA, String answerB, String answerC, String answerD, String Question) {
        this.id = id;
        this.rightAnswer = rightAnswer;
        this.type_id = type_id;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.Question = Question;
        connectDB();
    }

    public Question() {
        connectDB();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public List<Question> getAll1() {
        List<Question> list = new ArrayList<>();

        try {
            String query = "select * from question_choices";
            pstm = cnn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new Question(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insertQuestion(String questID, String question, String answer1, String answer2, String answer3, String answer4, String rightanswer) {
        try {
            String query = "insert into question_choices(is_correct_choice,question_id,answer1,answer2,answer3,answer4,question)\n"
                    + "values(?,?,?,?,?,?,?)";

            pstm = cnn.prepareStatement(query);
            pstm.setString(1, rightanswer);
            pstm.setString(2, questID);
            pstm.setString(3, answer1);
            pstm.setString(4, answer2);
            pstm.setString(5, answer3);
            pstm.setString(6, answer4);
            pstm.setString(7, question);
            pstm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Question getQuestionbyID(String id) {
        try {
            String query = "select * from question_choices where quiz_choice_id =? ";

            pstm = cnn.prepareStatement(query);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return new Question(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            }
        } catch (Exception e) {
            System.err.println("get QuestionbyID error:" + e.getMessage());
        }
        return null;
    }

    public void updateQuestion(String id, String questID, String question, String answer1, String answer2, String answer3, String answer4, String rightA) throws SQLException {
         try {
        String query = "UPDATE question_choices set is_correct_choice =?,question_id=?,answer1=?,answer2=?,answer3=?,answer4=?,question=?\n"
                + "where quiz_choice_id = ?";
        pstm = cnn.prepareStatement(query);
        pstm.setString(1, rightA);
        pstm.setString(2, questID);
        pstm.setString(3, answer1);
        pstm.setString(4, answer2);
        pstm.setString(5, answer3);
        pstm.setString(6, answer4);
        pstm.setString(7, question);
        pstm.setString(8, id);
        pstm.executeUpdate();
    }
    catch (Exception e

        ) {
              System.err.println("update Question error:" + e.getMessage());
    }
}

    public void deleteQuestion(String id) {
         try {
             String query = "delete from question_choices where quiz_choice_id =? ";
            pstm = cnn.prepareStatement(query);
            pstm.setString(1, id);
            pstm.executeUpdate();
        } catch (Exception e) {
              System.err.println("Delete Question error:" + e.getMessage());
        }
    }

    public List<Question> searchQuestion(String textQ) {
        List<Question> list = new ArrayList<>();
        

        try {
            String query = "select * from question_choices where question like ? ";
           
            pstm = cnn.prepareStatement(query);
            pstm.setString(1, "%" + textQ + "%");

            rs=pstm.executeQuery();
            while (rs.next()) {
                 list.add(new Question(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (Exception e) {
        }
       return list;
    }

}
