package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Repository.CommentRepository;
import com.forumdev.demo.Repository.DAO.DAOImp.CommentDAOImp;
import com.forumdev.demo.Service.ServiceInterface.CommentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements CommentServiceInterface
{
    @Autowired
    private CommentDAOImp commentDAOImp;

    @Override
    public Comment  save(Comment s)
    {

        return commentDAOImp.save(s).getBody();
    }
    @Override
    public Comment editComment(Comment comment)
    {
        return commentDAOImp.editComment(comment).getBody();
    }
    @Override
    public void deleteComment(Comment comment)
    {
        commentDAOImp.deleteComment(comment);
    }
}
