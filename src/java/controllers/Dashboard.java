
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/dashboard")
public class Dashboard {
       
    @RequestMapping(method = RequestMethod.GET)
    public String getDashboard(ModelMap modelMap) {
        
        return "dashboard";
    }
    
    @RequestMapping(value = "editProfile",method = RequestMethod.GET)
    public String editProfile(ModelMap modelMap) {
        return "userInfo";
    }
}