package com.example.currencyconversionapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage() {
        return "home";
    }

    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public String convertCurrency(@RequestParam("exchangeRate") double exchangeRate,
                                  @RequestParam("amount") double amount,
                                  Model model) {
        double vndAmount = exchangeRate * amount;
        model.addAttribute("vndAmount", vndAmount);
        return "result";
    }
}