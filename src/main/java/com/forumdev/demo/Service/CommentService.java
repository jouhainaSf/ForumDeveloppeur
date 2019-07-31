package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Repository.CommentRepository;
import com.forumdev.demo.Repository.DAO.CommentDAO;
import com.forumdev.demo.Repository.DAO.DAOImp.CommentDAOImp;
import com.forumdev.demo.Service.ServiceInterface.CommentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements CommentServiceInterface
{
    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Comment  save(Comment s)
    {

        return commentDAO.save(s).getBody();
    }
    @Override
    public Comment editComment(Comment comment)
    {
        return commentDAO.editComment(comment).getBody();
    }
    @Override
    public void deleteComment(Comment comment)
    {
        commentDAO.deleteComment(comment);
    }

    @Override
    public Integer nbComment(Post post) {
        return commentDAO.nbComments(post);
    }

    @Override
    public List<Comment> getComments(Post post) {
        return commentDAO.PostComments(post);
    }

}
