package com.example.blogsystem.service;

import com.example.blogsystem.dto.CommentDTO;
import com.example.blogsystem.entity.Comment;
import com.example.blogsystem.exception.CustomException;
import com.example.blogsystem.mapper.CommentMapper;
import com.example.blogsystem.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }


    @Override
    public CommentDTO save(Comment comment) {
        CommentDTO save = commentMapper.commentDTO(commentRepository.save(comment));
        return save;
    }

    @Override
    public List<CommentDTO> fetchAllComments() {

        List<CommentDTO> saveComments = commentMapper.COMMENT_DTO_LIST(commentRepository.findAllComment());
       /* Set<CommentDTO> singleComment = new HashSet<>(saveComments);
        List<CommentDTO> formattedComments = new ArrayList<>(singleComment);*/

  /*      for(int index=0;index< saveComments.size();index++){
            if(saveComments.get(index).getCommentReply().size()!=0){
                for(int cmtReply=0;cmtReply<saveComments.size();cmtReply++){
                    if(saveComments.get(cmtReply).getCommentReply().size()!=0){
                        if(saveComments.get(index).getCommentReply().get(cmtReply).getId()==saveComments.get(cmtReply+1).getId()){

                        }
                    }

                }
            }
        }*/



        return saveComments;
    }

    @Override
    public void deleteComment(Long id) throws CustomException {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDTO updateComment(Comment comment, Long id) throws CustomException {
        Comment updateComment = commentRepository.findById(id).get();

        if (Objects.nonNull(comment.getCommentLine()) && !"".equalsIgnoreCase(comment.getCommentLine())) {
            updateComment.setCommentLine(comment.getCommentLine());
        }

        updateComment.setCommentDate(new Timestamp(System.currentTimeMillis()));
        CommentDTO updateCommentDTO = commentMapper.commentDTO(commentRepository.save(updateComment));
        return updateCommentDTO;
    }
}
