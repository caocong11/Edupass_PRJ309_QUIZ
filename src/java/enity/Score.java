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

/**
 *
 * @author ASUS
 */
public class Score extends DBContext1{
    private int id;
    private String user;
    private int ques_id;
    private int total;
    private int num_choice;
    private int correct;
    private int incorrect;

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
    public Score() {
        connectDB();
    }

    public Score(int id, String user, int ques_id, int total, int num_choice, int correct, int incorrect) {
        this.id = id;
        this.user = user;
        this.ques_id = ques_id;
        this.total = total;
        this.num_choice = num_choice;
        this.correct = correct;
        this.incorrect = incorrect;
         connectDB();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getQues_id() {
        return ques_id;
    }

    public void setQues_id(int ques_id) {
        this.ques_id = ques_id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNum_choice() {
        return num_choice;
    }

    public void setNum_choice(int num_choice) {
        this.num_choice = num_choice;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    public void insertScore(String user, String id, int size, int attemped, int correctanswer, int wronganswer) {
       try {
            String query = "insert into user_score([user],question_id,total_question\n" +
",number_choice,correct,incorrect)\n" +
"values( ?,?,?,?,?,?) ";

            pstm = cnn.prepareStatement(query);
            pstm.setString(1, user);
            pstm.setString(2, id);
            pstm.setInt(3, size);
            pstm.setInt(4, attemped);
            pstm.setInt(5, correctanswer);
            pstm.setInt(6, wronganswer);
          
            pstm.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
}
