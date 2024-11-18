package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "Xdgxcx@200#3";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/cms";

    public static Connection getCon() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

}
