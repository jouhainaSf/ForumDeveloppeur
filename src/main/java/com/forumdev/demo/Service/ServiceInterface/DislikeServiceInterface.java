package com.forumdev.demo.Service.ServiceInterface;

import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Model.Post;

public interface DislikeServiceInterface
{
     Dislike getDislike(Integer integer);
    Dislike addDislike(Post post);
    Post Disliker(Post post ,String user);
}
