package com.example.blogsystem.service;

import com.example.blogsystem.dto.CommentDTO;
import com.example.blogsystem.entity.Comment;
import com.example.blogsystem.exception.CustomException;

import java.util.List;

public interface CommentService {
    CommentDTO save(Comment comment);
    List<CommentDTO> fetchAllComments();


    void deleteComment(Long id)throws CustomException;

    CommentDTO updateComment(Comment comment,Long id)throws CustomException;
}
