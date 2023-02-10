package com.example.blogsystem.mapper;

import com.example.blogsystem.dto.CommentDTO;
import com.example.blogsystem.dto.UserDTO;
import com.example.blogsystem.entity.Comment;
import com.example.blogsystem.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring",uses = {BlogMapper.class,CommentMapper.class})
public interface CommentMapper {


    @Mapping(source = "comments", target = "commentReply")
    @Mapping(source = "user",target = "user",qualifiedByName = {"UserComment"})
    @Mapping(target = "blog",ignore = true)
  //  @Mapping(target = "user",ignore = true)
    CommentDTO commentDTO(Comment comment);


  // @Mapping(source = "user",target = "user",qualifiedByName = {"UserComment"})
    @Mapping(target = "blog",ignore = true)
   // @Mapping(target = "user",ignore = true)
    @Mapping(source = "commentReply", target = "comments")
    Comment DTOComment(CommentDTO commentDTO);

    List<CommentDTO> COMMENT_DTO_LIST(List<Comment> commentList);
    @Named("UserComment")
    @Mapping(target = "email",ignore = true)
    @Mapping(target = "password",ignore = true)
    @Mapping(source = "address",target = "address",ignore = true)
    @Mapping(source = "blog",target = "blogs",ignore = true)
    UserDTO userCommentDTO(User user);


}
