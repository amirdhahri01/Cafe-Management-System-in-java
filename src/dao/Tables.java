package dao;


public class Tables {
    private static final String USER_TABLE = "CREATE TABLE IF NOT EXISTS user(id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(200) , email VARCHAR(200) , address VARCHAR(200) ,  mobileNumber VARCHAR(200) , password VARCHAR(200) , securityQuestion VARCHAR(200) , answer VARCHAR(200) , status VARCHAR(200) , UNIQUE(email))";
    public static void main(String[] args){
        try{
            DbOperations.setDatOrDelete(USER_TABLE, "User Table Created Successfully");
        }catch(Exception e){
            
        }
    }
}
