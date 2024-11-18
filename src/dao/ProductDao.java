package dao;

import model.Product;

public class ProductDao {
    
    public static void save(Product product){
        String query = "INSERT INTO product(name,category,price) VALUES('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"');";
        DbOperations.setDatOrDelete(query, "Product Added Successfully");
    }
    
}
