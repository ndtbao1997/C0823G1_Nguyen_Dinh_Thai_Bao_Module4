package com.example.product_management.controller;

import com.example.product_management.dto.CartSession;
import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
    @Autowired
    private IProductService productService;
    @GetMapping("/cart")
    public ModelAndView showCart(@SessionAttribute("cart") CartSession cart) {
        return new ModelAndView("cart-home","cart",cart);
    }

    @GetMapping("/shopping-cart/product/{id}")
    public String changeProductQuantity(@RequestParam @Nullable String action,
                                        @RequestParam @Nullable Integer amount,
                                        @PathVariable Long id,
                                        @SessionAttribute("cart") CartSession cart) {
        Product product = productService.findById(id).orElse(null);
        System.out.println(action);
        if (product == null) {
            return "/error_404";
        }
        if (action != null) {
            if (action.equals("add")) {
                cart.addProduct(product);
            } else {
                cart.removeProduct(product);
            }
        }
        if (amount!=null){
            cart.changeAmount(product,amount);
        }
        return "redirect:/cart";
    }
}