package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;

public interface DislikeDAO
{
    Dislike Disliker(Post post);
    Dislike getDislike(Integer integer);
    Dislike findByPost(Post post);
    Dislike addDislike(Post post);


}
