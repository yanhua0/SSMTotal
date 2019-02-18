package org.total.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TableController {
    @RequestMapping("/table")
    public String table(HttpSession session){
      session.setAttribute("test","1234");
        return "table";
    }
    @RequestMapping("/createExcel")
    public void createExcel(){

    }
}
