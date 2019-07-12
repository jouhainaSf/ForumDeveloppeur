package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.Comment;

public interface CommentDAO
{
    Comment save(Comment s);
    Comment editComment(Comment comment);
    void deleteComment(Comment comment);
}
