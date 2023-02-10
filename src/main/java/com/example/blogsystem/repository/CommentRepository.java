package com.example.blogsystem.repository;

import com.example.blogsystem.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(
            value = "SELECT * FROM blogdatabase.comment where comment_id is null",
            nativeQuery = true)
    List<Comment> findAllComment();

}
