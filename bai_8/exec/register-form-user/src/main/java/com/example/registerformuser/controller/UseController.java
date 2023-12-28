package com.example.registerformuser.controller;

import com.example.registerformuser.model.Use;
import com.example.registerformuser.service.IUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;

@Controller
@RequestMapping("")
public class UseController {
    @Autowired
    private IUseService iUseService;

    @GetMapping("")
    public ModelAndView showForm() {
        return new ModelAndView("form", "use", new Use());
    }

    @PostMapping("/register")
    public ModelAndView createUse(@Valid @ModelAttribute("use") Use use, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("form");
        } else {
            iUseService.save(use);
            return new ModelAndView("form","success","Register OK!!!");
        }
    }
}
