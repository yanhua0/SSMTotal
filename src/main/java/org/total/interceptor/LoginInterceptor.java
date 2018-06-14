package org.total.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

   //首先进入的方法
        System.out.println("preHandle");
        System.out.println(request.getServletPath());
        HttpSession session = request.getSession();
        String username= (String) session.getAttribute("username");
        String url=request.getRequestURI();
        if(url.indexOf("/total/check")>=0)
        {
            return true;
        }
        if(username!=null){
            return true;
        }else{
            request.getRequestDispatcher("/WEB-INF/views/html/login.jsp").forward(request,response);
//            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login/index");  //未登录自动跳转界面
            return false;
        }

    }
    //返回modelAndView之前执行

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle");
    }
    //执行Handler完成执行此方法

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterCompletion");
    }
}