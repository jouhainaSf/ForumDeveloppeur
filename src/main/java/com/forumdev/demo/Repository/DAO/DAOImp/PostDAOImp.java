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


    public Post updatePost(Post post)
    {
        return postRepository.saveAndFlush(post);
    }

    public Post addPost(Post post)
    {
        return postRepository.save(post);
    }

    public void deletePost(Post post)
    {
        postRepository.delete(post);
    }
    public Post getOne(Integer id)
    {
        return postRepository.findById(id).get();
    }


}
