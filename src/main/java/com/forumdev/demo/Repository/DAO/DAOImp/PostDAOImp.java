package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Repository.DAO.PostDAO;
import com.forumdev.demo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDAOImp implements PostDAO {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findByCategorie(Categorie categorie)
    {
        return findByCategorie(categorie);
    }
    
    @Override
    public Post updatePost(Post post)
    {

        return postRepository.saveAndFlush(post);
    }

    @Override
    public Post addPost(Post post)
    {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Post post)
    {
        postRepository.delete(post);
    }
    @Override
    public Post getOne(Integer id)
    {
        return postRepository.findById(id).get();
    }



}
