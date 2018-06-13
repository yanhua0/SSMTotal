package org.total.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//切面声明
@Aspect
//装配到spring容器中
@Component
public class LoggingAspect {
    //    声明切入点  声明切入点表达式
    @Pointcut("execution(public * org.total.web.UserController.*(..))")
    public void JoinPointExpecssion(){};
    //前置通知
    @Before("JoinPointExpecssion()")
    public void beforMethod(JoinPoint joinPoint){
//        获得方法名
        String name = joinPoint.getSignature().getName();
//        获得参数列表，再将参数数组转换成List集合
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("前置通知");
        System.out.println("参数:"+args);

    }
    //后置通知
    @After("JoinPointExpecssion()")
    public void afterMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("后置通知");
        System.out.println("参数:"+args);
    }
    //    返回通知，在方法正常结束的时候返回，且 必须要有一个返回值
    @AfterReturning(value = "JoinPointExpecssion()",returning = "result")
    public void afterMethodRetuning(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("返回通知"+ result);
    }

}