package org.total.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.total.dto.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle12(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {

       logger.error("【系统异常】{}", e);

//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        //         response.getWriter().println("【系统异常】{}"+e.getMessage());
        if (e instanceof RuntimeException) {
            Result r = new Result();
            r.setState(-1);
            r.setStateinfo(e.getMessage());
            return r;
        } else {
            Result r = new Result();
            r.setState(1);
            r.setStateinfo("未知错误");
            return r;
        }
    }

    }

//    public ModelAndView handle(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        logger.error("系统发生错误-------------------");
//        ExceptionResult r = null;
//        if (e instanceof RuntimeException) {
//            r = new ExceptionResult(-1, e.getMessage());
//        } else {
//            r = new ExceptionResult(0, "未知错误---请联系管理员!");
//        }
//        ModelAndView mv = new ModelAndView();
//        logger.error("错误信息：" + r.getStateInfo());
//        mv.addObject("message", r);//想当于model.attribute()
//        mv.setViewName("error");//设置映射的页面名称
//        return mv;
//
//    }