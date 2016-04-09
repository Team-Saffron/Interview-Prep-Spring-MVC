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
import java.util.ArrayList;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author archit08jain
 */
public class ConnectDatabase {
 
    public static boolean addProblem(Problem p) throws SQLException, ClassNotFoundException
    {
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
    public static ArrayList<Problem> getProblems(int start,int end) throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =
            DriverManager.getConnection("jdbc:mysql://localhost:3306/interviewprep?user=root&password=");
            PreparedStatement ps1 = con.prepareStatement("select * from problems where id between " + start + " and " + end);
             
            ResultSet rs = ps1.executeQuery();
            
            ArrayList<Problem> problemPool = new ArrayList<Problem>();
            while(rs.next())
            {
                Problem newProb  = new Problem();
                newProb.setId(rs.getInt(1));
                newProb.setName(rs.getString(2));
                newProb.setDescription(rs.getString(3));
                newProb.setInput(rs.getString(4));
                newProb.setSamples(rs.getString(6));
                newProb.setOutput(rs.getString(5));
                problemPool.add(newProb);
            }
      
           con.close();
           return problemPool;
    }
    
     public static boolean addUser(User u) throws SQLException, ClassNotFoundException
    {
        Class.forName("org.mariadb.jdbc.Driver");  

        Connection con = DriverManager.getConnection(  
                "jdbc:mariadb://localhost:3306/interviewprep", "root", ""); 
 
            PreparedStatement ps = con.prepareStatement("insert into user(username,passwrod,fullname,email) "
                +"values(?,?,?,?)" );
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPasswrod());
            ps.setString(3, u.getFullname());
            ps.setString(4,u.getEmail());
            ps.executeUpdate();
             
           con.close();
           return true;
    }
   
   
}
