package controller;

import entities.*;
import java.util.*;
import model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/table")
public class TableController {

    private TableT tableObj = new TableT();
    List<TableT> lt; 
    private String result = "";
    private void load(ModelMap mm) {
        mm.addAttribute("tableObj", tableObj);
        lt = TableModel.getTableModel().listTable();
        mm.put("listTable", lt);

        // mm.addAttribute("submit", "submit");
        CategorizeTableModel ctm = new CategorizeTableModel();
        List<Categorizetable> lct = ctm.listCategorizeTable();
        mm.put("listCategorizeTable", lct);
        mm.put("result", result);
    }

    @RequestMapping(value = "/showtable", method = RequestMethod.GET)
    public String showTable(ModelMap mm) {
        load(mm);
        return "ListTable";
    }

    @RequestMapping(value = "/addTable", method = RequestMethod.POST)
    public String addTable(@ModelAttribute(value = "tableObj") TableT tableObj, ModelMap mm) {

        tableObj.setCategorizetable(CategorizeTableModel.getCategorizeTable(tableObj.getCategorizetable().getCategorizeTableId()));

        if (TableModel.getTableModel().insert(tableObj)) {
            result = "added table " + tableObj.getTableId() + " !";
        }
        this.tableObj = tableObj;
        load(mm);
        return "ListTable";
    }

    @RequestMapping(value = "/edittable", method = RequestMethod.POST)
    public String editTable(@ModelAttribute(value = "tableObj") TableT tableObj, @RequestParam(value = "submit") String submit, ModelMap mm) {
        if (submit.equals("update")) {
            if(TableModel.getTableModel().update(tableObj)){
                result = "table "+ tableObj.getTableId() + " updated successfully!";
            }
        }
        if (submit.equals("delete")) {
            if (TableModel.getTableModel().delete(tableObj)) {
                result = "table "+ tableObj.getTableId() + " deleted successfully!";
            }
        }
       
        load(mm);
        return "ListTable";
    }

}
