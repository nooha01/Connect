/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connect;
import java.sql.*;

/**
 *
 * @author nooha01
 */
public class Connect {
    public Connection con;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ConnectDatabase","root","7545");
        
        if(con!=null){
            System.out.println("Successfully Connected");
        }
        
    }catch(Exception e){
            System.out.println(e);
            System.out.println("Not Connected");
    }
    
}
}
