package org.total.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TableController {
    @RequestMapping("/table")
    public String table(){
        return "table";
    }
    @RequestMapping("/createExcel")
    public void createExcel(){

    }
}
