package com.example.blogsystem.mapper;

import com.example.blogsystem.dto.BlogDTO;
import com.example.blogsystem.entity.Blog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring", uses = {UserMapper.class,CommentMapper.class})
public interface BlogMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(source = "commentList", target = "comments")
    BlogDTO blogDto(Blog blog);

    @Mapping(target = "user", ignore = true)
    @Mapping(source = "comments", target = "commentList")
    Blog DTOBlog(BlogDTO blogDTO);

    List<BlogDTO> BLOG_DTO_LIST(List<Blog> blogList);
}
