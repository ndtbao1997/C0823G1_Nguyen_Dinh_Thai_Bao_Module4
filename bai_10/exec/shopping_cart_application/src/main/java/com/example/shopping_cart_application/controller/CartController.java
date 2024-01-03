package com.example.shopping_cart_application.controller;

import com.example.shopping_cart_application.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CartController {
    @GetMapping("/cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        return new ModelAndView("show-cart","cart",cart);
    }
}
