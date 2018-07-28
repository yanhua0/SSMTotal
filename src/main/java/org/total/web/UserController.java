package org.total.web;

import mybatis.entity.User;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.total.entity.HotSale;


import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/total")
public class UserController {
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ResponseBody
    public void Entity(User user)
    {

        System.out.println("user{}"+user);

    }

    @RequestMapping(value = "/map",method = RequestMethod.GET)
    @ResponseBody
    public void Entity2(@RequestParam Map<String,String> map)
    {     if(map.containsKey("username"))
         {
        int username=Integer.parseInt(map.get("username"));
        }
        if(map.containsKey("password"))
        {
            String username=map.get("password");
        }
       for(String key:map.keySet())
       {
           System.out.println("key="+key+"value="+map.get(key));
       }
    }
    /*
    映射.html文件
     */
    @RequestMapping(value = "/html",method = RequestMethod.GET)
    public String html()
    {
        return "hello";
    }
/*
两种方式获取ajax发送的数组。
 */
    @RequestMapping(value = "/array",method = RequestMethod.GET)
    @ResponseBody
    public void Entity2(@RequestParam Map<String,String> map,HttpServletRequest request)
    {
        String arr[]=request.getParameterValues("arr[]");
        for(String s:arr)
        {
            System.out.println(s);
        }
        /*
        只能获取到数组的第一个值
         */
        System.out.println("所有name的map集合"+map);
        System.out.println("map="+map.get("arr[]"));
    }
    /*
    这种方式要注意数组要写[]
     */
    @RequestMapping(value = "/array1",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String Entity1(@RequestParam("arr[]")int []arr)
    {    for(int s:arr)
    {
        System.out.println(s);
    }
        return "中文";

    }
    /*
    接受json数组对象(后台接受对象数组)
     */
    @RequestMapping(value = "/testjson",method = RequestMethod.POST)
    @ResponseBody
    public int saveUser(@RequestBody User[] user) {
       System.out.println("-------------------");
        for (User s:user
             ) {
            System.out.println(s);
        }
        /*
       返回类型为String，前端报错
         */
        return 0;
    }

    @RequestMapping(value = "/testjson1",method = RequestMethod.POST)
    @ResponseBody
    public Object saveUser() {
        User u=new User("2去","312");
        HotSale h=new HotSale("12","中文");
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("u",u);
        map.put("h",h);
        return map;
    }

}
