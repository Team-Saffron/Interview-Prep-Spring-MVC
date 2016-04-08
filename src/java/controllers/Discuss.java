/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import MyPackages.Comment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author archit08jain
 */

@Controller
@RequestMapping("/discuss.htm")
public class Discuss {
 
    @RequestMapping(method = RequestMethod.GET)
    public String getDiscussionPage(ModelMap modelMap) {
        return "discuss";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String postComment(ModelMap modelMap) {
        
        return "discuss";
    }
    
    
}