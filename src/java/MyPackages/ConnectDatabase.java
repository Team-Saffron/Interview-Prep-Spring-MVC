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
 
    public static boolean addProblem(Problem p) throws SQLException
    {
        Connection con =
            DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                +"record?user=root&password=");
 
            PreparedStatement ps1 = con.prepareStatement("select * from problems");
             
            ResultSet rs = ps1.executeQuery();
            int count = 0;
            while(rs.next())
            {
                count++;
                break;
                
            }
          
            if(count!=0) 
                    return false;
            
            String query = "insert into problems values(" + p.getId() 
                    + "," + p.getName()
                    + "," + p.getDescription()
                    + "," + p.getInput()
                    + "," + p.getOutput()
                    + "," + p.getSamples()
                    +");";
             
           ps1 = con.prepareStatement(query);
            
           return true;
    }
}
