package org.total.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class MessageController {
    @RequestMapping("/login")
    public String login(HttpSession session) {
        return "test/login";
    }

    @RequestMapping(value = "/code",method = RequestMethod.GET)
    @ResponseBody
    public void code(@RequestParam("phone") String phone, HttpSession session) {
        System.out.println("jin");
        String flag = (String) session.getAttribute(phone);
        if (flag != null && flag.equals(phone)) {
            System.out.println(phone+"重复发送");
        } else {
            session.setAttribute(phone, phone);
            session.setAttribute("code", "123");
            session.setMaxInactiveInterval(60);
            System.out.println(phone + "没发送过！");
        }

    }
}
