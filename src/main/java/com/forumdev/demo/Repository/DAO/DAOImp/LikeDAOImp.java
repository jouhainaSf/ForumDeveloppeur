package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Model.User;
import com.forumdev.demo.Repository.DAO.LikeDAO;
import com.forumdev.demo.Repository.LikesRepository;
import com.forumdev.demo.Repository.PostRepository;
import com.forumdev.demo.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LikeDAOImp implements LikeDAO
{

    private Logger logger= LoggerFactory.getLogger(LikeDAOImp.class);

    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Like getLike(Integer integer)
    {
        return likesRepository.findById(integer).get();
    }
    @Override
    public Like addLike(Post post)
    {
            Like like=new Like();
            like.setLikes(0);
            like.setPost(post);
            return likesRepository.save(like);
    }

    @Override
    public Like findByPost(Post post)
    {
        return likesRepository.fingByPost(post);
    }

    @Override
    public ResponseEntity<Integer> liker(Like like) {
        if (like.getPost().getId_p().equals(null)==true)
        {
            logger.error("Il faut indiquer le post !");
            return ResponseEntity.notFound().build();
        }else if (like.getUsers().isEmpty()==true)
        {
            logger.error("il faut indiquer l'utilsateur qui a liké ce post");
            return ResponseEntity.notFound().build();
        }else
        {
            User user=userRepository.findById(like.getUsers().get(0).getId_u()).get();
            Like like1=likesRepository.fingByPost(like.getPost());
            List<User> users=like1.getUsers();
            if (users.contains(user)==true)
            {
                logger.error("tu as déjà aimé ce post !");
                return ResponseEntity.notFound().build();
            }else if (user.equals(like1.getPost().getUser()))
            {
                logger.error("tu ne peux pas aimé ton propre post -_- !");
                return ResponseEntity.notFound().build();
            } else
            {
                users.add(user);
                like1.setUsers(users);
                user.getLikes().add(like1);
                like1.setLikes(like1.getLikes()+1);
                return ResponseEntity.ok(likesRepository.save(like1).getLikes());
            }
        }
    }
}
