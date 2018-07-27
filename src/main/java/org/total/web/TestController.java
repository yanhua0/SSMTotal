package org.total.web;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {


    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String reg22(){
    	return "test";
    }
    @RequestMapping(value="/test1",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String reg1(@RequestParam("username")String username){
    	System.out.println(username);
    	return  username;
    }

}
