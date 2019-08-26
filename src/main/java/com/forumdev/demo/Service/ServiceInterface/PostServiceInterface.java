package com.forumdev.demo.Service.ServiceInterface;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Model.User;

import java.util.List;

public interface PostServiceInterface
{
    List<Post> findByCategorie(Categorie categorie);
    Post getOne(Integer id);
    Post updatePost(Post post);
    Post addPost(Post post);
    void deletePost(Post post);
    List<Post> getAllPosts();
    List<Post> findByUser(User user);
}
