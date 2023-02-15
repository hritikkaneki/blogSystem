package com.example.blogsystem.dto;

import com.example.blogsystem.entity.Comment;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDTO {
    private Long id;
    private String commentLine;
    private Date commentDate;
    private BlogDTO blog;
    private List<CommentDTO> commentReply;

    private UserDTO user;
}
