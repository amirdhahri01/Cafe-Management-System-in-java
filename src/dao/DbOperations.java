package dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DbOperations {

    public static void setDatOrDelete(String query, String msg) {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            st.executeUpdate(query);
            if (!msg.equals("")) {
                JOptionPane.showMessageDialog(null, msg);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
}
