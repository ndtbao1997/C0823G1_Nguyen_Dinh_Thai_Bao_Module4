package com.example.productmanagementapplication.controller;

import com.example.productmanagementapplication.model.Product;
import com.example.productmanagementapplication.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @GetMapping("")
    public String index(Model model){
        List<Product> products = iProductService.findAll();
        model.addAttribute("products",products);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Product product){
        iProductService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String update(Product product){
        iProductService.update(product.getId(),product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/remove")
    public String remove(@PathVariable int id,Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "/remove";
    }
    @PostMapping("/remove")
    public String remove(Product product, RedirectAttributes redirect){
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
        List<Product> products = iProductService.findByName(name);
        if (products.isEmpty()){
            model.addAttribute("products",iProductService.findAll());
            model.addAttribute("success","Không có sản phẩm nào trùng tên cả!");
            return "/index";
        } else {
            model.addAttribute("products",products);
            return "/list-product-by-name";
        }
    }
}
