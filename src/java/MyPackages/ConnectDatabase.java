/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author archit08jain
 */
public class ConnectDatabase {
 
    public static boolean addProblem(Problem p) throws SQLException, ClassNotFoundException
    {
        /*Class.forName("com.mariadb.jdbc.Driver");
        
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/interviewprep?user=root&password=");*/
        
        Class.forName("org.mariadb.jdbc.Driver");  

        Connection con = DriverManager.getConnection(  
                "jdbc:mariadb://localhost:3306/interviewprep", "root", ""); 
 
            PreparedStatement ps = con.prepareStatement("insert into problems "
                +"values(?,?,?,?,?,?)" );
            ps.setString(1, String.valueOf(p.getId()));
            ps.setString(2, p.getName());
            ps.setString(3, p.getDescription());
            ps.setString(4, p.getInput());
            ps.setString(5, p.getOutput());
            ps.setString(6, p.getSamples());
            ps.executeUpdate();
             
           con.close();
           return true;
    }
    public static String getProblems() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con =
            DriverManager.getConnection("jdbc:mysql://localhost:3306/interviewprep?user=root&password=");
 
            PreparedStatement ps1 = con.prepareStatement("select * from problems");
             
            ResultSet rs = ps1.executeQuery();
            int count = 0;
            String result = "";
            while(rs.next())
            {
                result = result + rs.getString(count+1);
                count++;
 
            }
          
   
           con.close();
           return result;
    }
   
   
}
