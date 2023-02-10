package com.example.blogsystem.controller;

import com.example.blogsystem.entity.Blog;
import com.example.blogsystem.exception.CustomException;
import com.example.blogsystem.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/saveBlog")
    public ResponseEntity<?>saveBlog(@RequestBody Blog blog){
        return new ResponseEntity<>(blogService.saveBlog(blog), HttpStatus.CREATED);
    }
    @GetMapping("/getBlogs")
    public ResponseEntity<?>fetchAllBlogs(){
        return new ResponseEntity<>(blogService.fetchAllBlogs(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable("id")Long id) throws CustomException {
        blogService.deleteBlog(id);
        return "Successfully deleted Blog with Id:"+id;
    }
    @PatchMapping("/updateBlog/{id}")
    public ResponseEntity<?>updateBlog(@RequestBody Blog blog,@PathVariable("id")Long id)throws CustomException{
        return new ResponseEntity<>(blogService.updateBlog(blog,id),HttpStatus.OK);
    }
}
