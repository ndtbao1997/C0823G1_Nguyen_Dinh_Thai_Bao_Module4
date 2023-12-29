package com.example.book_borrowing_application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
   private static int count =0;

    @After("execution(public * com.example.book_borrowing_application.controller.*.*(..))")
    public void countVisit(JoinPoint joinPoint){
//      Object[] objects= joinPoint.getArgs();
//      String s = (String) objects[0];
      count++;
      System.out.println("----------------------------------------------------------------------");
      System.out.println("Số lần ghé thăm thư viện là :" + count);
    }
}
