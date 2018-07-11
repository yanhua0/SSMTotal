package org.total.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.total.entity.User;

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
}
