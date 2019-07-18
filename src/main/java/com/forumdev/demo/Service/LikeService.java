package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Repository.DAO.DAOImp.LikeDAOImp;
import com.forumdev.demo.Repository.DAO.LikeDAO;
import com.forumdev.demo.Service.ServiceInterface.LikeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService implements LikeServiceInterface
{

    @Autowired
    private LikeDAO likeDAO;


    @Override
    public Like getLike(Integer integer) {
        return likeDAO.getLike(integer);
    }

    @Override
    public Like addLike(Like like) {
        return likeDAO.addLike(like.getPost());
    }

    @Override
    public Integer liker(Like like)
    {
        return likeDAO.liker(like).getBody();
    }


}
