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
public class User extends DBContext1 {
    private String id;
    private String acc;
    private String pass;
    private String phone;
    private int is_admin;

    public User() {
        connectDB();
    }

    public User(String id,String acc, String pass, String phone, int is_admin) {
         this.id=id;
        this.acc = acc;
        this.pass = pass;
        this.phone = phone;
        this.is_admin = is_admin;
       connectDB();
    }
     public User(String id,String acc, String pass, String phone) {
     this.id=id;
        this.acc = acc;
        this.pass = pass;
        this.phone = phone;
        
       connectDB();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
 
    public String getAcc() {
        return acc;
        
    }

    public void setAcc(String acc) {
        this.acc = acc;
         
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
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

    public boolean checkAccount(String acc) {
        try {
            String strSelect = "select * from users "
                    + "where quiz_username=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, acc);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
                //ton tai
            }
        } catch (Exception e) {
            System.err.println("CheckAcc error:" + e.getMessage());
        }
        return false;
    }

    public boolean checkAccountLogin(String acc, String pass) {
        try {
            String strSelect = "select * from users "
                    + "where quiz_username=? and "
                    + "quiz_userpassword=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, acc);
            pstm.setString(2, pass);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
                //ton tai
            }
        } catch (Exception e) {
            System.err.println("Check acc for login error:" + e.getMessage());
        }
        return false;
    }

    public boolean checkConPass(String acc, String phone) {
        try {
            String strSelect = "select * from users "
                    + "where quiz_username=? and "
                    + "quiz_userphone=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, acc);
            pstm.setString(2, phone);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
                //ton tai
            }
        } catch (Exception e) {
            System.err.println("change pass error:" + e.getMessage());
        }
        return false;
    }

    public void changePass(String acc, String newpass) {

        try {
            String strSelect = "update users "
                    + "set quiz_userpassword = ? "
                    + "where quiz_username = ? ";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(2, acc);
            pstm.setString(1, newpass);

            pstm.executeUpdate();

        } catch (Exception e) {
            System.err.println("Update pass error:" + e.getMessage());
        }

    }

    public void createUser(String acc, String pass, String phone) {
        try {
            String strSelect = "insert into "
                    + "users(quiz_username,quiz_userpassword,quiz_userphone) values(?,?,?) ";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, acc);
            pstm.setString(2, pass);
            pstm.setString(3, phone);
           
            pstm.executeUpdate();

        } catch (Exception e) {
            System.err.println("Create User error:" + e.getMessage());
        }
    }

   public List<User> getAll(){
        List<User> list = new ArrayList<>();
        String  sql ="select * from users";
        
          try {
          PreparedStatement st = connection.prepareStatement(sql);
          ResultSet rs = st.executeQuery();
          while(rs.next()){
              User s = new User();
              s.setId(rs.getString("quiz_user_id"));
              s.setAcc(rs.getString("quiz_username"));
              s.setPass(rs.getString("quiz_userpassword"));
              s.setPhone(rs.getString("quiz_userphone"));
              s.setIs_admin(rs.getInt("is_admin"));
              list.add(s);
          }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
        
    }

    public void deleteUser(String id) {
        
        
        try {
             String query = "delete from users where quiz_user_id = ? ";
            pstm = cnn.prepareStatement(query);
            pstm.setString(1, id);
            pstm.executeUpdate();
        } catch (Exception e) {
              System.err.println("Delete User error:" + e.getMessage());
        }
    }

    public void insertUser(String acc, String pass, String phone) {
          
        
        try {
            String query = "insert into users(quiz_username,quiz_userpassword,quiz_userphone)\n" +
"values(?,?,?) ";
        
            pstm = cnn.prepareStatement(query);
            pstm.setString(1, acc);
            pstm.setString(2, pass);
            pstm.setString(3, phone );
            pstm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public User getUserbyID(String id) {
      
        
        try {
               String query="select * from users\n" +
"where quiz_user_id = ? ";
            
            pstm = cnn.prepareStatement(query);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {                
                return new User(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
            }
        } catch (Exception e) {
               System.err.println("get UserbyID error:" + e.getMessage());
        }
        return null;
    }

    public void updateUser(String id,String acc, String pass, String phone) {
          
        
        try {
          String query = "update users\n" +
"set quiz_username = ?,\n" +
"quiz_userpassword = ?,\n" +
"quiz_userphone = ?\n" +
"where quiz_user_id =? ";
            pstm = cnn.prepareStatement(query);
            pstm.setString(1,acc);
            pstm.setString(2,pass);
            pstm.setString(3,phone);
            pstm.setString(4,id);
            pstm.executeUpdate();
        } catch (Exception e) {
              System.err.println("update User error:" + e.getMessage());
        }
    }

    public List<User> searchUser(String text) {
        List<User> list = new ArrayList<>();
        

        try {
            String query = "select * from users where quiz_username like ? ";
            pstm = cnn.prepareStatement(query);
            pstm.setString(1, "%" + text + "%");

            rs=pstm.executeQuery();
            while (rs.next()) {
                 list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println("Error search" + e.getMessage());
        }
       return list;
    }
    
     

}
