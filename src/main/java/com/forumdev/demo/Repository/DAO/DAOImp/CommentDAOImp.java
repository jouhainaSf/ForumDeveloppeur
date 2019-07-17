package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Repository.CommentRepository;
import com.forumdev.demo.Repository.DAO.CommentDAO;
import com.forumdev.demo.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAOImp implements CommentDAO
{
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private CommentRepository commentRepository;


    @Autowired
    private UserDAOImp userDAOImp;

    @Override
    public ResponseEntity<Comment> save(Comment s)
    {
        if (s.getContenue()==null)
        {
            logger.error("Veuillez remplir le contenue de votre commentaire");
            return ResponseEntity.notFound().build();

        }else if (s.getPost()==null)
        {
            logger.error("Veuillez spécifier le post que vous voulez commenter !");
            return ResponseEntity.notFound().build();
        }else if (s.getUser()==null)
        {
            logger.error("Veuillez spécifier l'utilisateur qui a commenté !");
            return ResponseEntity.notFound().build();
        }else
        {
            return ResponseEntity.ok(commentRepository.save(s));
        }

    }
    @Override
    public ResponseEntity<Comment> editComment(Comment comment)
    {
        Comment comment1=commentRepository.findById(comment.getId_com()).get();
        if (comment1.getUser().equals(comment.getUser())==false)
        {
            logger.error("vous ne pouvez pas changer l'utilisateur");
            return ResponseEntity.notFound().build();
        }else if (comment1.getPost().equals(comment.getPost())==false)
        {
            logger.error("vous ne pouvez pas changer le post");
            return ResponseEntity.notFound().build();
        }else if (comment.getContenue()==null)
        {
            logger.error("Vous ne pouvez publier un commentaire vide");
            return ResponseEntity.notFound().build();
        }else
        {
            return ResponseEntity.ok(commentRepository.saveAndFlush(comment));
        }
    }
    @Override
    public void deleteComment(Comment comment)
    {
        commentRepository.deleteById(comment.getId_com());
    }

    @Override
    public ResponseEntity<List<Comment>> PostComments(Post post) {


        List<Comment>comments=commentRepository.getCommentByPost(post);
        if(comments==null)
        {

             ResponseEntity.notFound().build();
             return null;
        }
        else{
            Comment comment=new Comment();

            for (int i=0; i<comments.size();i++)
            {
                comments.get(i).setUser(userDAOImp.afficherUser(comments.get(i).getUser()));

            }
            return ResponseEntity.ok(comments);

        }
    }
}
