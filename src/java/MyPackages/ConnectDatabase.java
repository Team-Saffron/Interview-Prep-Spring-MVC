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

public class ConnectDatabase {
 
    public static boolean addProblem(Problem p) throws SQLException, ClassNotFoundException
    {
            PreparedStatement ps = Database.getConnection().prepareStatement("insert into problems "
                +"values(?,?,?,?,?,?)" );
            ps.setString(1, String.valueOf(p.getId()));
            ps.setString(2, p.getName());
            ps.setString(3, p.getDescription());
            ps.setString(4, p.getInput());
            ps.setString(5, p.getOutput());
            ps.setString(6, p.getSamples());
            ps.executeUpdate();
             
           return true;
    }
    public static ArrayList<Problem> getProblems(int start,int end) throws SQLException, ClassNotFoundException
    {
            PreparedStatement ps1 = Database.getConnection().prepareStatement("select * from problems where id between " + start + " and " + end);
             
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
           return problemPool;
    }
    
     public static boolean addUser(User u) throws SQLException, ClassNotFoundException
    {
            PreparedStatement ps = Database.getConnection().prepareStatement("insert into user(username,password,fullname,email) "
                +"values(?,?,?,?)" );
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getFullname());
            ps.setString(4,u.getEmail());
            ps.executeUpdate();
            
           return true;
    }
     
       public static boolean addComment(Comment c) throws SQLException, ClassNotFoundException
    {
            PreparedStatement ps =  Database.getConnection().prepareStatement("insert into comment(heading,content,timestamp,userId) "
                +"values(?,?,?,?)" );
            ps.setString(1,c.getHeading());
            ps.setString(2, c.getContent());
            ps.setString(3,String.valueOf(c.getTimestamp()));
            ps.setString(4,c.getUserId());
            ps.executeUpdate();
             
           return true;
    }
       
    public static ArrayList<Comment> getComments(int start,int end) throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =
            DriverManager.getConnection("jdbc:mysql://localhost:3306/interviewprep?user=root&password=");
            PreparedStatement ps1 = con.prepareStatement("select * from comment where id between " + start + " and " + end + " order by id DESC;");
             
            ResultSet rs = ps1.executeQuery();
            
            ArrayList<Comment> problemPool = new ArrayList<Comment>();
            while(rs.next())
            {
                Comment newProb  = new Comment();
                newProb.setId(rs.getString("id"));
                newProb.setHeading(rs.getString("heading"));
                newProb.setContent(rs.getString("content"));
            //    newProb.setTimestamp(String.valueOf(rs.getDate(4)));
                newProb.setUserId(rs.getString("userId"));
                problemPool.add(newProb);
            }
      
           con.close();
           return problemPool;
    }
    
      public static boolean addCommentResponse(int id,Comment u) throws SQLException, ClassNotFoundException
    {
            PreparedStatement ps = Database.getConnection().prepareStatement("insert into reply "
                +"values(?,?,?)" );
            ps.setInt(1,id);
            ps.setString(2, u.getHeading());
            ps.setString(3, u.getContent());
            ps.executeUpdate();
           
           return true;
    }
      
    public static ArrayList<Comment> getResponses(int id) throws SQLException, ClassNotFoundException
    {
        
            PreparedStatement ps1 = Database.getConnection().prepareStatement("select * from reply where id = " + id + ";");
             
            ResultSet rs = ps1.executeQuery();
            
            ArrayList<Comment> problemPool = new ArrayList<Comment>();
            while(rs.next())
            {
                Comment newProb  = new Comment();
               
                newProb.setHeading(rs.getString("name"));
                newProb.setContent(rs.getString("content"));
                problemPool.add(newProb);
            }
           return problemPool;
    }
    
    public static boolean authenticateUser(User newUser)throws SQLException, ClassNotFoundException{
     
            Connection conn  = Database.getConnection();
            
            PreparedStatement ps1 = Database.getConnection().prepareStatement("SELECT * FROM `user` WHERE username ="+ "\""+newUser.getUsername()+"\"");
            
            ResultSet rs = ps1.executeQuery();
            
            int count = 0;
            while(rs.next())
            {
                count++;
               
                String password = rs.getString("password");
                
                if(password.equals(newUser.getPassword()))
                        return true;
                else
                    return false;
            }
            return false;
    }
    
    
    public static boolean contains(User newUser) throws SQLException, ClassNotFoundException{
        
        
            Connection conn  = Database.getConnection();
            
            PreparedStatement ps1 = Database.getConnection().prepareStatement("SELECT * FROM `user` WHERE username ="+ "\""+newUser.getUsername()+"\"");
            ResultSet rs = ps1.executeQuery();
            
            int count =0;
            while(rs.next())
            {
                count++;
            }
            
            if(count==0)
            return false;
            else
            return true;
            
    }
   
     
   
}
