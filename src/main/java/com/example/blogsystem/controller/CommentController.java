package com.example.blogsystem.controller;

import com.example.blogsystem.entity.Comment;
import com.example.blogsystem.exception.CustomException;
import com.example.blogsystem.repository.CommentRepository;
import com.example.blogsystem.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private final CommentService commentService;
    private final CommentRepository commentRepository;

    public CommentController(CommentService commentService,
                             CommentRepository commentRepository) {
        this.commentService = commentService;
        this.commentRepository = commentRepository;
    }

    @PostMapping("/saveComment")
    public ResponseEntity<?>save(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.save(comment), HttpStatus.CREATED);
    }

    @GetMapping("/getComments")
    public ResponseEntity<?>fetchAllComments(){
        return new ResponseEntity<>(commentService.fetchAllComments(),HttpStatus.OK);
    }


    @DeleteMapping("/deleteComment/{id}")
    public String deleteCommentById(@PathVariable("id") Long id)throws CustomException {
        commentService.deleteComment(id);
        return "Successfully deleted comment with Id:"+id;
    }

    @PatchMapping("/updateComment/{id}")
    public ResponseEntity<?>updateComment(@RequestBody Comment comment, @PathVariable("id") Long id)throws CustomException{
        return new ResponseEntity<>(commentService.updateComment(comment,id),HttpStatus.OK);
    }


}
