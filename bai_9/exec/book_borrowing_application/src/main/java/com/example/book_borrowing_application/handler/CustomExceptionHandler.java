package com.example.book_borrowing_application.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ModelAndView exception(){
        return new ModelAndView("error");
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView exception1(){
        return new ModelAndView("error1");
    }
}
