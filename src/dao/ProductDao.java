package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;

public class ProductDao {

    public static void save(Product product) {
        String query = "INSERT INTO product(name,category,price) VALUES('" + product.getName() + "','" + product.getCategory() + "','" + product.getPrice() + "');";
        DbOperations.setDatOrDelete(query, "Product Added Successfully");
    }

    public static ArrayList<Product> getAllRecords() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM product");
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("ID"));
                product.setCategory(rs.getString("category"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getString("price"));
                products.add(product);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
        }
        return products;
    }
    
    public static void update(Product product){
        String query = "UPDATE product SET name='" + product.getName()+"',category='" + product.getCategory()+"',price='"+product.getPrice()+"' WHERE id="+product.getId()+";";
        DbOperations.setDatOrDelete(query, "Product Updated Successfully");
    }
    
    public static void delete(String id){
        String query = "DELETE FROM product WHERE if='"+id+"';";
         DbOperations.setDatOrDelete(query, "Product Deleted Successfully");
    }
    
    public static ArrayList<Product> getProductsByCategory(String category){
        ArrayList<Product> products = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE category='"+category+"';");
            while(rs.next()){
                Product product = new Product();
                product.setName(rs.getString("name"));
                products.add(product);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage() , "Message" , JOptionPane.ERROR_MESSAGE);
        }
        return products;
    }
    
    public static ArrayList<Product> filterProductByCategory(String name, String category){
        ArrayList<Product> products = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE name like '%"+name+"%' and category='"+category+"';");
            while(rs.next()){
                Product product = new Product();
                product.setName(rs.getString("name"));
                products.add(product);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage() , "Message" , JOptionPane.ERROR_MESSAGE);
        }
        return products;
    }
    
    public static Product getProductByName(String name){
        Product product = new Product();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE name='" + name + "';");
            rs.next();
            product.setName(rs.getString("name"));
            product.setCategory(rs.getString("category"));
            product.setPrice(rs.getString("price"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() , "Message" , JOptionPane.ERROR_MESSAGE);
        }
        return product;
    }
}
