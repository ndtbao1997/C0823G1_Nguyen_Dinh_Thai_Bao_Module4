package com.example.book_borrowing_application.controller;

import com.example.book_borrowing_application.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @GetMapping("")
    public ModelAndView showBookHome(){
        return new ModelAndView("book-home","books",iBookService.findAll());
    }
}
