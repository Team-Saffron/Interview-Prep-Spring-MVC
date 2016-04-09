/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import MyPackages.ConnectDatabase;
import MyPackages.Problem;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProblemManager {
    
    @RequestMapping(value = "problems/add",method = RequestMethod.GET)
    public String addProblemPage(ModelMap model)
    {
        return "addProblem";
    }
    
    @RequestMapping(value = "problems/add",method = RequestMethod.POST)
    public String addProblemRequest(@ModelAttribute Problem newProblem,ModelMap model) throws SQLException, ClassNotFoundException
    {
        ConnectDatabase.addProblem(newProblem);
        model.put("status",ConnectDatabase.getProblems());
        model.put("problem", newProblem);
        return "testing";
    }
    
    
}
