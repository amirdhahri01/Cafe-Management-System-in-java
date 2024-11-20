package dao;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }

    public static User getSecurityQuestion(String email) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email='" + email + "'");
            while (rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }

    public static void update(String email, String password) {
        String query = "UPDATE user SET password = '" + password + "' WHERE email='" + email + "'";
        DbOperations.setDatOrDelete(query, "Password Changed Successfully");
    }

    public static ArrayList<User> getAllRecords(String email) {
        ArrayList<User> users = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email like '%" + email + "%'");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setPassword(rs.getString("password"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
                user.setStatus(rs.getString("status"));
                users.add(user);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
        return users;
    }

    public static void changeState(String email, String status) {
        String query = "UPDATE user SET status='" + status + "' WHERE email='" + email + "';";
        DbOperations.setDatOrDelete(query, "User Status Updated Successfully");
    }

    public static void changePassword(String email, String oldPassword, String newPassword) {
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email='" + email + "' and password='" + oldPassword + "';");
            if (rs.next()) {
                update(email, newPassword);
            } else {
                JOptionPane.showMessageDialog(null, "Old password is wrong");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void changeSecurityQuestion(String email, String password, String securityQuestion, String answer) {
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email='" + email + "' and password='" + password + "';");
            if (rs.next()) {
                
            } else {
                JOptionPane.showMessageDialog(null, "Email or Password if invalid.");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
}
