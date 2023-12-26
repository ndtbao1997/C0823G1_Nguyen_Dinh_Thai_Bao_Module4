package com.example.blogappilication.repository;

import com.example.blogappilication.model.Blog;
import com.example.blogappilication.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogRepository extends PagingAndSortingRepository<Blog,Integer> {

    Page<Blog> findAllByOrderByPublishDateDesc(Pageable pageable);

    Page<Blog> findAllByTitleContaining(String search, Pageable pageable);

    Page<Blog> findAllByCategory(Category category, Pageable pageable);
}
