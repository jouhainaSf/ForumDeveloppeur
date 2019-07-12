package com.forumdev.demo.Service.ServiceInterface;

import com.forumdev.demo.Model.Comment;

public interface CommentServiceInterface
{
    Comment save(Comment s);
    Comment editComment(Comment comment);
    void deleteComment(Comment comment);
}
