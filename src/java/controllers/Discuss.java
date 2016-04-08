/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import MyPackages.Comment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;

/**
 *
 * @author archit08jain
 */

@Controller
@RequestMapping("/discuss.htm")
public class Discuss {
 
    static private long COMMENT_ID = 1;
    
    @RequestMapping(method = RequestMethod.GET)
    public String getDiscussionPage(ModelMap modelMap) {
        return "discuss";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String postComment(@ModelAttribute Comment newComment,ModelMap modelMap) {
        
        newComment.setId(String.valueOf(COMMENT_ID));
        COMMENT_ID++; //Comment ID is assigned to thsi comment a        
        newComment.setTimestamp(new Date());
        
        modelMap.put("newComment", newComment);
        return "testing";
    }
    
    
    
    
}