package org.total.web;

import mybatis.entity.User;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/total")
public class UserController {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
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
    @RequestMapping(value = "/array1",method = RequestMethod.GET)
    @ResponseBody
    public void Entity1(@RequestParam("arr[]")int []arr)
    {
        for(int s:arr)
            System.out.println(s);

    }
}
