package com.example.blogappilication.service;

import com.example.blogappilication.model.Blog;
import com.example.blogappilication.model.Category;
import com.example.blogappilication.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
       return iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByOrderByPublishDateDesc(Pageable pageable) {
        return iBlogRepository.findAllByOrderByPublishDateDesc(pageable);
    }

    @Override
    public Page<Blog> findAllByTitleContaining(String search, Pageable pageable) {
        return iBlogRepository.findAllByTitleContaining(search,pageable);
    }

    @Override
    public Iterable<Blog> findAllByCategory(Category category) {
        return iBlogRepository.findAllByCategory(category);
    }
}
