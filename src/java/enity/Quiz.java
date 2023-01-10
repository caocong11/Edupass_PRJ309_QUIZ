/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enity;

import context.DBContext1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Quiz extends DBContext1{
   private String id;
   private String question;
   private String anA;
   private String anB;
   private String anC;
   private String anD;
   private String correct;

    public Quiz(String id, String question, String anA, String anB, String anC, String anD, String correct) {
        this.id = id;
        this.question = question;
        this.anA = anA;
        this.anB = anB;
        this.anC = anC;
        this.anD = anD;
        this.correct = correct;
        connectDB();
    }

    public Quiz() {
         connectDB();
    }
      //Khai bao cac thanh phan xu ly DB
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnA() {
        return anA;
    }

    public void setAnA(String anA) {
        this.anA = anA;
    }

    public String getAnB() {
        return anB;
    }

    public void setAnB(String anB) {
        this.anB = anB;
    }

    public String getAnC() {
        return anC;
    }

    public void setAnC(String anC) {
        this.anC = anC;
    }

    public String getAnD() {
        return anD;
    }

    public void setAnD(String anD) {
        this.anD = anD;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public List<Quiz> getQuestionAllbyLevel(String id,String level) {
         List<Quiz> list = new ArrayList<>();

        try {
            String query = "select  ROW_NUMBER () OVER( order by quiz_choice_id ) as id,question,answer1,answer2,answer3,answer4,is_correct_choice from question_choices where question_id =? and [level]=? ";
            pstm = cnn.prepareStatement(query);
            pstm.setString(1, id);
            pstm.setString(2, level);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new Quiz(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Quiz> getQuestionAll(String id) {
         List<Quiz> list = new ArrayList<>();

        try {
            String query = "select  ROW_NUMBER () OVER( order by quiz_choice_id ) as id,question,answer1,answer2,answer3,answer4,is_correct_choice from question_choices where question_id =?";
            pstm = cnn.prepareStatement(query);
            pstm.setString(1, id);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new Quiz(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Quiz> getQuestionA() {
         List<Quiz> list = new ArrayList<>();

        try {
            String query = "select * from quiz where id = 1";
            pstm = cnn.prepareStatement(query);
           
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new Quiz(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
   
}
