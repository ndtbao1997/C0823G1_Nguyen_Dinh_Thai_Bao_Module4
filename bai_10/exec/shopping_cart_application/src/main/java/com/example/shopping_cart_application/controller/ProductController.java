package com.example.shopping_cart_application.controller;

import com.example.shopping_cart_application.model.Cart;
import com.example.shopping_cart_application.model.Product;
import com.example.shopping_cart_application.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }

    @GetMapping("")
    public ModelAndView showHome() {
        return new ModelAndView("home", "products", iProductService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView productDetails(@PathVariable Integer id) {
        Optional<Product> product = iProductService.findById(id);
        if (product.isPresent()) {
            System.out.println(product.get().getName());
            return new ModelAndView("product-detail", "product", product.get());

        } else {
            return new ModelAndView("error");
        }
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id,
                            @ModelAttribute("cart") Cart cart) {
        Optional<Product> product = iProductService.findById(id);
        if (!product.isPresent()) {
            return "error";
        }
        cart.addProduct(product.get(), 1);
        System.out.println(cart.getProducts().size());
        return "redirect:/";
    }

    @GetMapping("/add1/{id}")
    public String addToCart1(@PathVariable Integer id,
                            @ModelAttribute("cart") Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> product = iProductService.findById(id);
        if (!product.isPresent()) {
            return "error";
        }
        Integer quantity = Integer.parseInt(action);
            cart.addProduct(product.get(), quantity);
            return "redirect:/cart";
    }
}
