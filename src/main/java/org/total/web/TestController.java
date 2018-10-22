package org.total.web;

import mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.total.entity.HotSale;
import org.total.service.TotalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class TestController {
    @Autowired
    private TotalService totalService;

    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String reg22(){
    	return "test";
    }
    /*
    单独字符串要加
     */
    @RequestMapping(value="/test1",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String reg1(@RequestParam("username")String username){
    	System.out.println(username);
    	return  username;
    }
    @RequestMapping(value="/test2",method=RequestMethod.POST)
    @ResponseBody
    public HotSale reg111121(){
      HotSale h=totalService.queryById(1);

        return h;

    }
    @RequestMapping(value="/test2",method=RequestMethod.GET)
    @ResponseBody
    public HotSale reg231(){
        HotSale h=totalService.queryById(1);
        return h;
    }
    @RequestMapping(value="/datas",method=RequestMethod.POST)
    public void reg2231(@RequestParam("da")String da) throws ParseException {

        SimpleDateFormat sip=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date birthday=sip.parse(da);
        System.out.println(birthday);

    }
    @RequestMapping(value="/testfile",method=RequestMethod.GET)
    public String tests(){
        return "test/test";
    }
    @RequestMapping(value="/form",method=RequestMethod.GET)
    @ResponseBody
    public User tests1(User user){
       return  user;
    }
}
