package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Repository.CategorieRepository;
import com.forumdev.demo.Repository.DAO.DAOImp.PostDAOImp;
import com.forumdev.demo.Repository.PostRepository;
import com.forumdev.demo.Service.ServiceInterface.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements PostServiceInterface
{
    @Autowired
    private PostDAOImp postDAOImp;


    @Override
    public List<Post> findByCategorie(Categorie categorie)
    {
        return postDAOImp.findByCategorie(categorie);
    }
    @Override
    public Post getOne(Integer id)
    {
        return postDAOImp.getOne(id);
    }
   /* @Override
    public Post addLike(Post p)
    {
        p.setLikes(p.getLikes()+1);
        return postRepository.saveAndFlush(p);

    }
    @Override
    public Post addDislike(Post p)
    {
        p.setDislikes(p.getDislikes()+1);
        return postRepository.saveAndFlush(p);

    }
    @Override
    public Post updateRate(Post p)
    {
        int like=p.getLikes();
        int dislike = p.getDislikes();
        int rate= (like * 100) / (like + dislike);
        p.setRate(rate);
        return postRepository.saveAndFlush(p);
    }
    */
    @Override
    public Post updatePost(Post post)
    {
        return postDAOImp.updatePost(post);
    }
    @Override
    public Post addPost(Post post)
    {
        return postDAOImp.addPost(post);
    }
    @Override
    public void deletePost(Post post)
    {
        postDAOImp.deletePost(post);
    }
}
