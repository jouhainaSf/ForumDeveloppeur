package com.forumdev.demo.Service.ServiceInterface;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Model.Post;

import java.util.List;

public interface PostServiceInterface
{
    List<Post> findByCategorie(Categorie categorie);
    Post getOne(Integer id);
    //Post addLike(Post p);
    //Post addDislike(Post p);
    //Post updateRate(Post p);
    Post updatePost(Post post);
    Post addPost(Post post);
    void deletePost(Post post);
}
