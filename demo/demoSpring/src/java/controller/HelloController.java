package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import model.*;
import java.util.*;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {
    
    @RequestMapping(value = "helloworld", method = RequestMethod.GET)
    public String helloWorld(ModelMap mm){
        mm.put("a","Nguyen Van A");
        mm.put("b", 1122);
        mm.put ("aa",new product("001", "product 1", 300));
        List<product> lp = new ArrayList<product>();
        lp.add(new product("002", "product 2", 200));
        lp.add(new product("003", "product 3", 200));
        lp.add(new product("004", "product 4", 2030));
        mm.put ("lp",lp);
        return "helloWorld";
    }
}
