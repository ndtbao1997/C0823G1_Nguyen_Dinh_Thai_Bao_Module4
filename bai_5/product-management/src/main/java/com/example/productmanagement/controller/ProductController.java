package com.example.productmanagement.controller;


import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("product")
    public Product product() {
        return new Product();
    }

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = iProductService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("/create");
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product){
        System.out.println(product.getId());
        iProductService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        Product product = iProductService.findById(id);
        model.addAttribute("product",product);
        return "/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product){
        System.out.println(product.getId());
        iProductService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/remove")
    public String remove(@PathVariable int id,Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "/remove";
    }
    @PostMapping("/remove")
    public String remove(@ModelAttribute("product") Product product, RedirectAttributes redirect){
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("success", "Bạn đã xóa sản phẩm thành công!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id,Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "/detail";
    }
    @GetMapping("/find-by-name")
    public String findByName(@RequestParam("name1") String name,Model model){
        model.addAttribute("success","Không có sản phẩm nào trùng tên cả!");
        List<Product> products = iProductService.findByName(name);
        if (products.isEmpty()){
            model.addAttribute("products",iProductService.findAll());
            return "/index";
        } else {
            model.addAttribute("products",products);
            return "/list-product-by-name";
        }
    }
}
