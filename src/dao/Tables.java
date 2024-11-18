package dao;


public class Tables {
    private static final String USER_TABLE = "CREATE TABLE IF NOT EXISTS user(id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(200) , email VARCHAR(200) , address VARCHAR(200) ,  mobileNumber VARCHAR(200) , password VARCHAR(200) , securityQuestion VARCHAR(200) , answer VARCHAR(200) , status VARCHAR(200) , UNIQUE(email))";
    private static final String ADMIN_DETAILS = "INSERT INTO user(name,email,password,address,mobileNumber,securityQuestion ,answer ,status) values('admin','admin@gmail.com','Xdgxcx@200#3','Rue 9 avril,Gabes','98949697','Simba','Simba','true')";
    public static void main(String[] args){
        try{
            //DbOperations.setDatOrDelete(USER_TABLE, "User Table Created Successfully");
            DbOperations.setDatOrDelete(ADMIN_DETAILS, "Admin Details Added Successfully");
        }catch(Exception e){
            
        }
    }
}
