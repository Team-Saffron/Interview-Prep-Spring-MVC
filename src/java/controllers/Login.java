/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import MyPackages.ConnectDatabase;
import MyPackages.User;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author archit08jain
 */
@Controller
@RequestMapping("/login")
@SessionAttributes("session")
public class Login {
 
    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(ModelMap modelMap) throws SQLException, ClassNotFoundException {
     //   return "index";
        
       // modelMap.put("problem",ConnectDatabase.getProblems(1,1).get(0));
        return "index";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String signin(@ModelAttribute User newUser,ModelMap modelMap) {
        
        modelMap.put("user", newUser);
        return "testing";
    }
    
    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String register(ModelMap modelMap) {
        return "registration";
    }
    
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String newEntry(@ModelAttribute User newUser,ModelMap modelMap) throws SQLException, ClassNotFoundException {
        ConnectDatabase.addUser(newUser);
        modelMap.put("session", newUser);
        return "dashboard";
    }
    
    
}