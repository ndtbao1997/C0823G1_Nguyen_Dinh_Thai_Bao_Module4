package com.example.product_management.controller;

import com.example.product_management.dto.CartSession;
import com.example.product_management.dto.IProductDTO;
import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public CartSession getCartSession(){
        return new CartSession();
    }
    @GetMapping("")
    public ModelAndView productHome(@PageableDefault(value = 4) Pageable pageable){
        Page<IProductDTO> iProductDTOPageable = iProductService.findAllDTO(pageable);
        return new ModelAndView("product-home","products",iProductDTOPageable);
    }

    @GetMapping("/add/{id}")
    public ModelAndView addToCart(@PathVariable Long id,
                            @ModelAttribute("cart") CartSession cart,
                            @PageableDefault(value = 4) Pageable pageable) {
        Optional<Product> product = iProductService.findById(id);
        if (!product.isPresent()) {
            return new ModelAndView("error");
        }
        cart.addProduct(product.get());
        Page<IProductDTO> iProductDTOPageable = iProductService.findAllDTO(pageable);
        return new ModelAndView("product-home","products",iProductDTOPageable);
    }
}
