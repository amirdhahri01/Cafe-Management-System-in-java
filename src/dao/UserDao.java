package dao;

import javax.swing.JOptionPane;
import model.User;
import java.sql.ResultSet;

public class UserDao {

    public static void save(User user) {
        String query = "INSERT INTO user(name,email,address,mobileNumber,password,securityQuestion,answer,status) VALUES('" + user.getName() + "','" + user.getEmail() + "','" + user.getAddress() + "','" + user.getMobileNumber() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer() + "','false')";
        System.out.println(query);
        DbOperations.setDatOrDelete(query, "Registered successfully, wait for admin approval.");
    }

    public static User login(String email, String password) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email='" + email + "' and password='" + password + "'");
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }

}
