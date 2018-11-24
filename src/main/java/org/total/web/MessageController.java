package org.total.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;

import static org.total.util.DbOperate.dbBackup;

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
    @RequestMapping("/baocun")
    public String dsa(){
        return "test/test";
    }
    @RequestMapping("/da")
    public void dsa2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        dbBackup("root", "123456", "localhost","3306", "ssh", "e:/test1.sql");
        String filename ="e:/test1.sql";
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(filename)));
        //假如以中文名下载的话
        String fileName = "test.sql";
        //转码，免得文件名中文乱码
        fileName = URLEncoder.encode(fileName, "UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());

        int len = 0;

        while ((len = bis.read()) != -1) {
            out.write(len);
            out.flush();
        }
        out.close();
    }
}
