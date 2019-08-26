package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;
import org.springframework.http.ResponseEntity;

public interface DislikeDAO
{
    ResponseEntity<Post> Disliker (Post post ,String user);
    Dislike getDislike(Integer integer);
    Dislike findByPost(Post post);
    Dislike addDislike(Post post);


}
