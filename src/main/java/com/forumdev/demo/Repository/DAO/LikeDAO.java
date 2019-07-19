package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;
import org.springframework.http.ResponseEntity;

public interface LikeDAO

{
    Like getLike(Integer integer);
    Like addLike(Post post);
    Like findByPost(Post post);
    ResponseEntity<Integer> liker(Like like);

}
