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

import java.util.Optional;

@Controller
@RequestMapping("")
public class BlogController {
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

    @GetMapping("")
    public ModelAndView showHome(@PageableDefault(value = 3) Pageable pageable, Model model){
        ModelAndView modelAndView = new ModelAndView("index");
        Page<Blog> blogs = iBlogService.findAll(pageable);
        model.addAttribute("blogs",blogs);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewForm(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        Optional<Blog> blog = iBlogService.findById(id);
        if (blog.isPresent()){
            return new ModelAndView("view","blog",blog.get());
        }
        redirectAttributes.addFlashAttribute("success","Error");
        return new ModelAndView("index","blogs",iBlogService.findAll());
    }

    @GetMapping("/sort")
    public ModelAndView sortView(@PageableDefault(value = 3) Pageable pageable){
        Page<Blog> blogs = iBlogService.findAllByOrderByPublishDateDesc(pageable);
        return new ModelAndView("index-sort","blogs",blogs);
    }

    @GetMapping("/search")
    public ModelAndView searchByTitle(@RequestParam("search") String search,@PageableDefault(value = 3) Pageable pageable,Model model){
        Page<Blog>  blogs = iBlogService.findAllByTitleContaining(search,pageable);
        if (blogs.isEmpty()){
            ModelAndView modelAndView = new ModelAndView("index");
            Page<Blog> blogs1 = iBlogService.findAll(pageable);
            model.addAttribute("blogs",blogs1);
            model.addAttribute("success","Search Error!!!");
            return modelAndView;
        } else {
            return new ModelAndView("index-search","blogs",blogs);
        }
    }
}
