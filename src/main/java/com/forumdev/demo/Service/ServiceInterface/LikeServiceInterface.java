package com.forumdev.demo.Service.ServiceInterface;

import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;

public interface LikeServiceInterface
{
    public Like getLike(Integer integer);
    public Like addLike(Like like);
    public Like liker(Post post);


}
