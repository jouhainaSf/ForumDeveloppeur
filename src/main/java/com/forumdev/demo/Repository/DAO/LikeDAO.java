package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;

public interface LikeDAO

{
    Like getLike(Integer integer);
    Like addLike(Post post);
    Like findByPost(Post post);
    Like liker(Post post);


}
