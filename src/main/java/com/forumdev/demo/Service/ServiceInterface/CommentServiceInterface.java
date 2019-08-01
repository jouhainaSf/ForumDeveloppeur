package com.forumdev.demo.Service.ServiceInterface;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.Post;

import java.util.List;

public interface CommentServiceInterface
{
    Comment save(Comment s);
    Comment editComment(Comment comment);
    void deleteComment(Comment comment);
    Integer nbComment(Post post);
    List<Comment> getComments(Post post);
    List<Comment> getAllComment();
}
