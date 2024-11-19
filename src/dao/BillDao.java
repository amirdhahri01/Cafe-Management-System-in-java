package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Bill;

public class BillDao {

    public static String getID() {
        int id = 1;
        try {
            ResultSet rs = DbOperations.getData("SELECT MAX(id) FROM bill");
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
        return String.valueOf(id);
    }

    public static void save(Bill bill) {
        String query = "INSERT INTO bill VALUES('" + bill.getID() + "','" + bill.getName() + "','" + bill.getMobileNumber() + "','" + bill.getEmail() + "','" + bill.getDate() + "','" + bill.getTotal() + "','" + bill.getCreatedBy() + "');";
        DbOperations.setDatOrDelete(query, "Bill Details Added Successfully");
    }
    
}
