/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import MyPackages.Comment;
import MyPackages.ConnectDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/discuss.htm")
public class Discuss {
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String getDiscussionPage(ModelMap modelMap) throws SQLException, ClassNotFoundException {
        
        ArrayList<Comment> comments = ConnectDatabase.getComments(0, 100);
        
        String cards = "";
        
        for(int i = 0;i<comments.size();i++)
                cards = cards + getCommentCardHTML(comments.get(i));
        
        modelMap.put("cards", cards);
        return "discuss";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String postComment(@ModelAttribute Comment newComment,ModelMap modelMap) throws SQLException, ClassNotFoundException {
                
      //  newComment.setTimestamp(new Date());
        newComment.setUserId((String) modelMap.get("session"));
        modelMap.put("newComment", newComment);
        
        ConnectDatabase.addComment(newComment);
        return "discuss";
    }
    
    @RequestMapping(value = "post/{id}")
    public String getCommentReplyPage(@RequestParam("id") int id,ModelMap modelMap) throws SQLException, ClassNotFoundException {
        
        ArrayList<Comment> comment = ConnectDatabase.getComments(id, id);
        modelMap.put("comment", comment.get(0));
        return "index";
    }
   
    public String getCommentCardHTML(Comment comment)
    {
         String html  = " <h2>" + comment.getHeading() + "</h2>\n" +
            "      <h5><span class=\"glyphicon glyphicon-time\"></span> Post by <b>" + comment.getUserId()+ ", Query" + ".</b></h5>\n" +
            "      <h5><span class=\"label label-success\">Query</span></h5><br>\n" +
            "      <p>"+ comment.getContent() + "</p>\n" +
            "      <form method = \"POST\" action = \"\\InterviewPrep\\discuss" +"\\post\\" + comment.getId()  + "\"><button type=\"submit\" "
                    + "style=\"float: right;\" class=\"btn btn-success btn-large\">Reply</button></form><br><hr>";
            return html;

    }
    
    
}