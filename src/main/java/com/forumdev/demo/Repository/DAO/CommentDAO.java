package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentDAO
{
    ResponseEntity<Comment> save(Comment s);
    ResponseEntity<Comment> editComment(Comment comment);
    void deleteComment(Comment comment);
    List<Comment> PostComments(Post post);
    Integer nbComments (Post post);
    List<Comment> getAllComment();
}
