package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostDAO
{
    List<Post> findByCategorie(Categorie categorie);
    ResponseEntity<Post> updatePost(Post post);
    ResponseEntity<Post> addPost(Post post);
    void deletePost(Post post);
    Post getOne(Integer id);
    List<Post> getAllPosts();
    List<Post> findByUser(User user);
}
