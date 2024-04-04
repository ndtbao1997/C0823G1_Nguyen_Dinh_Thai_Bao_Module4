package com.example.demopdf.controller;

import com.example.demopdf.test.PrintPDF;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class PDFController {
    @GetMapping("")
    public ModelAndView getHome(){
        return new ModelAndView("test");
    }

    @GetMapping("/test")
    public ModelAndView test(){
        PrintPDF.printPDF();
        return new ModelAndView("test");
    }
}
