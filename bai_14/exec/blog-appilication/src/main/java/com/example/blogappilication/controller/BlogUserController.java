package com.example.blogappilication.controller;

import com.example.blogappilication.model.Blog;
import com.example.blogappilication.model.Category;
import com.example.blogappilication.service.IBlogService;
import com.example.blogappilication.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class BlogUserController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> listCategorys(){
        return iCategoryService.findAll();
    }

    @ModelAttribute("blog")
    public Blog blog(){
        return new Blog();
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        return new ModelAndView("create");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect){
        iBlogService.save(blog);
        redirect.addFlashAttribute("success","Save OK!!!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        Optional<Blog> blog = iBlogService.findById(id);
        if (blog.isPresent()){
            return new ModelAndView("update","blog",blog.get());
        }
        redirectAttributes.addFlashAttribute("success","Error");
        return new ModelAndView("index","blogs",iBlogService.findAll());
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog,RedirectAttributes re){
        iBlogService.save(blog);
        re.addFlashAttribute("success","Update OK!!!");
        return "redirect:/";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("idDelete") Integer idDelete,RedirectAttributes re){
        iBlogService.remove(idDelete);
        re.addFlashAttribute("success","Remove OK!!!");
        return "redirect:/";
    }
}
