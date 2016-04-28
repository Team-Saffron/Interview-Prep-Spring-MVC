package MyPackages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
    private static Connection con = null;
    private Database(){}
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        
        if(con!=null)
                return con;
        
         Class.forName("org.mariadb.jdbc.Driver");  
         con = DriverManager.getConnection(  
                "jdbc:mariadb://localhost:3306/interviewprep", "root", ""); 
         
         return con;
    }
    
}
