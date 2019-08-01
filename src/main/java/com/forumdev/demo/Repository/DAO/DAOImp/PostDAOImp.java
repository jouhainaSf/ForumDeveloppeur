package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.*;
import com.forumdev.demo.Repository.DAO.*;
import com.forumdev.demo.Repository.PostRepository;
import com.forumdev.demo.Service.PostService;
import org.apache.tomcat.jni.Local;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;

@Repository
public class PostDAOImp implements PostDAO
{
    Logger logger= LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentDAO commentDAOImp;

    @Autowired
    private LikeDAO likeDAOImp;
    @Autowired
    private DislikeDAO dislikeDAOImp;
    @Autowired
    private ImageDAO imageDAOImp;
    @Autowired
    private UserDao userDAOImp;
    @Autowired
    private CategorieDAO categorieDAOImp;

    @Override
    public List<Post> findByCategorie(Categorie categorie)
    {
        return postRepository.findByCategorie(categorie);
    }

    @Override
    public ResponseEntity<Post> updatePost(Post post)
    {
        Post post1 = postRepository.getOne(post.getId_p());
        User user=userDAOImp.getUser(post1.getUser().getId_u());
        if (user.getType().equals("owner")==false)
        {
            logger.error("vous n'avez pas le droit de changer le contenue de ce post !");
            return ResponseEntity.notFound().build();
        }else if (post1.getTitle().equals(post.getTitle()) == false)
        {
            logger.error("Vous ne pouvez pas changer le titre de votre post !");
            return ResponseEntity.notFound().build();
        } else if (post1.getCategorie().getCat().equals(post.getCategorie().getCat()) == false)
        {
            logger.error("vous ne pouvez changer la categorie de votre post!");
            return ResponseEntity.notFound().build();
        } else if (post.getUser().getId_u()==null)
        {
            logger.error("Il faut indiquer l'utilisateur qui a posté ce post !");
            return ResponseEntity.notFound().build();
        }else if (post1.getUser().equals(userDAOImp.getUser(post.getUser().getId_u())) == false)
        {
                logger.error("Vous ne pouvez changer l'utilisateur de ce post !");
                return ResponseEntity.notFound().build();
        } else if (post.getDescription() == null)
        {
            logger.error("votre post doit avoir un contenue !");
            return ResponseEntity.notFound().build();

        } else
            {
            if (post.getImages() != null)
            {
                for (int i = 0; i < post.getImages().size(); i++)
                {
                    post.getImages().get(i).setPost(post);
                    imageDAOImp.uploadImage(post.getImages().get(i));
                }
            }
             post.setDateCreation(post1.getDateCreation());
             post.setTitle(post1.getTitle());
             post.setUser(post1.getUser());
             post.setCategorie(post1.getCategorie());
             post.setUser(post1.getUser());
             post.setLikes(post1.getLikes());
             post.setDislikes(post1.getDislikes());
             post.setRate(post1.getRate());
             post.setImages(post1.getImages());
                return ResponseEntity.ok(getOne(postRepository.saveAndFlush(post).getId_p()));
            }
        }


        @Override
        public ResponseEntity<Post> addPost (Post post)
        {
            if (post.getTitle() == null) {
                logger.error("Votre post doit avoir un titre !");
                return ResponseEntity.notFound().build();
            } else if (post.getDescription() == null) {
                logger.error("veuillez décrire votre probleme!");
                return ResponseEntity.notFound().build();
            } else if (post.getCategorie() == null) {
                logger.error("Veuillez choisir la categorie de votre post !");
                return ResponseEntity.notFound().build();
            } else if (post.getUser() == null) {
                logger.error("Veuillez identifie l'utilisateur de ce post !");
                return ResponseEntity.notFound().build();

            } else {
                Categorie categorie = categorieDAOImp.FindOne(post.getCategorie().getId_cat());
                post.setCategorie(categorie);
                User user = userDAOImp.getUser(post.getUser().getId_u());
                user.setType("owner");
                user= userDAOImp.updateUser(user).getBody();
                post.setUser(user);
                Post post1=postRepository.save(post);
                Like like = likeDAOImp.addLike(post1);
                Dislike dislike = dislikeDAOImp.addDislike(post1);
                post.setRate(0);
                post.setLikes(like);
                post.setDislikes(dislike);
                if (post.getImages().isEmpty() == false) {
                    for (int i = 0; i < post.getImages().size(); i++) {
                        post.getImages().get(i).setPost(post);
                        imageDAOImp.uploadImage(post.getImages().get(i));
                    }

                }
                return ResponseEntity.ok(postRepository.saveAndFlush(post));
            }
        }

    @Override
    public void deletePost(Post post)
    {
        Post post1 = postRepository.getOne(post.getId_p());
        User user=userDAOImp.getUser(post1.getUser().getId_u());

        if (user.getType().equals("owner")==false)
        {
            logger.error("vous n'avez pas le droit de supprimer ce post !");
            ResponseEntity.notFound().build();
        }else
        {
            postRepository.delete(post);
            logger.info("votre post a été bien supprimer");
        }
    }
    @Override
    public Post getOne(Integer id)
    {

        Post post= postRepository.findById(id).get();
        post.setComments(commentDAOImp.PostComments(post));
        User user = new User();
        user.setEmail(post.getUser().getEmail());
        user.setFirstName(post.getUser().getFirstName());
        user.setLastName(post.getUser().getLastName());
        user.setType(post.getUser().getType());
        post.setUser(user);
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts=postRepository.findAll();
        Post post = new Post();
        for (int i = 0; i < posts.size(); i++) {
            post = afficherPost(posts.remove(i).getId_p());
            posts.add(i, post);

        }
        return posts ;
    }

    public Post afficherPost(Integer id)
    {
        Post post= postRepository.findById(id).get();
        User user = new User();
        user.setEmail(post.getUser().getEmail());
        user.setFirstName(post.getUser().getFirstName());
        user.setLastName(post.getUser().getLastName());
        post.setUser(user);
        return post;
    }

}
