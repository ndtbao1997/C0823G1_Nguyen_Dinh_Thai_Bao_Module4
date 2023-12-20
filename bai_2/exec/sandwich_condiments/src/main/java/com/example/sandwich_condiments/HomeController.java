package com.example.sandwich_condiments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "display";
    }
}
