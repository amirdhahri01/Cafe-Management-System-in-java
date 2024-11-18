package dao;

import model.User;

public class UserDao {

    public static void save(User user) {
        String query = "INSERT INTO USER(name,email;address;mobileNumber,password,securityQuestion,answer,status) VALUES('" + user.getName() + "','" + user.getEmail() + "','" + user.getAddress() + "','" + user.getMobileNumber() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer() + user.getName() + "','false')";
        DbOperations.setDatOrDelete(query, "Registered successfully, wait for admin approval.");
    }

}
