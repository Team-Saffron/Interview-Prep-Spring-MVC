package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/ranks")
public class Ranking {
       
    @RequestMapping(method = RequestMethod.GET)
    public String getRanks(ModelMap modelMap) {
        
        return "ranking";
    }
    
    
}