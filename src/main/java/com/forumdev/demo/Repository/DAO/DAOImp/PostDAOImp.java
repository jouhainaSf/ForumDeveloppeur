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
    @Autowired
    private ImageDAOImp imageDAOImp;
    @Autowired
    private UserDAOImp userDAOImp;
    @Autowired
    private CategorieDAOImp categorieDAOImp;

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


             if(post.getDislikes().getDislikes()!=0 || post.getLikes().getLikes()!=0)
             {
                 Integer rate = post.getLikes().getLikes() * 100 / (post.getLikes().getLikes() + post.getDislikes().getDislikes());
                 post.setRate(rate);

             }else
             {
                 post.setRate(post1.getRate());
             }

             post.setDateCreation(post1.getDateCreation());
             post.setTitle(post1.getTitle());
             post.setUser(post1.getUser());
             post.setCategorie(post1.getCategorie());
             post.setUser(post1.getUser());
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
        postRepository.delete(post);
    }
    @Override
    public Post getOne(Integer id)
    {

        Post post= postRepository.findById(id).get();
        post.setComments(commentDAOImp.PostComments(post).getBody());
        User user = new User();
        user.setEmail(post.getUser().getEmail());
        user.setFirstName(post.getUser().getFirstName());
        user.setLastName(post.getUser().getLastName());
        user.setType(post.getUser().getType());
        post.setUser(user);
        return post;
    }



}
