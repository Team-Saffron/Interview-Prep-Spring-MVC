package controllers;

import MyPackages.ConnectDatabase;
import MyPackages.Problem;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.put("problem", newProblem);
        return "dashboard";
    }
    
    @RequestMapping(value = "problems/view",method = RequestMethod.GET)
    public String getProblemsPage(ModelMap model) throws SQLException, ClassNotFoundException
    {
        model.put("table", getProblemHTML(1,20));
        return "problemBoard";
    }
    @RequestMapping(value = "problems/view/{pageNumber}",method = RequestMethod.GET)
    public String getProblemsPageNumber(@PathVariable("pageNumber") int number,ModelMap model) throws SQLException, ClassNotFoundException
    {
        model.put("table", getProblemHTML(number,number+20));
        return "problemBoard";
    }
    
    @RequestMapping(value = "problems/view/problemId/{id}",method = RequestMethod.GET)
    public String displayProblem(@PathVariable("id") int number,ModelMap model) throws SQLException, ClassNotFoundException
    {
        model.put("problem",ConnectDatabase.getProblems(number, number).get(0));
        return "problemPage";
    }
    
    private String getProblemHTML(int start,int end) throws SQLException, ClassNotFoundException
    {
        ArrayList<Problem> pool = ConnectDatabase.getProblems(start, end);
        String HTML = "";
        
        for(int i = 0;i<pool.size();i++)
            HTML = HTML + "<tr><td><b> Problem " + pool.get(i).getId() + "</b></td><td><b>"
            
                    + pool.get(i).getName()+"</b></tr>";
        
        return HTML;
    }
}
