package loginform;

import java.sql.*;

public class Connectionprovider {
    
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/connect","root","yournewpassword");
            return con;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
}