package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer>
{
    @Override
    Comment save(Comment s);

    @Override
    Comment saveAndFlush(Comment s);

    @Override
    void deleteById(Integer integer);

    @Query("select c from Comment c where c.post=:post")
    List<Comment> getCommentByPost(@Param("post") Post post);

    @Query("select c from Comment c where c.user=:user")
    List<Comment> getCommentsByUser(@Param("user")User user);
    @Override
    List<Comment> findAll();
}
