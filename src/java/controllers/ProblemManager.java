package controllers;

import MyPackages.ConnectDatabase;
import MyPackages.Problem;
import com.mchange.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    
    @RequestMapping(value = "problems/view/problemId/{id}/download",method = RequestMethod.GET)
    public String getInput(@PathVariable("id") int number,ModelMap model) throws SQLException, ClassNotFoundException
    {
        model.put("problem",ConnectDatabase.getProblems(number, number).get(0).getInput());
        return "testing";
    }
    
    @RequestMapping(value = "problems/view/problemId/{id}/output",method = RequestMethod.POST)
    public String submitOutputFile(@RequestParam("output") String content,@PathVariable("id") int number,ModelMap model) throws SQLException, ClassNotFoundException, IOException
    {
        String output = ConnectDatabase.getProblems(number, number).get(0).getOutput();
        
       content =  content.replace("\n", "<br />\n");
        if(content.equals(output))
            model.put("status","Accepted");
        else
            model.put("status","Rejected");
       
        model.put("problem",ConnectDatabase.getProblems(number, number).get(0));
       
        return "problemPage";
    }
    
    private String getProblemHTML(int start,int end) throws SQLException, ClassNotFoundException
    {
        ArrayList<Problem> pool = ConnectDatabase.getProblems(start, end);
        String HTML = "";
        
        for(int i = 0;i<pool.size();i++)
            HTML = HTML + "<tr><td><b> Problem " + pool.get(i).getId() + "</b></td><td><b>"
                    + "<a href= \"/InterviewPrep/problems/view/problemId/" + pool.get(i).getId() + "\">"
                    + pool.get(i).getName()+"</a></b></tr>";
        
        return HTML;
    }
    
    
}
