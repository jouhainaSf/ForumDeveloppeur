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
    public ResponseEntity<Post> Disliker (Post post2 ,String user1) {
        Integer id_u=Integer.parseInt(user1);
        Post post1=postRepository.findById(post2.getId_p()).get();
        Dislike dislike=dislikeRepository.findById(post1.getDislikes().getId_dis()).get();
        User user=userRepository.findById(id_u).get();
        Dislike dislike1= dislikeRepository.fingByPost(dislike.getPost());
        List<User> users=dislike.getUsers();
        if (users.contains(user)==true)
        {
            logger.error("tu as déjà aimé ce post !");
            return ResponseEntity.notFound().build();
        }else if (user.equals(dislike1.getPost().getUser()))
        {
            logger.error("tu ne peux pas aimé ton propre post -_- !");
            return ResponseEntity.notFound().build();
        } else
        {
            Post post=postRepository.findById(dislike.getPost().getId_p()).get();
            users.add(user);
            dislike1.setUsers(users);
            user.getDislikes().add(dislike1);
            dislike1.setDislikes(dislike1.getDislikes()+1);
            post.setDislikes(dislike1);
            Integer rate = post.getLikes().getLikes() * 100 / (post.getLikes().getLikes() + post.getDislikes().getDislikes());
            post.setRate(rate);
            dislike1.setPost(post);
            Post post3 = postRepository.saveAndFlush(post);
            return ResponseEntity.ok(post);
        }
    }

    @Override
    public Dislike findByPost(Post post)
    {
       return dislikeRepository.fingByPost(post);
    }
}
