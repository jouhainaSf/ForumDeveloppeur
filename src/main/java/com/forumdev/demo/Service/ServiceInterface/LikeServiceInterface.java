package com.forumdev.demo.Service.ServiceInterface;

import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;

public interface LikeServiceInterface
{
     Like getLike(Integer integer);
     Like addLike(Like like);
     Integer liker(Like like);


}
