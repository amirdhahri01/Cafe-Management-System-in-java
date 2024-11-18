package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Category;

public class CategoryDao {

    public static void save(Category category) {
        String query = "INSERT INTO category(name) VALUES('" + category.getName() + "');";
        DbOperations.setDatOrDelete(query, "Category Addedd Successfully");
    }

    public static ArrayList<Category> getAllRecords() {
        ArrayList<Category> arr = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM category;");
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arr.add(category);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);

        }
        return arr;
    }
    
    public static void delete(String id){
        String query = "DELETE FROM category WHERE id='"+id+"';";
        DbOperations.setDatOrDelete(query, "Category Deleted Successfully");
    }
}
