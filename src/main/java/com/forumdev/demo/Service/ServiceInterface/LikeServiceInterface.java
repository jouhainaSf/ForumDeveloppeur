package com.forumdev.demo.Service.ServiceInterface;

import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Model.User;

public interface LikeServiceInterface
{
     Like getLike(Integer integer);
     Like addLike(Like like);
     Post liker(Post post , String user);


}
