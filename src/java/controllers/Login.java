/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import MyPackages.ConnectDatabase;
import MyPackages.Database;
import MyPackages.User;
import java.sql.SQLException;
import java.text.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String signin(@ModelAttribute User newUser,ModelMap modelMap) throws SQLException, ClassNotFoundException {
        
        if(ConnectDatabase.authenticateUser(newUser))
        {
            modelMap.put("session",newUser);
            return "dashboard";
        }
        modelMap.put("ERROR","Authentication Failed");
        return "index"; 
    }
    
    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String register(ModelMap modelMap) {
        return "registration";
    }
    
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String newEntry(@ModelAttribute User newUser,ModelMap modelMap) throws SQLException, ClassNotFoundException {
       
        if(!ConnectDatabase.contains(newUser))
             ConnectDatabase.addUser(newUser);
        else
        {
            modelMap.put("ERROR","User already exists");
        }
        modelMap.put("session", newUser);
        return "dashboard";
    }  
      
    @RequestMapping(value = "/fb",method = RequestMethod.POST)
    public String fblgin(@ModelAttribute User newUser,ModelMap modelMap) throws SQLException, ClassNotFoundException {
       
        if(!ConnectDatabase.contains(newUser))
            ConnectDatabase.addUser(newUser);
        
        modelMap.put("session", newUser);
        return "dashboard";
    }  
}