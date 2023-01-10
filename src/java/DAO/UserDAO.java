/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext1;
import enity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class UserDAO extends DBContext1{
    
      public List<User> getAll(){
        List<User> list = new ArrayList<>();
        String  sql ="select * from users";
        
          try {
          PreparedStatement st = connection.prepareStatement(sql);
          ResultSet rs = st.executeQuery();
          while(rs.next()){
              User s = new User();
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
    //test 
    public static void main(String[] args)  {
       UserDAO c = new UserDAO();
       List<User> list = c.getAll();
        System.out.println(list.get(0).getAcc());
       
    }
}
