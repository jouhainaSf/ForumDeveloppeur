package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Model.User;
import com.forumdev.demo.Repository.DAO.DislikeDAO;
import com.forumdev.demo.Repository.DAO.PostDAO;
import com.forumdev.demo.Repository.DislikeRepository;
import com.forumdev.demo.Repository.PostRepository;
import com.forumdev.demo.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DislikeDAOImp  implements DislikeDAO
{
    private Logger logger= LoggerFactory.getLogger(DislikeDAOImp.class);
    @Autowired
    private DislikeRepository dislikeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Dislike addDislike(Post post) {
        Dislike dislike=new Dislike();
        dislike.setDislikes(0);
        dislike.setPost(post);
        return dislikeRepository.save(dislike);
    }

    @Override
    public Dislike getDislike(Integer integer)
    {
        return dislikeRepository.findById(integer).get();
    }
    @Override
    public ResponseEntity<Integer> Disliker (Dislike dislike) {
        if (dislike.getPost().getId_p().equals(null)==true)
        {
            logger.error("Il faut indiquer le post !");
            return ResponseEntity.notFound().build();
        }else if (dislike.getUsers().isEmpty()==true)
        {
            logger.error("il faut indiquer l'utilsateur qui a disliké ce post");
            return ResponseEntity.notFound().build();
        }else
        {
            User user=userRepository.findById(dislike.getUsers().get(0).getId_u()).get();
            Dislike dislike1=dislikeRepository.fingByPost(dislike.getPost());
            Post post=postRepository.findById(dislike.getPost().getId_p()).get();
            List<User> users=dislike1.getUsers();
            if (users.contains(user)==true)
            {
                logger.error("tu as déjà disliker ce post !");
                return ResponseEntity.notFound().build();
            }else if (user.equals(dislike1.getPost().getUser()))
            {
                logger.error("tu ne peux pas aimé ton propre post -_- !");
                return ResponseEntity.notFound().build();
            } else
            {
                users.add(user);
                dislike1.setUsers(users);
                user.getDislikes().add(dislike1);
                dislike1.setDislikes(dislike1.getDislikes()+1);
                post.setDislikes(dislike1);
                Integer rate = post.getLikes().getLikes() * 100 / (post.getLikes().getLikes() + post.getDislikes().getDislikes());
                post.setRate(rate);
                dislike1.setPost(post);
                postRepository.saveAndFlush(post);
                return ResponseEntity.ok(dislikeRepository.save(dislike1).getDislikes());
            }
        }
    }

    @Override
    public Dislike findByPost(Post post)
    {
       return dislikeRepository.fingByPost(post);
    }
}
