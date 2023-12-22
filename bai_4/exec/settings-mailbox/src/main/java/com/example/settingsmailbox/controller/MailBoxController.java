package com.example.settingsmailbox.controller;

import com.example.settingsmailbox.model.MailBox;
import com.example.settingsmailbox.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mailbox")
public class MailBoxController {
    @Autowired
    private IMailBoxService iMailBoxService;
    @RequestMapping("")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("/form-settings");
        modelAndView.addObject("mailbox", iMailBoxService.getMailBox());
        modelAndView.addObject("languages", iMailBoxService.getListLanguages());
        modelAndView.addObject("pageSizes", iMailBoxService.getListPageSizes());
        return modelAndView;
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("mailbox") MailBox mailBox){
        iMailBoxService.update(mailBox);
        System.out.println(mailBox.getSpamsFilter());
        System.out.println(mailBox.getPageSize());
        System.out.println(mailBox.getSignature());
        System.out.println(mailBox.getLanguages());
        return "redirect:/mailbox";
    }
}
