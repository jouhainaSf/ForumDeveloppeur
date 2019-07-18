package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Repository.CategorieRepository;
import com.forumdev.demo.Repository.DAO.DAOImp.PostDAOImp;
import com.forumdev.demo.Repository.DAO.PostDAO;
import com.forumdev.demo.Repository.PostRepository;
import com.forumdev.demo.Service.ServiceInterface.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements PostServiceInterface
{
    @Autowired
    private PostDAO postDAO;


    @Override
    public List<Post> findByCategorie(Categorie categorie)
    {
        return postDAO.findByCategorie(categorie);
    }
    @Override
    public Post getOne(Integer id)
    {
        return postDAO.getOne(id);
    }
    @Override
    public Post updatePost(Post post)
    {
        return postDAO.updatePost(post).getBody();
    }
    @Override
    public Post addPost(Post post)
    {
        return postDAO.addPost(post).getBody();
    }
    @Override
    public void deletePost(Post post)
    {
        postDAO.deletePost(post);
    }
}
