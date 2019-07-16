package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.*;
import com.forumdev.demo.Repository.DAO.PostDAO;
import com.forumdev.demo.Repository.PostRepository;
import com.forumdev.demo.Service.PostService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.slf4j.Logger;

@Repository
public class PostDAOImp implements PostDAO
{
    Logger logger= LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentDAOImp commentDAOImp;

    @Autowired
    private LikeDAOImp likeDAOImp;
    @Autowired
    private DislikeDAOImp dislikeDAOImp;

    @Override
    public List<Post> findByCategorie(Categorie categorie)
    {
        return postRepository.findByCategorie(categorie);
    }

    @Override
    public Post updatePost(Post post)
    {
        return postRepository.saveAndFlush(post);
    }

    @Override
    public ResponseEntity<Post> addPost(Post post)
    {
        if (post.getTitle()==null)
        {
            logger.error("Votre post doit avoir un titre !");
            return ResponseEntity.notFound().build();
        }else if(post.getDescription()==null)
        {
            logger.error("veuillez décrire votre probleme!");
            return ResponseEntity.notFound().build();
        }else if (post.getCategorie()==null)
        {
            logger.error("Veuillez choisir la categorie de votre post !");
            return ResponseEntity.notFound().build();
        }else if (post.getUser()==null)
        {
            logger.error("Veuillez identifie l'utilisateur de ce post !");
            return ResponseEntity.notFound().build();
        }else
        {
           Like like= likeDAOImp.addLike(post);
           Dislike dislike= dislikeDAOImp.addDislike(post);
            post.setRate(0);

            return ResponseEntity.ok(postRepository.save(post));


        }

    }


    @Override
    public void deletePost(Post post)
    {
        postRepository.delete(post);
    }
    @Override
    public Post getOne(Integer id)
    {

        Post post= postRepository.findById(id).get();
        post.setComments(commentDAOImp.PostComments(post).getBody());
        return post;
    }



}
