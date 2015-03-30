package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board")
public class boardController {
    
    
    @RequestMapping(value = "/boardTable", method = RequestMethod.GET)
    public String showTable(ModelMap mm) {
        return "boardTable";
    }
}
