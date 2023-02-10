package com.example.blogsystem.service;

import com.example.blogsystem.dto.BlogDTO;
import com.example.blogsystem.entity.Blog;
import com.example.blogsystem.exception.CustomException;

import java.util.List;

public interface BlogService {
    BlogDTO saveBlog(Blog blog);
    List<BlogDTO> fetchAllBlogs();

    void deleteBlog(Long id)throws CustomException;

    BlogDTO updateBlog(Blog blog, Long id) throws CustomException;
}
