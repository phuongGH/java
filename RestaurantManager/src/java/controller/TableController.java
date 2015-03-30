package controller;

import entities.*;
import java.util.*;
import model.*;
import format.TableEdit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/table")
public class TableController {
    private TableEdit  tableObj = new TableEdit();
    
    private  void load(ModelMap mm){
        mm.addAttribute("tableObj", tableObj);
        List<TableT> lt = TableModel.getTableModel().listTable();
        mm.put("listTable", lt);
        
        CategorizeTableModel ctm = new CategorizeTableModel();
        List<Categorizetable> lct = ctm.listCategorizeTable();
        mm.put("listCategorizeTable", lct);
    }
    
    
    @RequestMapping(value = "/showtable", method = RequestMethod.GET)
    public String showTable(ModelMap mm){       
               
        load(mm);    
        return "ListTable";
    }

    @RequestMapping(value = "/addTable", method = RequestMethod.POST)
    public String addTable(@ModelAttribute(value = "tableObj") TableEdit tableObj ,ModelMap mm){
        
        //TableT tablet = new TableT(tableObj.getTableId(),CategorizeTableModel.getCategorizeTable(tableObj.getCategorizetable()), tableObj.getMaxPerson(), 0);
        
        System.out.println("getTableId "+tableObj.getTableId()+" getCategorizetable "+tableObj.getCategorizetable()+" getMaxPerson "+tableObj.getMaxPerson());
        this.tableObj = tableObj;
        load(mm);   
        return "ListTable";
    }
    
    @RequestMapping(value = "/deletetable", method = RequestMethod.GET)
    public String deleteTable(ModelMap mm){
        System.out.println("delete table !!!!!!!!!!!!!!!!!!!!!!!");
        load(mm); 
        return "ListTable";
    }
    
    
}
