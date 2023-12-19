package com.example.simpledictionaryapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class SimpleController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome(){
        return "home";
    }
    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    public String simpleDictionary(@RequestParam("dictionary") String dictionary, Model model){
        Map<String,String> stringMap = new LinkedHashMap<>();
        stringMap.put("hello","xin chào");
        stringMap.put("teacher","giáo viên");
        stringMap.put("student","học sinh");
        String vietNamese = stringMap.get(dictionary);
        model.addAttribute("vietNamese",vietNamese);
        return "result";
    }
}
