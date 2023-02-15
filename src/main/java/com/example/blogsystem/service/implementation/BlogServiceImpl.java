package com.example.blogsystem.service.implementation;

import com.example.blogsystem.dto.BlogDTO;
import com.example.blogsystem.entity.Blog;
import com.example.blogsystem.exception.CustomException;
import com.example.blogsystem.mapper.BlogMapper;
import com.example.blogsystem.repository.BlogRepository;
import com.example.blogsystem.service.BlogService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    public BlogServiceImpl(BlogRepository blogRepository, BlogMapper blogMapper) {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
    }

    @Override
    public BlogDTO saveBlog(Blog blog) {
        Blog save=blogRepository.save(blog);
        BlogDTO blogDTO = blogMapper.blogDto(save);
        return blogDTO;
    }

    @Override
    public List<BlogDTO> fetchAllBlogs() {
        List<Blog> blog = blogRepository.findAll();
        List<BlogDTO>blogDTOList=blogMapper.BLOG_DTO_LIST(blog);
        return blogDTOList;
    }

    @Override
    public void deleteBlog(Long id) throws CustomException {
        blogRepository.deleteById(id);
    }

    @Override
    public BlogDTO updateBlog(Blog blog, Long id) throws CustomException {
        Blog updateBlog = blogRepository.findById(id).get();
        updateBlog.setTitle(blog.getTitle());
        updateBlog.setDescription(updateBlog.getDescription());
        BlogDTO updateBlogDTO = blogMapper.blogDto(blogRepository.save(updateBlog));
        return updateBlogDTO;
    }
}
