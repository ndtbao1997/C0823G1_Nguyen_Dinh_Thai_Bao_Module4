package com.example.personal_computer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping(value = "/")
    public String calculatorHome(){
        return "calculator";
    }
    @GetMapping(value = "/calculator")
    public String calculator(@RequestParam double num1, @RequestParam double num2, @RequestParam String calculator, Model model){
        double result;
        switch (calculator){
            case "Addition":
                result = num1 + num2;
                model.addAttribute("result",result);
                return "calculator";
            case "Subtraction":
                result = num1 - num2;
                model.addAttribute("result",result);
                return "calculator";
            case "Multiplication":
                result = num1 * num2;
                model.addAttribute("result",result);
                return "calculator";
            default:
                if (num2 == 0){
                    model.addAttribute("result","Can't by zero");
                    return "calculator";
                } else {
                    result = num1/num2;
                    model.addAttribute("result",result);
                    return "calculator";
                }
        }
    }
}
