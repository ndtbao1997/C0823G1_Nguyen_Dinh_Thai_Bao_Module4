package com.example.blogappilication.controller;

import com.example.blogappilication.model.Blog;
import com.example.blogappilication.model.Category;
import com.example.blogappilication.service.IBlogService;
import com.example.blogappilication.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBlogService iBlogService;

    @ModelAttribute("categorys")
    public Iterable<Category> listCategorys() {
        return iCategoryService.findAll();
    }

    @GetMapping("")
    public ModelAndView showHome() {
        return new ModelAndView("index-category");
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        return new ModelAndView("create-category", "category", new Category());
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("success", "Save OK!!!");
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id){
        Optional<Category> category = iCategoryService.findById(id);
        if (category.isPresent()){
            return new ModelAndView("update-category","category",category.get());
        } else {
            return new ModelAndView("index-category","success","Error");
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes){
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("success","Update Ok!!!");
        return "redirect:/category";
    }


    @PostMapping("/remove")
    public String remove(@RequestParam("idDelete") Integer id,RedirectAttributes redirectAttributes){
        iCategoryService.remove(id);
        redirectAttributes.addFlashAttribute("success","Delete OK!!!");
        return "redirect:/category";
    }

    @GetMapping("/view-category/{id}")
    public ModelAndView listByID(@PathVariable Integer id, @PageableDefault(value = 3) Pageable pageable, Model model){
        Optional<Category> category = iCategoryService.findById(id);
        if (category.isPresent()){
            Page<Blog> blogs = iBlogService.findAllByCategory(category.get(),pageable);
            return new ModelAndView("view-category","blogs",blogs);
        } else {
            ModelAndView modelAndView = new ModelAndView("index");
            Page<Blog> blogs1 = iBlogService.findAll(pageable);
            model.addAttribute("blogs",blogs1);
            model.addAttribute("success","Search Error!!!");
            return modelAndView;
        }
    }
}
