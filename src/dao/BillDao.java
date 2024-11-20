package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public static ArrayList<Bill> getAllRecordsByInc(String date) {
        ArrayList<Bill> bills = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM bill WHERE date LIKE '%" + date + "%';");
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setID(rs.getString("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                bills.add(bill);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
        return bills;
    }
    
    public static ArrayList<Bill> getAllRecordsByDesc(String date) {
        ArrayList<Bill> bills = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM bill WHERE date LIKE '%" + date + "%' ORDER BY id DESC;");
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setID(rs.getString("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                bills.add(bill);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
        return bills;
    }

}
