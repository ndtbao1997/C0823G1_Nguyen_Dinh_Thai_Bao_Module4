package com.example.blogappilication.controller;

import com.example.blogappilication.model.Blog;
import com.example.blogappilication.model.Category;
import com.example.blogappilication.service.IBlogService;
import com.example.blogappilication.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> showHome(@PageableDefault(value = 3) Pageable pageable){
        Page<Blog> blogs = iBlogService.findAll(pageable);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Iterable<Blog>> findBlogByCategories(@PathVariable Integer id){
        Optional<Category> category = iCategoryService.findById(id);
        if (!category.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<Blog> blogs = (List<Blog>) iBlogService.findAllByCategory(category.get());
            if (blogs.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Blog> save(@RequestBody Blog blog){
         return new ResponseEntity<>(iBlogService.save(blog),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@PathVariable Integer id,@RequestBody Blog blog){
        Optional<Blog> blog1 = iBlogService.findById(id);
        if (!blog1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(id);
        return new ResponseEntity<>(iBlogService.save(blog),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> remove(@PathVariable Integer id){
       Optional<Blog> blog = iBlogService.findById(id);
       if (!blog.isPresent()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       iBlogService.remove(id);
       return new ResponseEntity<>(blog.get(),HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Blog> viewForm(@PathVariable Integer id){
        Optional<Blog> blog = iBlogService.findById(id);
        if (blog.isPresent()){
            return new ResponseEntity<>(blog.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}