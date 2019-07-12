package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Repository.CommentRepository;
import com.forumdev.demo.Repository.DAO.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImp implements CommentDAO
{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment save(Comment s)
    {
        return commentRepository.save(s);
    }
    @Override
    public Comment editComment(Comment comment)
    {
        return commentRepository.saveAndFlush(comment);
    }
    @Override
    public void deleteComment(Comment comment)
    {
        commentRepository.deleteById(comment.getId_com());
    }
}
