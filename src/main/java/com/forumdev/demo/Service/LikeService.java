package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Repository.DAO.DAOImp.LikeDAOImp;
import com.forumdev.demo.Service.ServiceInterface.LikeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class LikeService implements LikeServiceInterface
{

    @Autowired
    private LikeDAOImp likeDAOImp;


    @Override
    public Like getLike(Integer integer) {
        return likeDAOImp.getLike(integer);
    }

    @Override
    public Like addLike(Like like) {
        return likeDAOImp.addLike(like);
    }

    @Override
    public Like liker(Post post) {
        return likeDAOImp.liker(post);
    }


}
