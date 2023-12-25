package com.example.blogappilication.controller;

import com.example.blogappilication.model.Blog;
import com.example.blogappilication.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @ModelAttribute("blog")
    public Blog blog(){
        return new Blog();
    }
    @GetMapping("")
    public ModelAndView showHome(){
        return new ModelAndView("index","blogs",iBlogService.findAll());
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
    public ModelAndView editForm(@PathVariable Integer id){
        return new ModelAndView("update","blog",iBlogService.findById(id));
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
    @GetMapping("/view/{id}")
    public ModelAndView viewForm(@PathVariable Integer id){
        return new ModelAndView("view","blog",iBlogService.findById(id));
    }
}
