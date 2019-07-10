package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService
{
    @Autowired
    private CommentRepository commentRepository;

    public Comment  save(Comment s) {
        return commentRepository.save(s);
    }

    public Comment editComment(Comment comment)
    {
        return commentRepository.saveAndFlush(comment);
    }

    public void deleteComment(Comment comment)
    {
        commentRepository.deleteById(comment.getId_com());
    }
}
